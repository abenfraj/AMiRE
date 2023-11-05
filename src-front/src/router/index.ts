import { createRouter, createWebHashHistory } from "vue-router";
import DashboardView from "../views/DashboardView.vue";
import CandidaturesPageVue from "@/views/CandidaturesPage.vue";

const router = createRouter({
  history: createWebHashHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/",
      name: "dashboard",
      component: DashboardView,
    },
    {
      path: "/candidatures",
      name: "candidatures",
      component: CandidaturesPageVue,
    },
  ],
});

export default router;
