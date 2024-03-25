import { createApp } from 'vue'
import App from './App.vue'
import router from '@/router/index.js'
import store from './store/cart.js'
import '@/assets/css/bootstrap.min.css'     //여기에만 import 
import axios from 'axios';

// index.html 의 id인 app에 마운트 되도록 하는 코드
const app=createApp(App);

// vue 애플리케이션에서 전역적으로 기능 사용할 경우에 아래와 같이 use 문법 사용 

/*
401 응답의 경우 interceptor 를 통해 고통적으로 토큰 제거 후 로그아웃
 */
axios.interceptors.response.use(response => response, error => {
    if(error.response && error.response.status === 401){
        localStorage.clear();
        location.href = "/login";
    }
    return Promise.reject(error);
})
app.use(router);
app.use(store);
app.mount('#app');



