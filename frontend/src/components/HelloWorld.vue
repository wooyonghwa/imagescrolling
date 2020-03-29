<template>
  <div class="hello">
    <p v-bind:id="uid">{{hihi}}</p>
    <button v-if="flag" v-on:click="clickBtn">btn</button>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  data () {
    return{
      message: 'hello venus',
      hihi: 'this is my message',
      uid:20,
      flag:false
    }
  },
  methods: {
    clickBtn : function () {
      console.log('hi')
    }
  }

}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
