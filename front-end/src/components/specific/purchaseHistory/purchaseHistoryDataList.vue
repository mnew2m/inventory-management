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
    return-object
    show-expand
    :expanded="expandedRowList"
    @update:expanded="expandedRow"
    hover
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
        <td class="px-2 py-0"><v-checkbox-btn /></td>
        <td class="pa-0"><grid-text-field :model-val="item.purchasePlace" :readonly="!item.isEditMode" /></td>
        <td class="pa-0"><grid-text-field :model-val="item.purchaseImage" :readonly="!item.isEditMode" /></td>
        <td class="pa-0"><grid-text-field :model-val="item.category" :readonly="!item.isEditMode" /></td>
        <td class="pa-0"><grid-text-field :model-val="item.productName" :readonly="!item.isEditMode" /></td>
        <td class="pa-0"><grid-text-field :model-val="item.productMemo" :readonly="!item.isEditMode" /></td>
        <td class="pa-0"><grid-text-field :model-val="!item.isEditMode ? addComma(item.productPrice) : item.productPrice" :readonly="!item.isEditMode" /></td>
        <td class="pa-0"><grid-text-field :model-val="item.productQty" :readonly="!item.isEditMode" /></td>
        <td class="pa-0"><grid-text-field :model-val="!item.isEditMode ? formatDate(item.purchaseDate) : item.purchaseDate" :readonly="!item.isEditMode" /></td>
        <td class="pa-0"><v-btn variant="flat" icon="mdi-menu-down" @click="expandedRow(item)" /></td>
      </tr>
    </template>
    <!--<template #[`item.productPrice`]="{ item, value }">
      <grid-text-field :model-val="!item.isEditMode ? addComma(value) : value" :readonly="!item.isEditMode" />
    </template>
    <template #[`item.purchaseDate`]="{ item, value }">
      <grid-text-field :model-val="!item.isEditMode ? formatDate(value) : value" :readonly="!item.isEditMode" />
    </template>-->
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
import SearchTextField from "@/components/elements/searchTextField.vue";
import GridTextField from "@/components/elements/gridTextField.vue";

const store = useInventoryStore();
const search = ref('');
const selectedRowList = ref([]);
const isDialogOpen = ref(false);
const expandedRowList = ref([]);

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

const dialogText = computed(() => {
  let res = '선택된 데이터가 없습니다.';
  if (selectedRowLength.value > 0) res = `${selectedRowList.value.length}개의 데이터를 삭제하시겠습니까?`;
  return res;
});

function onClickDelete() {
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
  unexpandedRow(item);
}

/**
 * row [취소]
 * 1. 수정된 데이터가 있으면 alert : 저장되지 않은 데이터가 있습니다. 취소하시겠습니까?
 * 2. unexpandedRow
 * */
function cancelItem(item) {
  unexpandedRow(item);
}

/**
 * 1. 편집모드 비활성화
 * 2. expandedRowList 빈값처리
 * */
function unexpandedRow(item) {
  item.isEditMode = false;
  expandedRowList.value = [];
}

/**
 * row 선택 시 update expanded
 * */
function expandedRow(item) {
  console.log(item);
  // expandedRow 초기화
  expandedRowList.value = [];

  // 선택했던 row 다시 클릭하면 item length 0임
  if (item.length === 0) {
    store.setEditMode(false);
    return;
  }

  // item.isEditMode = true;
  expandedRowList.value.push(item);
  // item.map((x) => x.isEditMode = false);
  // if (item.length === 1) {
  //   expandedRowList.value.push(item[0]);
  // } else {
  //   expandedRowList.value.push(item[1]);
  // }
}
</script>

<style scoped>

</style>