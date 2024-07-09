<template>
  <div class="d-flex justify-center">
    <v-row justify="center">
      <v-col cols="12" md="9">
        <ph-data-list class="mt-2" :no-data-text="`구매내역이 없습니다.`" />
      </v-col>
    </v-row>
  </div>
</template>

<script setup>
import PhDataList from "@/components/specific/purchaseHistory/purchaseHistoryDataList.vue";
</script>