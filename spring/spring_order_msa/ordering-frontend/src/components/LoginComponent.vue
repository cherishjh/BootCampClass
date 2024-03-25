<!-- <template>
    <div>
        로그인 화면
    </div>
    <div class="container">
        <div class="page-header" style="margin-top : 20 px" >
            <h1>로그인</h1>
        </div>
        submit은 기본적으로 폼 제출시 브라우저가 페이지를 새로고침하므로 해당 동작을 막기 위해 prevent 사용
        <form @submit.prevent = "doLogin">
            <div class="form-group">
                <label for="email"> email : </label>
                <input type="text" v-model="email" class="form-control" >               
            </div>
            <div class="form-group">
                <label for="password"> 비밀번호 : </label>
                <input type="text" v-model="password" class="form-control">
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-primary mt-3">똑똑</button>
            </div>
        </form>
    </div>
</template>

<script>
import axios from "axios";
import {jwtDecode} from "jwt-decode";

export default {
    data(){
        return {
            email: "",
            password: "",
            apiUrl:""
        }
    },
    created(){
        this.apiUrl= `${process.env.VUE_APP_BASE_URL}`
    },
    methods:{
        async doLogin(){
            // 두 가지 예외 가능성:  
            // 1) 200번대 상태값 이면서 token이 비어있는 경우
            // 2) 200번대 상태값이 아닌 경우 
            try{                                                                // try 안에는 별다른 명시 없어도 200번대만 try로 잡아주고 나머지는 catch로 보냄
                const loginData = {email: this.email, password: this.password};                  //json 데이터; email은 json에서 키 값
                const response = await axios.post(`${apiUrl}/doLogin`, loginData);
                console.table(response);
                const token = response.data.result.token;           // json 데이터에서 token이 result 밑에 있어서 이렇게 적음 -> cross-checking 하면서 
                console.log(token);
                if(token){
                    const decoded= jwtDecode(token);
                    console.log(decoded);
                    localStorage.setItem("token", token);
                    localStorage.setItem("role", decoded.role);
                    // created 함수는 reload될때 1번만 실행되는 hook 함수
                    // 근데 router.push 를 통한 화면 전환은 reload를 실행시키지 않으므로, created함수 호출이 되지 않음
                    // this.$router.push("/");
                    location.href="/";
                }else {
                    console.log("200 ok but not token");
                    alert("Login Failed1");
                }
            } catch(error){
                const error_message= error.response?.data.error_message;
                if(error_message){
                    console.log(error_message);
                    alert(error_message);
                } else {
                    console.log(error);
                    alert("Login Failed2")
                }
            }
        }
    }
}
</script>

<style lang="scss" scoped>

</style> -->

<script>
import axios from "axios";
import {jwtDecode} from "jwt-decode";

export default {
  name: "LoginComponent",
  data(){
    return{
      email: "",
      password: "",
      name: "grape"
    }
  },
  methods:{
    async doLogin(){

      /*
      2가지 예외 가능성 : 200번대 상태값이면서 token이 비어있는 경우
      200번대 상태값이 아닌경우
       */
      try {
        const loginData = {
          email : this.email,
          password : this.password,
          name : this.name
        }

        const response = await axios.post(
          `${process.env.VUE_APP_BASE_URL}/doLogin`, 
          loginData);
        const token = response.data.result.token;
        if(token){
          const decoded = jwtDecode(token);
          // console.table(decoded)
          localStorage.setItem("role", decoded.role);
          localStorage.setItem("email", decoded.sub);
          localStorage.setItem("token",token);
          /*
          created 함수는 reload 될때 1번만 실행되는 hook 함수
          그런데, router.push 를 통한 ㅇ환면전환은 reload 를 실행 시키지 않으므로 앞으로 created 함수 호출이 되지 않음
          this.$router.push("/")
           */
          location.href = "/";
        }else{
          console.error("200 ok but not token")
          alert("로그인 실패")
        }
      }catch(error){
            const error_message= error.response?.data.error_message;
            if(error_message){
                console.log(error_message);
                alert(error_message);
            } else {
                console.log(error);
                alert("Login Failed2")
            }
        }
    }
  }
}
</script>

<template>
  <div class="container">
    <div class="page-header" style="margin-top: 20px">
      <h1>로그인</h1>
    </div>
    <form @submit.prevent="doLogin">
      <table class="table">
        <tr class="form-group">
          <td><label for="email">이메일 : </label></td>
          <td><input type="email" id="email" name="email" class="form-control" v-model="email"></td>
        </tr>
        <tr class="form-group">
          <td> <label for="pw">비밀번호 : </label></td>
          <td><input type="password" id="pw" name="pw" class="form-control" v-model="password"></td>
        </tr>
      </table>
      <button type="submit" class="btn btn-primary"> 로그인 </button>
    </form>
  </div>
</template>

<style scoped>

</style>