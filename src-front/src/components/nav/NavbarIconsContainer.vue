<template>
  <div class="buttons">
    <template v-if="props.accountType == AccountType.Enseignant">
      <NavButtonIcon icon="briefcase" href="/candidatures"
        >Mes candidatures</NavButtonIcon
      >
      <NavButtonIcon icon="user">Mon profil</NavButtonIcon>
    </template>
    <NavButtonIcon
      v-else-if="props.accountType == AccountType.Ecole"
      icon="student"
      >Vos annonces</NavButtonIcon
    >
    <NavButtonIcon
      v-else-if="props.accountType == AccountType.Admin"
      icon="crown"
      >Administration</NavButtonIcon
    >
    <a
      v-if="props.accountType == AccountType.Disconnected"
      href="/login"
      class="button is-primary"
      >Se connecter</a
    >
  </div>
</template>
<script setup lang="ts">
import NavButtonIcon from "./NavButtonIcon.vue";
import { AccountType } from "@/lib/composables/useAccount";

const props = defineProps<{
  accountType: AccountType;
}>();
</script>
<style scoped>
.button {
  border: none;
}
</style>
