<template>
  <div id="app">    
    <Login />
  </div>
</template>

<script>
import Login from './components/Login.vue'


export default {
  name: 'App',
  components: {
    Login
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  margin-top: 60px;
  background-color: #2a3342;
}

</style>
