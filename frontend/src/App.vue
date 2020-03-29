<template>
  <div id="app">
    <VueHeader></VueHeader>
    <div class="contents1">
      <VueInput v-on:addTodo="addMyTodo"></VueInput>
      <VueList v-bind:propsdata="todoItems" v-on:showImage="showImage" v-on:remove="removeItem" v-on:update="updateItem"></VueList>
      <ImageContainer v-bind:propsdata="srcItem"></ImageContainer>
      <VueFooter v-on:removeAll="clearAll"></VueFooter>
    </div>

  </div>

</template>

<script>
import VueHeader from "./components/VueHeader/VueHeader";
import VueInput from "./components/VueInput/VueInput";
import VueList from "./components/VueList/VueList";
import VueFooter from "./components/VueFooter/VueFooter";
import ImageContainer from "./components/ImageContainer/ImageContainer";


export default {
  components:{
    'VueHeader': VueHeader,
    'VueInput': VueInput,
    'VueList': VueList,
    'VueFooter': VueFooter,
    'ImageContainer': ImageContainer
  },
  methods:{
    addMyTodo: function(todoItem) {
      localStorage.setItem(todoItem,todoItem);
      this.todoItems.push(todoItem);
    },
    clearAll:function () {
      localStorage.clear();
      this.todoItems=[];
    },
    removeItem : function(todoitem,index) {
      localStorage.removeItem(todoitem);
      this.todoItems.splice(index,1);
    },
    updateItem : function (originItem,todoitem,index) {
      localStorage.removeItem(originItem);
      this.todoItems[index] = todoitem;
      localStorage.setItem(todoitem,todoitem);

    },
    showImage : function (todoItem) {
      this.srcItem = todoItem;
    }
  },
  data() {
    return{
      todoItems : [],
      srcItem :''
    }
  },
  created:function () {
    if(localStorage.length>0){
      for(var i=0;i<localStorage.length;i++){
        this.todoItems.push(localStorage.key(i));
      }
    }
  }
}
</script>

<style>
  .contents1{
    width: 600px;
  }
  body{
    text-align: center;
    background-color: #F6F6F8;
  }
  input{
    border-style: groove;
    width: 200px;
  }
  button{
    border-style: groove;
  }
  .shadow{
    box-shadow: 5px 10px 10px rgba(0,0,0,0.03);
  }
</style>

