<template>
  <!-- <h1>hello world</h1> -->
  <HeaderComponent/>
  <!-- <HomeComponent/> -->
  <div>
    <router-view/>    
  </div>
  <FooterComponent/>
</template>

<script>
//상대경로 
// import HomeComponent from "./components/HomeComponent.vue";
//절대경로 : @는 jsconfig 
// import HomeComponent from "@/components/HomeComponent.vue";
import HeaderComponent from "@/components/HeaderComponent.vue";
import FooterComponent from "@/components/FooterComponent.vue";
export default {
  // 사용할 하위 컴포넌트 목록 나열
  components:{
    // HomeComponent, 
    HeaderComponent, 
    FooterComponent
  }
}
</script>

<style>
</style>
