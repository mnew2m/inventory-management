import {createApp} from "vue";
import App from "@/App.vue";
import router from "@/router/router.js";
import vuetify from "@/plugins/vuetify.js";

createApp(App)
    .use(router)
    .use(vuetify)
    .mount('#app');
