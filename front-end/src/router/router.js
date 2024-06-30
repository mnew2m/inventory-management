import { createWebHistory, createRouter } from "vue-router";

const routes = [
    {
        path: '/',
        name: 'TheWelcome',
        component: () => import('@/components/TheWelcome.vue'),
    },
    {
        path: '/test',
        name: 'TestComponent',
        component: () => import('@/components/TestComponent.vue'),
    },
    {
        path: '/:catchAll(.*)',
        component: () => import('@/components/NotFound.vue'),
    },
];

const router = createRouter({
    history: createWebHistory(),
    routes,
});

export default router;