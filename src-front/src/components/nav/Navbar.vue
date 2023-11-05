<template>
  <nav class="navbar">
    <div class="navbar-brand">
      <NavBrandedLogo :accountType="account.type.value" />
    </div>

    <div class="navbar-menu">
      <div class="navbar-start">
        <NavSearchBarCandidatures
          v-if="account.type.value == AccountType.Enseignant"
        />
      </div>
      <div class="navbar-end pr-6">
        <NavbarIconsContainerVue
          :accountType="account.type.value"
        ></NavbarIconsContainerVue>
      </div>
    </div>
  </nav>
</template>
<script setup lang="ts">
import { AccountType, UseAccount } from "@/lib/composables/useAccount";
import NavBrandedLogo from "./NavBrandedLogo.vue";
import NavbarIconsContainerVue from "./NavbarIconsContainer.vue";
import NavSearchBarCandidatures from "./NavSearchbarCandidatures.vue";
const account = UseAccount();
</script>
<style scoped>
.navbar {
  box-shadow: 0px 0px 4px 0px rgba(0, 0, 0, 0.25);
  margin-bottom: 1rem;
}
</style>
