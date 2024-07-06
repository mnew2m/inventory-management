<template>
  <v-app-bar class="px-3" density="compact" flat>
    <div class="hidden-md-and-up">
      <HeaderMenu />
    </div>
    <v-spacer/>
    <v-tabs color="grey-darken-2" centered>
      <v-tab v-for="page in pages" :key="page.name" :to="page.path">
        {{ page.name }}
      </v-tab>
    </v-tabs>
    <v-spacer/>
    <!--<v-avatar class="hidden-sm-and-down" icon="mdi-account-circle" />-->
    <div class="hidden-sm-and-down">
      <HeaderMenu />
    </div>
  </v-app-bar>
</template>

<script setup>
import HeaderMenu from "@/components/common/HeaderAvatarMenu.vue";

const pages = [
  { name: 'HOME', path: '/' },
  { name: 'PURCHASE HISTORY', path: '/purchaseHistory' },
  { name: 'REPLACEMENT CYCLES', path: '/replacementCycles' },
  { name: 'SYSTEM', path: '/system' },
]
</script>

<style scoped>

</style>