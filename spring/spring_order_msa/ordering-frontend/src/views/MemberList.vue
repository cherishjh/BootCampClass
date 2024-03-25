<template>
    <div class="container">
        <div class="page-header"  style="margin-top : 20 px"><h1>회원 목록</h1></div>
        <table class="table">
            <thead>
            <tr>
                <th>id</th>
                <th>이름</th>
                <th>email</th>
                <th>주문수량</th>
            </tr>
            </thead>
            <tbody>
                <tr v-for="member in memberList" :key="member.id">
                    <td >{{member.id}}</td>
                    <td >{{member.name}}</td>
                    <td >{{member.email}}</td>
                    <td >
                        <a :href="`/member/${member.id}/orders`">{{member.orderCount}}</a>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
</template>

<script>
import axios from 'axios';
export default {
    data(){
        return{ 
            memberList: [],
        }
    },
    async created(){
        try{
            const token = localStorage.getItem('token');
            const headers= token ? {Authorization: `Bearer ${token}`} : {};       //`` : js 변수 동적으로 사용할때 
            // const response = await axios.get("http://localhost:8080/members", {headers});
            const response = await axios.get(`${process.env.VUE_APP_BASE_URL}/members`, {headers});
            this.memberList= response.data;
        } catch(error){
            console.log(error);
        }
    }
}
</script>

<style lang="scss" scoped>

</style>