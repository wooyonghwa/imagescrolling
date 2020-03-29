<template>
    <div class="VueFooter">
        <div class="clearAllContainer">
          <span class="clearAllBtn" @click="clearTodo">Clear All</span>
        </div>
    </div>
</template>

<script>
    export default {
        methods:{
          clearTodo:function () {
            if(confirm("정말 링크들을 다 지우시겠습니까?")){
              this.$emit('removeAll')
            }

          }
        }
    };
</script>
<style>
  .clearAllContainer{
    width: 8.5rem;
    height: 50px;
    line-height: 50px;
    background-color: white;
    border-radius: 5px;
    margin : 0 auto;
  }
  .clearAllBtn{
    color: #e20303;
    display: block;
  }

</style>
