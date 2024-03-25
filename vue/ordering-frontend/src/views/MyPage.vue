<template>
    <div class="container">
        <div class="page-header"  style="margin-top : 20 px"><h1>주문 목록</h1></div>
        <table class="table">
            <tr>
                <td>이름</td>
                <td>{{ memberInfo.name }}</td>
            </tr>
            <tr>
                <td>email</td>
                <td>{{ memberInfo.email }}</td>
            </tr>
            <tr>
                <td>도시</td>
                <td>{{ memberInfo.city }}</td>
            </tr>
            <tr>
                <td>상세주소</td>
                <td>{{ memberInfo.street }}</td>
            </tr>
            <tr>
                <td>우편정보</td>
                <td>{{ memberInfo.zipcode }}</td>
            </tr>
        </table>
    </div>

    <OrderListComponent
    :isAdmin="false"
    apiUrl="/member/myorders"
    />
</template>

<script>
import OrderListComponent from '@/components/OrderListComponent1.vue';
import axios from 'axios'

export default {
    components: { 
        OrderListComponent 
    },
    
    data(){
        return{ 
            memberInfo: {},                             //객체 -> {}, 배열 ->[]
        }
    },
    created(){
        this.fetchMember();
    },

    methods: {
        async fetchMember(){
            try {
                const token = localStorage.getItem('token');
                const headers= token ? {Authorization: `Bearer ${token}`} : {};       //`` : js 변수 동적으로 사용할때 
                const response = await axios.get(`${process.env.VUE_APP_BASE_URL}/member/myInfo`, {headers});
                this.memberList= response.data;
            } catch(error){
                console.log(error);
            }
        }
    }
}
</script>
