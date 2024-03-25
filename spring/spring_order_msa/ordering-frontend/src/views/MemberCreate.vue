<template>
    <div class="container">
        <div class="page-header">
            <h1>회원가입</h1>
        </div>
            <form @submit.prevent="memberCreate">
                <div class="form-group">
                    <label for="name"> 이름 : </label>
                    <input type="text" id="name" v-model="name" class="form-control" name="name" >
                </div>
                <div class="form-group">
                    <label for="email"> email : </label>
                    <input type="text" id="email" v-model="email" class="form-control" name="email" >
                </div>
                <div class="form-group">
                    <label for="password"> 비밀번호 : </label>
                    <input type="password" id="password" v-model="password" class="form-control" name="password">
                </div>
                <div class="form-group">
                    <label for="city"> 도시 : </label>
                    <input type="text" id="city" v-model="city" class="form-control" name="city">
                </div>
                <div class="form-group">
                    <label for="street"> 상세주소 : </label>
                    <input type="text" id="street" v-model="street" class="form-control" name="street">
                </div>
                <div class="form-group">
                    <label for="zipcode"> 우편번호 : </label>
                    <input type="text" id="zipcode" v-model="zipcode" class="form-control" name="zipcode">
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary mt-3">가입완료</button>
                </div>
            </form>
    </div>
</template>

<script>
import axios from "axios";

export default {
    //memberCreate

    data(){
        return {
            name : "",
            email: "",
            password: "",
            city : "",
            street : "",
            zipcode : ""
        }
    },
    methods:{
        async memberCreate(){
            try{                                                               
                const registerData = {
                    name : this.name,
                    email: this.email, 
                    password: this.password,
                    city : this.city,
                    street : this.street,
                    zipcode : this.zipcode
                };                
                // await axios.post("http://localhost:8080/member/new", registerData);
                await axios.post(`${process.env.VUE_APP_BASE_URL}/member/new`, registerData);

                // location.href="/login"
                this.$router.push(
                    {name:'Login'}
                )
            } catch(error){
                const error_message= error.response?.data.error_message;
                if(error_message){
                    console.log(error_message);
                    alert(error_message);
                } else {
                    console.log(error);
                    alert("입력 값 확인 필요")
                }
            }
        }
    }
}
</script>

<style>

</style>