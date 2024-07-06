<template>
  <div class="d-flex justify-center">
    <v-row justify="center">
      <v-col cols="12" md="9">
        <v-text-field
            v-model="search"
            placeholder="Search"
            prepend-inner-icon="mdi-magnify"
            variant="solo-filled"
            density="compact"
            flat
            hide-details
            single-line
            width="300px"
            clearable
            persistent-clear
        ></v-text-field>
        <v-data-table
          :headers="gridHeaders"
          :items="gridData"
          item-key="purchasePlace"
          :search="search"
          :disable-sort="true"
          hide-default-footer
        ></v-data-table>
      </v-col>
    </v-row>
  </div>
</template>

<script setup>
import {ref} from "vue";

const search = ref('');

const gridHeaders = [
  { title: '구매처', key: 'purchasePlace' },
  { title: '이미지', key: 'purchaseImage' },
  { title: '카테고리', key: 'category' },
  { title: '상품명', key: 'productName' },
  { title: '메모', key: 'productMemo' },
  { title: '가격', key: 'productPrice', value: item => `${item.productPrice}`.toLocaleString() },
  { title: '수량', key: 'productQty' },
  { title: '구매일', key: 'purchaseDate' },
];

const gridData = [
  {
    purchasePlace: '쿠팡',
    purchaseImage: '이미지 url',
    category: '생활용품',
    productName: '휴대폰충전기',
    productMemo: '1미터짜리로 삼',
    productPrice: 5000,
    productQty: 1,
    purchaseDate: '2024-07-02',
  },
  {
    purchasePlace: '11번가',
    purchaseImage: '이미지 url',
    category: '생활용품',
    productName: '로지텍마우스',
    productMemo: 'G304',
    productPrice: 45000,
    productQty: 1,
    purchaseDate: '2024-07-04',
  }
];
</script>