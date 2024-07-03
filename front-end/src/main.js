import {createApp} from "vue";
import {createPinia} from "pinia";
import App from "@/App.vue";
import router from "@/router/router.js";
import vuetify from "@/plugins/vuetify.js";

const pinia = createPinia()

createApp(App)
    .use(vuetify)
    .use(router)
    .use(pinia)
    .mount('#app');
