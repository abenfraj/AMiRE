<template>
  <RouterLink class="navbar-item" to="/">
    <img v-if="logo" :src="logo" class="brandedLogo" />
  </RouterLink>
</template>
<script setup lang="ts">
import LogoAdmin from "../../assets/logo_admin.png";
import LogoEcole from "../../assets/logo_ecole.png";
import LogoEnseignant from "../../assets/logo_enseignant.png";
import LogoDefault from "../../assets/logo_default.png";
import { AccountType, UseAccount } from "@/lib/composables/useAccount";
import { computed } from "vue";

const props = defineProps<{
  accountType: AccountType;
}>();
const logo = computed(() => {
  switch (props.accountType) {
    case AccountType.Admin:
      return LogoAdmin;
    case AccountType.Ecole:
      return LogoEcole;
    case AccountType.Enseignant:
      return LogoEnseignant;
    default:
      return LogoDefault;
  }
});
</script>
<style scoped>
.brandedLogo {
  max-height: 2.5rem;
}
</style>
