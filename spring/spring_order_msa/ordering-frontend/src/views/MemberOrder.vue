<template>
  <OrderListComponent
  :isAdmin="true"
  :apiUrl="`/member/${id}/orders`"
  />
</template>
<!-- :apiUrl="`http://localhost:8080/member/${id}/orders`" -->


<script>
import OrderListComponent from "@/components/OrderListComponent.vue"
export default {
    // 매개변수로 데이터 넘겨받을 때 props 사용
    props: ['id'],
    component:{
        OrderListComponent
    }
}
</script>
