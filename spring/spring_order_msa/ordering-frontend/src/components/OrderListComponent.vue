<template>
    <div class="container">
        <div class="page-header"  style="margin-top : 20 px"><h1>주문 목록</h1></div>
        <table class="table">
            <tr>
                <td>이름</td>
                <td></td>
            </tr>
            <tr>
                <td>email</td>
                <td></td>
            </tr>
            <tr>
                <td>도시</td>
                <td></td>
            </tr>
            <tr>
                <td>상세주소</td>
                <td></td>
            </tr>
            <tr>
                <td>우편정보</td>
                <td></td>
            </tr>
        </table>
    </div>
</template>

<script>
import axios from 'axios';
 
export default {
    props: ['isAdmin', 'apiUrl'],

    data(){
        return{ 
            orderList: [],
            visibleOrder: new Set(), 
        }
    },

    async created(){
        try{
            const token = localStorage.getItem('token');
            const headers= token ? {Authorization: `Bearer ${token}`} : {};       //`` : js 변수 동적으로 사용할때 
            const response = await axios.get(`${process.env.VUE_APP_BASE_URL}${this.apiUrl}`, {headers});
            this.orderList= response.data;
        } catch(error){
            console.log(error);
        }
    },
    // 사용자 정의 메서드 
    methods: {
        toggleOrder(orderId){
            if(this.visibleOrder.has(orderId)){
                this.visibleOrder.delete(orderId)
            } else {
                this.visibleOrder.add(orderId)
            }
        },
        async cancelOrder(orderId){
            if(confirm("정말 삭제하시겠습니까?")){
                try{
                    const token = localStorage.getItem('token')
                    const headers= token ? {Authorization: `Bearer ${token}`} : {};   
                    await axios.delete(`http://localhost:8080/order/${orderId}/cancel`, {headers});
                    const order = this.orderList.find(order => order.id == orderId);
                    order.orderStatus= "CANCELED";
                } catch(error){
                    console.log(error);
                    alert("주문 취소에 실패했습니다.")
                }
            }
        }
    }
}
</script>
