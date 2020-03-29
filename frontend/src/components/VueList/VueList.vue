<template>
    <div class="VueList">
      <transition-group name="list" tag="ul">
        <li v-for="(todoitem,index) in propsdata" :key=todoitem class="shadow">
          <i class="checkBtn fa fa-check" aria-hidden="true" v-on:click="showImage(todoitem)"></i>
          <span v-on:click="updatePopUpTodo(todoitem,index)">{{todoitem}}</span>
          <span class="removeBtn" type="button" @click="removeTodo(todoitem,index)">
            <i class="fa fa-trash-o" aria-hidden="true"></i>
          </span>
          </li>

      </transition-group>
      <modal v-if="showUpdateModal" @close="showUpdateModal = false">
        <div class="closeBtn" slot="header" @click="showUpdateModal = false">
          <i class="closeModalBtn fa fa-times" aria-hidden="true"></i>
        </div>
        <h3 slot="header">warning</h3>

        <input type="text" ref="inputTxt" v-on:keypress.enter="updateTodo" @keypress.enter="showUpdateModal=false" slot="footer" v-model="updateContent" placeholder="이미지 링크를 입력하세요.">
        <button slot="footer" v-on:click="updateTodo" @click="showUpdateModal = false">확인</button>
      </modal>
    </div>
</template>

<script>

    import Modal from "../Modal/Modal";

    export default {
      props : ['propsdata'],

      data () {
        return{
          originContent:'',
          updateContent :'',
          updateIndex:'',
          showUpdateModal : false
        }
      },
      methods:{
        removeTodo : function (todoitem,index) {
          if(confirm('데이터를 정말로 지우시겠습니까?')){
            this.$emit('remove',todoitem,index);
          }
        },
        updatePopUpTodo : function (todoitem,index) {
          if(confirm('데이터를 변경하시겠습니까?')){
            this.showUpdateModal = !this.showUpdateModal;
            this.originContent = todoitem;
            this.updateIndex = index;
          }
        },
        updateTodo : function () {
          this.$emit('update',this.originContent,this.updateContent,this.updateIndex);
          this.updateContent='';
        },
        showImage : function (todoItem) {
          this.$emit('showImage',todoItem);
        }

      },
      components :{
        'Modal':Modal
      }
    };
</script>
<style>

  .list-item{
    display: inline-block;
    margin-right: 10px;
  }
  .list-move{
    transition: transform 1s;
  }
  .list-enter-active,.list-leave-active{
    transition: all 1s;
  }
  .list-enter, .list-leave-to{
    opacity: 0;
    transform: translateY(30px);
  }
  ul{
    list-style-type : none;
    padding-left: 0px;
    margin-top: 0;
    text-align: left;
  }
  li{
    display: flex;
    min-height: 50px;
    height: 50px;
    line-height: 50px;
    margin:0.5rem 0;
    padding:0 0.9rem;
    background: white;
    border-radius: 5px;
  }
  .checkBtn{
    line-height: 45px;
    color: #62acde;
    margin-right: 5px;
  }
  .removeBtn{
    margin-left: auto;
    color: #de4343;
  }

</style>
