<template>
  <div class="d-flex justify-center text-left">
    <v-card max-width="344" color="primary" variant="tonal">
      <v-card-item>
        <div>
          <div class="text-overline mb-1">| ALERT |</div>
          <div class="text-h6 mb-1">404</div>
          <div class="text-caption">존재하지 않는 페이지이거나 오류가 발생하였습니다.</div>
        </div>
      </v-card-item>
      <v-card-actions class="d-flex-center">
        <v-btn :to="{ path: '/test' }"> 돌아가기 </v-btn>
      </v-card-actions>
    </v-card>
  </div>
</template>

<script setup>
</script>
