<template>
  <div class="loadingSpinner">
    <Icon name="loader" width="50"></Icon>
  </div>
</template>
<script setup lang="ts">
import Icon from "./Icon.vue";
</script>
<style lang="scss">
.loadingSpinner {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100%;
  width: 100%;
  min-height: 200px;
  position: absolute;
  background: rgba(255, 255, 255, 0.5);
  top: 0;
  left: 0;
}
</style>
