<template>
  <div class="popup">
    <div class="popup-inner">
      <button class="popup-close" @click="TogglePopup()">X</button>
      <slot />
    </div>
  </div>
</template>

<script>
export default {
  props: ["TogglePopup"],
};
</script>

<style lang="scss" scoped>
.popup {
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  z-index: 99;
  background-color: rgba(0, 0, 0, 0.2);

  display: flex;
  align-items: center;
  justify-content: center;

  .popup-inner {
    width: 70%;
    height: 70%;
    background-color: #fff;
    padding: 32px;
    overflow-y: auto;
  }
}

.popup-close {
  float: right;
  padding: 0;
  border: none;
  background: none;
}
</style>
