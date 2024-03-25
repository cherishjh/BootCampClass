<template>
    <div class="container">
        <div class="page-header"  style="margin-top : 20 px"><h1>{{ pageTitle }}</h1></div>
        <div class="d-flex justify-content-between" style="margin-top:20px">
            <form @submit.prevent="searchItems">
                <select v-model="searchType" class="form-control" style="display: inline-block; width:auto; margin-right: 5px">
                    <option value="optional">선택</option>
                    <option value="name">상품명</option>
                    <option value="category">카테고리</option>
                </select>
                <input v-model="searchValue" type="text"/>
                <button type="submit"> 검색</button>
            </form>
            <div v-if="!isAdmin">
                <button @click="addCart" class="btn btn-secondary">장바구니</button>
                <button @click="placeOrder" class="btn btn-success">주문하기</button>
            </div>
            <div v-if="isAdmin">
                <a href="/item/create"><button class="btn btn-secondary">상품등록</button></a>
            </div>
        </div>
        
        <table class="table">
            <thead>
                <tr>
                    <th v-if="!isAdmin"></th>
                    <th>제품사진</th>
                    <th>제품명</th>
                    <th>수량</th>
                    <th>재고수량</th>
                    <th v-if="!isAdmin">주문수량</th>
                    <th v-if="isAdmin">Action</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="item in itemList" :key="item.id">
                    <!-- checkbox를 선택하면 value에 true가 담기게 됨 -->
                    <td v-if="!isAdmin"><input type="checkbox" v-model="selectedItems[item.id]"/></td>
                    <td><img :src="getImage(item.id)" style="height: 100px; width:auto;"/></td>
                    <td>{{ item.name }}</td>
                    <td>{{ item.price }}</td>
                    <td>{{ item.stockQuantity }}</td>
                    <td v-if="!isAdmin"><input type="number" min="1" v-model="item.quantity" style="width: 60px" /></td>
                    <td v-if="isAdmin"><button @click="deleteItem(itemId)" class="btn btn-secondary">삭제</button></td>
                </tr>
            </tbody>
        </table>
    
    </div>

</template>

<script>
import axios from 'axios';
import { mapActions } from 'vuex';

export default {
    props: ['isAdmin', 'pageTitle'],
    data(){
        return{ 
            itemList: [],
            pageSize: 20,                //스크롤이 없어지면(축소, 확대) 데이터가 안 가져와 짐 -> 이 코드를 보완해야 함
            currentPage: 0,
            searchType: 'name',
            searchValue: '',
            isLastPage: false,
            selectedItems: {}
        }
    }, 
    created(){
        this.loadItems();
    },
    //mounted: window dom 객체가 생성된 이후에 실행되는 hook 함수 
    
    mounted(){
        // scroll 동작이 발생할 때마다 scrollPagination 함수 호출  
        window.addEventListener('scroll', this.scrollPagination);
    },

    methods: {
        ...mapActions(['addToCart']),
        addCart(){
            const orderItems= Object.keys(this.selectedItems)
                                    .filter(key=>this.selectedItems[key]===true)
                                    .map(key => { 
                                        const item = this.itemList.find(item=> item.id == key)          // == : 값만, === : 타입까지 
                                        return {itemId: item.id, name: item.name, count: item.quantity}
                                        });
            // mutation 직접 호출 방식
            // orderItems.forEach(item => this.$store.commit('addToCart', item));
            //actions 직접 호출 방식
            orderItems.forEach(item => this.$store.dispatch('addToCart', item));                         
        },

        async placeOrder(){
            // 이 구조는 일일히 찍어보면서 파악 : console.log(this.selectedItems);
        //     {
        //         "1" : true,
        //         "2" : false,
        //     }
        // Object.keys : 위의 데이터 구조에서 1,2 등 key 값 추출하는 메서드
        // {orderReqItemDtos: [{itemId:1, count:2},{itemId:2, count:10} ]}   현재 데이터 구조 (orderReqItemDtos가 list 형태)
        
        
            const orderItems= Object.keys(this.selectedItems)
                                    .filter(key=>this.selectedItems[key]===true)
                                    .map(key => { 
                                        const item = this.itemList.find(item=> item.id == key)          // == : 값만, === : 타입까지 
                                        return {itemId: item.id, count: item.quantity}
                                        });
            if(orderItems.length <1 ){
                alert("선택된 제품이 없습니다.")
                return;
            } 
            if(!confirm(`${this.getTotalQuantity}개의 상품을 주문하시겠습니까?`)){
                console.log("주문이 취소되었습니다.")
                return;
            }
            const token = localStorage.getItem('token');
            const headers= token ? {Authorization: `Bearer ${token}`} : {};
            // orderItem 그대로 쓰는 방식
            try{
                await axios.post(`${process.env.VUE_APP_BASE_URL}/order/new`, orderItems ,{headers})
                console.log(orderItems);
                alert("주문 완료되었습니다.");
                window.location.reload();
            } catch(error){
                console.log(error);
                alert("주문이 실패되었습니다.");
            }

            //데이터 형식 맞춰주기
            // const orderReqItemDtos = orderItems;    
            // await axios.post(`${process.env.VUE_APP_BASE_URL}/order/create`, {orderReqItemDtos} ,{headers})
            
        },
        searchItems(){
            this.itemList=[];
            this.selectedItems =[];
            this.currentPage=0;
            this.isLastPage=false;
            this.isLoading= false;
            this.loadItems();
        },
        scrollPagination(){
            // innerHeight: 뷰포트(사용자에게 보이는 창) 창의 내부 높이를 픽셀 단위로 변환
            // scrollY : 스크롤을 통해 Y 축을 이동한 거리 
            // offsetHeight : 전체 브라우저 창의 높이 
            const nearBottom= window.innerHeight + window.scrollY >= document.body.offsetHeight - 500;
            if(nearBottom && !this.isLastPage && !this.isLoading){
                this.currentPage++;
                this.loadItems();
            }
        },
        
        getImage(id){
            return `${process.env.VUE_APP_BASE_URL}/item/${id}/image`;
        }, 
        async loadItems(){
            this.isLoading = true;
            try{
            // params 키워드 사용해야 파라미터 방식으로 axios 요청 가능 
                const params = {
                    page: this.currentPage,
                    size: this.pageSize,
                    // [this.searchType] : this.searchValue    []의 의미는 값을 꺼내겠다는 의미 
                }
                if(this.searchType === "name"){
                    params.name= this.searchValue;
                } else if(this. searchType === "category"){
                    params.category = this.searchValue;
                }
                console.log(params);
                const response = await axios.get(`${process.env.VUE_APP_BASE_URL}/items`,{params});  
                const addItemList = response.data.map(item=>({...item,quantity:1, }))   //quantity: 1씩 깔아주려고 ; 이렇게 쓰면 ''... item'은 객체
                if(addItemList.length < this.pageSize){
                    this.isLastPage= true;
                }
                this.itemList= [...this.itemList, ... addItemList];
            } catch(error){
                console.log(error);
            }
            this.isLoading= false;
        },

        async deleteItem(itemId){
            if(confirm("정말로 삭제하시겠습니까?")){
                const token = localStorage.getItem('token');
                const headers= token ? {Authorization: `Bearer ${token}`} : {};
                axios.delete(`${process.env.VUE_APP_BASE_URL}/${itemId}/delete`,{headers});
                window.location.reload();
            }
        }
    }
}
</script>
