<template>
  <div class="inputBox shadow">
    <input type="text" v-model="newTodoItem" placeholder="이미지 링크를 입력하세요." v-on:keypress.enter="addTodo">
    <span class="addContainer" v-on:click="addTodo"><i class="addBtn fa fa-plus" aria-hidden="true"></i></span>
    <modal v-if="showModal" @close="showModal = false">
      <div class="closeBtn" slot="header" @click="showModal = false">
        <i class="closeModalBtn fa fa-times" aria-hidden="true"></i>
      </div>
      <h3 slot="header">warning</h3>

      <h3 slot="footer">링크를 입력하세요.</h3>
    </modal>
  </div>
</template>

<script>
  import Modal from "../Modal/Modal";

  export default {
    data(){
      return{
        newTodoItem:'',
        showModal:false
      }
    },
    methods:{
      addTodo(){
        if (this.newTodoItem !== '' ){//인풋 박스의 입력 값이 있을 때만 저장
          var value = this.newTodoItem;//인풋 박스에 입력된 텍스트의 앞뒤 공백 문자열 제거
          this.newTodoItem.trim();
          this.$emit('addTodo',value);
          this.clearInput();//인풋 박스의 입력 값을 초기화
        }else{
          this.showModal = !this.showModal;
        }
      },
      clearInput(){
        this.newTodoItem = '';
      }
    },
    components:{
      Modal:Modal
    }
  }
</script>

<style>
  input:focus{outline:none;}
  .inputBox{background:#fff;height:50px;line-height:50px;border-right:5px;}
  .inputBox input{border-style:none;font-size:0.9rem;}
  .addContainer{float:right;background:linear-gradient(to right,#6478FB,#8763FB);display:block;width:3rem;border-radius:0 5px 5px 0;}
  .addBtn{color:#fff;vertical-align:middle;}
  .closeBtn{
    display: block;
    float: right;
    margin-top:0px;

  }
</style>
