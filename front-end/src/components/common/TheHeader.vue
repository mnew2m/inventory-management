<template>
  <v-app-bar class="px-3" density="compact" flat>
    <v-avatar class="hidden-md-and-up" color="grey-darken-1" size="32"/>
    <v-spacer/>
    <v-tabs color="grey-darken-2" centered>
      <v-tab v-for="link in links" :key="link">
        {{link}}
      </v-tab>
    </v-tabs>
    <v-spacer/>
    <v-avatar class="hidden-sm-and-down" color="grey-darken-1" size="32"/>
  </v-app-bar>
</template>

<script setup>
const links = [
  'Dashboard',
  'Messages',
  'Profile',
  'Updates',
]
</script>

<style scoped>

</style>