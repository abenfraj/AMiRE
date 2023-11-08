import { createRouter, createWebHashHistory } from "vue-router";
import DashboardView from "../views/DashboardView.vue";
import CandidaturesPageVue from "@/views/CandidaturesPage.vue";
import AnnoncePage from "@/views/AnnoncePage.vue";

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
    {
      path: "/annonce/:idAnnonce/",
      name: "annonce",
      component: AnnoncePage,
      props: true,
    },
  ],
});

export default router;
