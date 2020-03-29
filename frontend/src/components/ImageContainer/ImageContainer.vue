<template>
    <div class="ImageContainer">
      <img v-bind:src="propsdata" alt="이미지">
    </div>
</template>

<script>
    export default {
      props : ['propsdata']
    };
</script>
<style>
  .ImageContainer{
    position: absolute;
    left: 700px;
    top:104px;
    width: 900px;
    height: 300px;
  }

</style>
