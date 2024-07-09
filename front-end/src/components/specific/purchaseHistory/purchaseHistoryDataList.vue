<template>
  <v-data-table
    v-model="selectedRow"
    :headers="store.purchaseGridHeaders"
    :items="store.gridItems"
    item-value="purchaseId"
    :search="search"
    :no-data-text="props.gridNoDataText"
    :density="props.gridDensity"
    show-select
    return-object
    expand-on-click
  >
    <template #top>
      <div class=" mb-2 d-flex align-center justify-space-between">
        <search-text-field :search-model="search" @onUpdate="onSearch" />
        <v-spacer/>
        <v-btn
          prepend-icon="mdi-delete"
          color="primary"
          rounded="0"
          variant="outlined"
          @click="onClickDelete"
        >삭제</v-btn>
      </div>
      <v-divider class="mt-3"></v-divider>
    </template>
    <template #[`item.productPrice`]="{ value }">
      {{ addComma(value) }}원
    </template>
    <template #[`item.purchaseDate`]="{ value }">
      {{ formatDate(value) }}
    </template>
    <template #expanded-row="{ columns, item }">
      <tr>
        <td :colspan="columns.length">
          <v-row justify="center" no-gutters>
            <!-- TODO row 편집모드 추가하기 -->
            <v-btn
              v-if="!isEditMode"
              class="mx-3 my-2"
              prepend-icon="mdi-pencil"
              color="primary"
              rounded="0"
              variant="outlined"
              @click="modItem"
            >수정</v-btn>
            <v-btn
              v-if="isEditMode"
              class="mx-3 my-2"
              prepend-icon="mdi-content-save"
              color="primary"
              rounded="0"
              variant="flat"
              @click="saveItem"
            >저장</v-btn>
          </v-row>
        </td>
      </tr>
    </template>
  </v-data-table>
  <v-dialog
    v-model="isDialogOpen"
    max-width="400"
    persistent
  >
    <v-card tile>
      <v-card-item>
        <div class="mt-1">{{ dialogText }}</div>
      </v-card-item>
      <v-card-actions>
        <v-btn
          color="primary"
          variant="outlined"
          rounded="0"
          @click="isDialogOpen = false"
        >닫기</v-btn>
        <v-btn
          v-if="selectedRowLength > 0"
          color="primary"
          variant="flat"
          rounded="0"
          @click="deleteItems"
        >확인</v-btn>
      </v-card-actions>
    </v-card>
  </v-dialog>
</template>

<script setup>
import {computed, ref} from "vue";
import {useInventoryStore} from "@/stores/index.js";
import {addComma, formatDate} from "@/utils/common.js";
import SearchTextField from "@/components/elements/searchTextField.vue";

const store = useInventoryStore();
const search = ref('');
const selectedRow = ref([]);
const isEditMode = ref(false);
const isDialogOpen = ref(false);

const props = defineProps({
  gridNoDataText: {
    default: '',
  },
  gridDensity: {
    default: 'comfortable',
  },
});

const selectedRowLength = computed(() => {
  return selectedRow.value.length;
});

const dialogText = computed(() => {
  let res = '선택된 데이터가 없습니다.';
  if (selectedRowLength.value > 0) res = `${selectedRow.value.length}개의 데이터를 삭제하시겠습니까?`;
  return res;
});

function onClickDelete() {
  isDialogOpen.value = true;
}

function deleteItems() {
  store.deleteGridItem(selectedRow.value);
  isDialogOpen.value = false;
  selectedRow.value = [];
}

// search text 변경
function onSearch(val) {
  search.value = val;
}

function modItem() {
  isEditMode.value = true;
}

function saveItem() {
  isEditMode.value = false;
}

</script>

<style scoped>

</style>