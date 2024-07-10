<template>
  <v-text-field
    :v-model="searchModel"
    prepend-inner-icon="mdi-magnify"
    placeholder="검색"
    variant="solo-filled"
    density="compact"
    flat
    :max-width="maxWidth"
    rounded="0"
    hide-details
    clearable
    persistent-clear
    @update:model-value="onChangeHandler"
  ></v-text-field>
</template>

<script setup>
import {toRefs} from "vue";

const emit =defineEmits(['onUpdate']);

const props = defineProps({
  searchModel: {
    required: true
  },
  maxWidth: {
    default: 300
  },
});

const {
  searchModel,
  maxWidth,
} = toRefs(props);

function onChangeHandler(val) {
  emit('onUpdate', val);
}
</script>

<style scoped>

</style>