<template>
  <div class="d-flex justify-center text-left">
    <v-card max-width="344" color="primary" variant="tonal">
      <v-card-item>
        <div>
          <div class="d-flex justify-center text-overline mb-1">| ALERT |</div>
          <div class="d-flex justify-center text-h6 mb-1">404</div>
          <div class="d-flex justify-center text-caption">존재하지 않는 페이지이거나 오류가 발생하였습니다.</div>
        </div>
      </v-card-item>
      <v-card-actions class="d-flex justify-center">
        <v-btn @click="goBack"> 돌아가기 </v-btn>
      </v-card-actions>
    </v-card>
  </div>
</template>

<script setup>
import {useRouter} from "vue-router";

const router = useRouter();

const goBack = () => {
  router.go(-1)
}
</script>
