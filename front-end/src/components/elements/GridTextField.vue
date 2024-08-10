<template>
  <v-text-field
    class="text-subtitle-2 ml-1"
    :variant="props.readonly ? 'solo' : 'outlined'"
    density="compact"
    flat
    tile
    hide-details
    :model-value="props.modelVal"
    :readonly="props.readonly"
    min-width="100" />
</template>

<script setup>
const props = defineProps({
  variant: {
    default: 'solo',
  },
  modelVal: {
    default: '',
  },
  readonly: {
    type: Boolean,
    default: false,
  }
});
</script>

<style scoped>
.text-field-font {
  font-size: 0.875rem !important;
  font-weight: 400;
  line-height: 1.425;
  letter-spacing: 0.0178571429em;
}
</style>