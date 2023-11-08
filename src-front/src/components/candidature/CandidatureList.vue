<template>
  <table class="table">
    <thead>
      <tr>
        <th>id</th>
        <th v-if="account.type.value == 'Enseignant'">Offre</th>
        <th v-if="account.type.value == 'Ecole'">Date de candidature</th>
        <th v-if="account.type.value == 'Ecole'">Profil</th>
        <th>Statut</th>
      </tr>
    </thead>
    <tbody>
      <CandidatureItem
        v-for="candidature in props.candidatures"
        :candidature="candidature"
        @openProfil="handleOpenProfil"
        @candidature-status-update="$emit('candidature-status-update')"
      ></CandidatureItem>
    </tbody>
    <ModalVue
      title="Voir un profil"
      :isLoading="false"
      :isActive="openedProfile >= 0"
      variant="ok"
      @close="handleCloseProfil"
    >
      <UserProfileContainer
        :userId="openedProfile"
        v-if="openedProfile >= 0"
      ></UserProfileContainer>
    </ModalVue>
  </table>
</template>
<script setup lang="ts">
import type { CandidatureEntity } from "@/lib/api/entities";
import CandidatureItem from "@/components/candidature/CandidatureItem.vue";
import { ref } from "vue";
import ModalVue from "../utils/Modal.vue";
import { UseAccount } from "@/lib/composables/useAccount";
import UserProfileContainer from "../user/UserProfileContainer.vue";

defineEmits(["candidature-status-update"]);
const props = defineProps<{
  candidatures: CandidatureEntity[];
}>();
const account = UseAccount();
const openedProfile = ref<number>(-1);
function handleOpenProfil(idEnseignant: number) {
  openedProfile.value = idEnseignant;
}
function handleCloseProfil() {
  openedProfile.value = -1;
}
</script>
