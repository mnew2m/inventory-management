<template>
  <div class="d-flex justify-center">
    <v-row justify="center">
      <v-col cols="12" md="9">
        <v-data-iterator :items="store.gridItems" item-value="productName" :page="page">
          <template v-slot:default="{ items }">
            <v-row>
              <v-col cols="12" v-for="item in items" :key="item.purchaseId">
                <v-card>
                  <v-card-title class="d-flex align-center">
                    <h4>{{ item.value }}</h4>
                  </v-card-title>
                  <v-expand-transition>
                    <v-list :lines="false" density="compact">
                      <v-list-item :title="`메모: ${item.raw.productMemo}`" active></v-list-item>
                      <v-list-item :title="`구매처: ${item.raw.purchasePlace}`"></v-list-item>
                      <v-list-item :title="`카테고리: ${item.raw.category}`"></v-list-item>
                      <v-list-item :title="`가격: ${item.raw.productPrice.toLocaleString()}원`"></v-list-item>
                      <v-list-item :title="`수량: ${item.raw.productQty}`"></v-list-item>
                      <v-list-item :title="`구매일: ${item.raw.purchaseDate}`"></v-list-item>
                    </v-list>
                  </v-expand-transition>
                </v-card>
              </v-col>
            </v-row>
          </template>
        </v-data-iterator>
      </v-col>
    </v-row>
  </div>
</template>

<script setup>
import {useInventoryStore} from "@/stores/index.js";
import {ref} from "vue";

const store = useInventoryStore()
const page = ref(1)

// const plusCounter = () => {
//   counter.count++
//   // with autocompletion ✨
//   counter.$patch({ count: counter.count + 1 })
//   // or using an action instead
//   counter.increment()
// }
</script>