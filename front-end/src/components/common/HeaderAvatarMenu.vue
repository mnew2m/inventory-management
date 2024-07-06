<template>
  <v-menu min-width="200px" rounded>
    <template #activator="{ props }">
      <v-btn icon="true" v-bind="props">
        <v-avatar icon="mdi-account-circle" />
      </v-btn>
    </template>
    <v-card>
      <v-card-text>
        <div class="mx-auto text-center">
          <v-btn :variant="props.variant" rounded>
            EDIT ACCOUNT
          </v-btn>
          <v-divider class="my-2"></v-divider>
          <v-btn :variant="props.variant" rounded>
            CHANGE PASSWORD
          </v-btn>
          <v-divider class="my-2"></v-divider>
          <v-btn :variant="props.variant" rounded>
            LOG OUT
          </v-btn>
        </div>
      </v-card-text>
    </v-card>
  </v-menu>
</template>

<script setup>
const props = defineProps({
  variant: {
    default: 'plain'
  }
});
</script>

<style scoped></style>