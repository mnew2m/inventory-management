import './assets/main.css'

import { createApp } from 'vue'
import App from './App.vue'
import router from '@/router/router.js';
import '@mdi/font/css/materialdesignicons.css'
import 'vuetify/styles'
import vuetify from '@/plugins/vuetify.js'

const app = createApp(App)
app.use(router)
app.use(vuetify)
app.mount('#app')
