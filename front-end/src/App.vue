<template>
  <v-app>
    <the-header v-if="!$route.meta.hideHeader"/>
    <v-main>
      <v-container fluid>
        <router-view/>
      </v-container>
    </v-main>
  </v-app>
</template>

<script setup>
import TheHeader from "@/components/layout/TheHeader.vue";
</script>

<style>
</style>