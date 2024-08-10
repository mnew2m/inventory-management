<template>
  <v-data-table
    v-model="selectedRowList"
    :headers="store.purchaseGridHeaders"
    :items="store.gridItems"
    item-value="purchaseId"
    :search="search"
    :no-data-text="props.gridNoDataText"
    :density="props.gridDensity"
    show-select
    select-strategy="single"
    return-object
    show-expand
    :expanded="expandedRowList"
    @update:expanded="expandedRow"
    hover
    @change="changeEvent"
  >
    <template #top>
      <div class=" mb-2 d-flex align-center justify-space-between">
        <search-text-field :search-model="search" @onUpdate="onSearch" />
        <v-btn
          prepend-icon="mdi-delete"
          color="primary"
          rounded="0"
          variant="outlined"
          @click="onClickDelete"
        >삭제</v-btn>
      </div>
    </template>
    <template #item="{ item }">
      <tr>
        <td class="px-2 py-0"><v-checkbox-btn @click="selectedRow(item)" /></td>
        <td class="pa-0"><grid-text-field :readonly="!item.isEditMode" :model-val="item.purchasePlace" /></td>
        <td class="pa-0"><grid-text-field :readonly="true" :model-val="item.purchaseImage" /></td>
        <td class="pa-0"><grid-text-field :readonly="!item.isEditMode" :model-val="item.category" /></td>
        <td class="pa-0"><grid-text-field :readonly="!item.isEditMode" :model-val="item.productName" /></td>
        <td class="pa-0"><grid-text-field :readonly="!item.isEditMode" :model-val="item.productMemo" /></td>
        <td class="pa-0"><grid-text-field :readonly="!item.isEditMode" :model-val="!item.isEditMode ? addComma(item.productPrice) : item.productPrice" /></td>
        <td class="pa-0"><grid-text-field :readonly="!item.isEditMode" :model-val="item.productQty" /></td>
        <td class="pa-0"><grid-text-field :readonly="!item.isEditMode" :model-val="!item.isEditMode ? formatDate(item.purchaseDate) : item.purchaseDate" /></td>
        <td class="pa-0"><v-btn variant="flat" icon="mdi-menu-down" @click="expandedRow(item)" /></td>
      </tr>
    </template>
    <template #expanded-row="{ columns, item }">
      <tr>
        <td :colspan="columns.length">
          <v-row justify="center" no-gutters>
            <div v-if="!item.isEditMode">
              <v-btn
                class="mx-3 my-2"
                prepend-icon="mdi-pencil"
                color="primary"
                rounded="0"
                variant="outlined"
                @click="modItem(item)"
              >수정</v-btn>
            </div>
            <div v-else>
              <v-btn
                class="mx-1 my-2"
                prepend-icon="mdi-content-save"
                color="primary"
                rounded="0"
                variant="flat"
                @click="saveItem(item)"
              >저장</v-btn>
              <v-btn
                class="mx-1 my-2"
                prepend-icon="mdi-close-circle"
                color="primary"
                rounded="0"
                variant="outlined"
                @click="cancelItem(item)"
              >취소</v-btn>
            </div>
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
import SearchTextField from "@/components/elements/SearchTextField.vue";
import GridTextField from "@/components/elements/GridTextField.vue";

const store = useInventoryStore();
const search = ref('');
const selectedRowList = ref([]);
const isDialogOpen = ref(false);
const expandedRowList = ref([]);
const itemChange = ref(false);
const dialogText = ref('선택된 데이터가 없습니다.');

const props = defineProps({
  gridNoDataText: {
    default: '',
  },
  gridDensity: {
    default: 'comfortable',
  },
});

const selectedRowLength = computed(() => {
  return selectedRowList.value.length;
});

function selectedRow(item) {
  if (!selectedRowList.value.includes(item)) {
    selectedRowList.value.push(item);
  } else {
    selectedRowList.value = selectedRowList.value.filter((x) => x.purchaseId !== item.purchaseId);
  }
  console.log(selectedRowList.value);
}

function onClickDelete() {
  if (selectedRowLength.value > 0) {
    dialogText.value = `${selectedRowLength.value}개의 데이터를 삭제하시겠습니까?`;
  }
  isDialogOpen.value = true;
}

function deleteItems() {
  store.deleteGridItem(selectedRowList.value);
  isDialogOpen.value = false;
  selectedRowList.value = [];
}

function onSearch(val) {
  search.value = val;
}

/**
 * row [수정] → 편집모드 활성화
 * */
function modItem(item) {
  item.isEditMode = true;
}

/**
 * row [저장]
 * 1. 수정된 데이터가 없으면?
 * 2. 저장 API
 * 3. unexpandedRow
 * */
function saveItem(item) {
  // TODO 저장 API
  itemChange.value = false;
  unexpandedRow(item);
}

/**
 * row [취소]
 * 1. 수정된 데이터가 있으면 alert : 저장되지 않은 데이터가 있습니다. 취소하시겠습니까?
 * 2. unexpandedRow
 * */
function cancelItem(item) {
  if (changeCheck()) return;
  unexpandedRow(item);
}

function unexpandedRow(item) {
  item.isEditMode = false;
  expandedRowList.value = [];
}

function unexpandedAll() {
  store.setEditMode(false);
  expandedRowList.value = [];
}

/**
 * row 선택 시 update expanded
 * */
function expandedRow(item) {
  if (changeCheck()) return;

  if (!expandedRowList.value[0]) {
    expandedRowList.value.push(item);
    itemChange.value = false;
    return;
  }

  if (expandedRowList.value[0].purchaseId === item.purchaseId) {
    unexpandedAll();
  } else {
    unexpandedAll();
    expandedRowList.value.push(item);
    itemChange.value = false;
  }
}

function changeEvent() {
  itemChange.value = true;
}

// 수정 데이터가 있으면 return true
function changeCheck() {
  if (!itemChange.value) return false;

  dialogText.value = '수정된 데이터가 있습니다.';
  isDialogOpen.value = true;
  return true;
}
</script>

<style scoped>

</style>