<template>
  <div class="d-flex justify-center">
    <v-row justify="center">
      <v-col cols="12" md="9">
        <v-sheet class="bg-grey-lighten-3">
          <v-btn color="primary" @click="plusCounter">Home Page</v-btn>
          <div>Current Count: {{ counter.count }}</div>
        </v-sheet>
      </v-col>
    </v-row>
  </div>
</template>

<script setup>
import {useInventoryStore} from "@/stores/index.js";

const counter = useInventoryStore()

const plusCounter = () => {
  counter.count++
  // with autocompletion ✨
  counter.$patch({ count: counter.count + 1 })
  // or using an action instead
  counter.increment()
}
</script>