import { createWebHistory, createRouter } from "vue-router";

const routes = [
    {
        path: '/',
        name: 'TestPage',
        component: () => import('@/pages/TestPage.vue'),
    },
    {
        path: '/:catchAll(.*)',
        component: () => import('@/pages/NotFoundPage.vue'),
        meta: { hideHeader: true },
    },
];

const router = createRouter({
    history: createWebHistory(),
    routes,
});

export default router;