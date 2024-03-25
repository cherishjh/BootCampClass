import {createRouter, createWebHistory} from 'vue-router';
import ItemList from "@/views/ItemList";
import LoginComponent from '@/components/LoginComponent';
import BasicComponent from '@/components/BasicComponent'
// export default인 경우에는 {} 필요 없고, 여러 개 요소가 있을때는 {} 필요
import { memberRoutes } from '@/router/memberRouter.js';
import { orderRoutes } from './orderRouter';
import {itemRoutes} from '@/router/itemRouter';

const routes = [
    {
        // url 경로 지정
        path: '/',
        // 이 라우터의 이름    : 여기서 지정
        name: 'HOME',
        component: ItemList, 
    },
    
    {
        path: '/login',
        name: 'Login',
        component: LoginComponent, 
    },
    {
        path: '/basic',
        name: 'BasicComponent',
        component: BasicComponent, 
    },


    // ...은 스프레드 연산자로 불리고, 주로 배열 요소를 다른 배열 요소에 합할때 사용된다.
    ...memberRoutes,
    ...orderRoutes,
    ...itemRoutes,
   
];

const router = createRouter({
    // vue router는 내부적으로 두가지 방식의 히스토리 관리를 제공한다. 
  
    history: createWebHistory(), 
    routes 
    }
);

export default router;