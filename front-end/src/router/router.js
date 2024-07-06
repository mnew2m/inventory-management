import { createWebHistory, createRouter } from "vue-router";

const routes = [
    {
        path: '/',
        name: 'HomePage',
        component: () => import('@/pages/HomePage.vue'),
    },
    {
        path: '/purchaseHistory',
        name: 'PurchaseHistoryPage',
        component: () => import('@/pages/PurchaseHistoryPage.vue'),
    },
    {
        path: '/replacementCycles',
        name: 'ReplacementCyclesPage',
        component: () => import('@/pages/ReplacementCyclesPage.vue'),
    },
    {
        path: '/system',
        name: 'SystemPage',
        component: () => import('@/pages/SystemPage.vue'),
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