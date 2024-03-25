<template>
    <div class="container">
        <div class="page-header">
            <h1>상품 등록</h1>
        </div>
            <form @submit.prevent="itemCreate">
                <div class="form-group">
                    <label> 상품명 </label>
                    <input type="text" id="name" v-model="name" class="form-control" name="name" >
                </div>
                <div class="form-group">
                    <label> 카테고리 </label>
                    <input type="text" id="category" v-model="category" class="form-control" name="category" >
                </div>
                <div class="form-group">
                    <label> 가격 </label>
                    <input type="number" id="price" v-model="price" class="form-control" name="price" >
                </div>
                <div class="form-group">
                    <label> 재고수량 </label>
                    <input type="number" id="stockQuantity" v-model="stockQuantity" class="form-control" name="stockQuantity" >
                </div>
                <div class="form-group">
                    <label> 상품이미지 </label>
                    <!-- @change와 @click의 비교: 
                         @click은 요소가 클릭될 때마다 이벤트함수 실행 
                         @change는 해당 태그의 값이 변할때 함수 실행
                    -->
                    <input type="file" class="form-control" accept="image/*" @change="fileUpload" >
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary mt-3">상품등록</button>
                </div>
            </form>
    </div>
</template>

<script>
import axios from "axios";
export default {
    data(){
        return {
            name: "",
            category: "",
            price: null, 
            stockQuantity: null,
            itemImage: null,
        }
    },
    methods:{
        fileUpload(event){
            // event.target : 이벤트가 발생한 DOM 요소를 가르키는 객체 
            this.itemImage = event.target.files[0];
        },
        async itemCreate(){
            // multi-part formdata형식의 경우 new FormData를 통해 객체 생성 
            const registerData = new FormData();
            registerData.append("name", this.name)
            registerData.append("category", this.category)
            registerData.append("price", this.price)
            registerData.append("stockQuantity", this.stockQuantity)
            registerData.append("itemImage", this.itemImage)
            const token = localStorage.getItem('token');
            const headers= token ? {Authorization: `Bearer ${token}`} : {};
            await axios.post(`${process.env.VUE_APP_BASE_URL}/item/create`, registerData, {headers});
            
            this.$router.push("/items/manage");
        }
    }
}
</script>
