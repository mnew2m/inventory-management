<template>
  <v-data-table
      v-model="selectedRow"
      :no-data-text="props.noDataText"
      :headers="store.purchaseGridHeaders"
      :items="store.purchaseGridItems"
      item-value="purchaseId"
      :search="search"
      show-select
      return-object
  >
    <template #top>
      <div class="d-flex align-center justify-space-between">
        <v-text-field
          v-model="search"
          placeholder="검색"
          prepend-inner-icon="mdi-magnify"
          variant="solo-filled"
          density="compact"
          flat
          hide-details
          max-width="500"
          clearable
          persistent-clear
          rounded="0"
        ></v-text-field>
        <v-spacer/>
        <v-btn
          prepend-icon="mdi-delete"
          color="primary"
          rounded="0"
          variant="outlined"
          @click="deleteItems"
        >삭제</v-btn>
      </div>
      <v-divider class="mt-3"></v-divider>
    </template>
    <!--<template #item="{ item }">
      <tr :class="selectedRow.purchaseId === item.purchaseId ? 'bg-primary' : ''"
          @click="rowClick(item)"
          style="cursor: pointer;"
      >
        <td class="text-center"></td>
        <td class="text-center">{{ item.purchasePlace }}</td>
        <td class="text-center">{{ item.purchaseImage }}</td>
        <td class="text-center">{{ item.category }}</td>
        <td class="text-center">{{ item.productName }}</td>
        <td class="text-center">{{ item.productMemo }}</td>
        <td class="text-center">{{ item.productPrice.toLocaleString() }}원</td>
        <td class="text-center">{{ item.productQty }}</td>
        <td class="text-center">{{ item.purchaseDate }}</td>
      </tr>
    </template>-->
    <!--<template #expanded-row="{ columns, item }">
      <tr>
        <td :colspan="columns.length">
          More info about {{ item.purchaseId }}
        </td>
      </tr>
    </template>-->
  </v-data-table>
</template>

<script setup>
import {useInventoryStore} from "@/stores/index.js";
import {ref} from "vue";

const store = useInventoryStore();
const search = ref('');
let selectedRow = ref([]);

const props = defineProps({
  noDataText: {
    default: ''
  }
});

// const rowClick = (row) => {
//   selectedRow.value = row;
//   console.log('selectedRow.value', selectedRow.value)
// }

// TODO ALTER
const deleteItems = () => {
  alert(`선택하신 ${selectedRow.value.length}개의 데이터를 삭제하시겠습니까?`);
  store.deleteGridItem(selectedRow.value);
  selectedRow.value = [];
}
</script>

<style scoped>

</style>