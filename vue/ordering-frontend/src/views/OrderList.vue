<template>
    <OrderListComponent
    :isAdmin="true"
    apiUrl="/orders"           
    />
</template>
<!-- apiUrl="http://localhost:8080/orders"            -->


<script>
import OrderListComponent from '@/components/OrderListComponent1.vue';

export default {
    components: { 
        OrderListComponent 
    }
}
</script>
