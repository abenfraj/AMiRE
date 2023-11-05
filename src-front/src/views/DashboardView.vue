<template>
  <main class="container is-max-desktop pb-6 mb-3">
    <UserProfileContainerVue
      v-if="account.type.value == AccountType.Enseignant"
    ></UserProfileContainerVue>
    <EcoleAnnoncesContainerVue
      v-else-if="account.type.value == AccountType.Ecole"
    ></EcoleAnnoncesContainerVue>
    <AdminDashboardContainerVue
      v-else-if="account.type.value == AccountType.Admin"
    ></AdminDashboardContainerVue>
    <PleaseLoginVue v-else></PleaseLoginVue>
  </main>
</template>
<script setup lang="ts">
import UserProfileContainerVue from "@/components/user/UserProfileContainer.vue";
import EcoleAnnoncesContainerVue from "@/components/ecole/EcoleAnnoncesContainer.vue";
import AdminDashboardContainerVue from "@/components/admin/AdminDashboardContainer.vue";
import PleaseLoginVue from "@/components/PleaseLogin.vue";
import { UseAccount } from "@/lib/composables/useAccount";
import { AccountType } from "@/lib/composables/useAccount";
import { relative } from "path";

const account = UseAccount();
</script>
<style scoped>
main {
  position: relative;
}
</style>