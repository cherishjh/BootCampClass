import MemberList from '@/views/MemberList.vue';
import MemberCreate from '@/views/MemberCreate.vue';
import MemberOrder from '@/views/MemberOrder.vue';
import MyPage from '@/views/MyPage.vue';


export const memberRoutes = [
    {
        path: '/members',
        name: 'MemberList',
        component: MemberList, 
    },
    {
        path: '/member/new',
        name: 'MemberCreate',
        component: MemberCreate, 
    },
    {
        path: '/member/:id/orders',
        name: 'MemberOrder',
        component: MemberOrder, 
        props: true     
    },
    {
        path: '/mypage',
        name: 'MyPage',
        component: MyPage, 
    },
    // {
    //     path: '/member/myInfo',
    //     name: 'myInfo',
    //     component: myInfo,
    // },
   
    // {
    //     path: '/myorder',
    //     name: 'MyOrder',
    //     component: MyOrder, 
    // },
];