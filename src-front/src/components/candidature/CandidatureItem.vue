<template>
  <tr v-if="props.candidature" class="is-relative">
    <td>{{ props.candidature.idCandidature }}</td>
    <td v-if="account.type.value == AccountType.Ecole">
      {{ props.candidature.dateCandidature }}
    </td>
    <td>
      <button
        v-if="account.type.value == AccountType.Ecole"
        class="button is-text is-small"
        @click="handleVoirProfil"
      >
        Voir le profil du candidat
      </button>
      <div v-else>
        <p>{{ props.candidature.annonce?.titre }}</p>

        <p class="subtitle is-7">
          {{ props.candidature.annonce?.description }}
        </p>
      </div>
    </td>

    <td v-if="props.candidature.decision != 'Attente'">
      <p>
        <span class="tag">{{ props.candidature.decision }}</span>
      </p>
      <em class="is-size-7">
        par {{ props.candidature.contacteParPersonne }} le
        {{ props.candidature.contacteLe }}
      </em>
    </td>
    <td v-else>
      <p v-if="account.type.value == AccountType.Enseignant" class="tag">
        {{ props.candidature.decision }}
      </p>
      <div v-else class="buttons">
        <button class="button is-small" @click="changeDecision('Refusée')">
          Refuser
        </button>
        <button
          class="button is-small is-success"
          @click="changeDecision('Acceptée')"
        >
          Valider
        </button>
      </div>
    </td>

    <LoadingSpinner v-if="isLoading"></LoadingSpinner>
  </tr>
</template>
<script setup lang="ts">
import { AccountType, UseAccount } from "@/lib/composables/useAccount";
import type { CandidatureEntity } from "@/lib/api/entities";
import { AnnonceApi } from "@/lib/api/annonce.api";
import LoadingSpinner from "../utils/LoadingSpinner.vue";
import { ref } from "vue";

const account = UseAccount();
const props = defineProps<{
  candidature: CandidatureEntity;
}>();
const emits = defineEmits(["openProfil", "candidatureStatusUpdate"]);
const formatter = new Intl.DateTimeFormat("fr-FR", {
  year: "numeric",
  month: "long",
  day: "numeric",
});

const isLoading = ref<boolean>(false);
function handleVoirProfil() {
  emits("openProfil", props.candidature.idEnseignant);
}
async function changeDecision(decision: "Acceptée" | "Refusée") {
  isLoading.value = true;
  const contacteParPersonne = prompt("Validateur ?") ?? "Inconnu";
  const contacteLe = formatter.format(new Date());
  const candidature: Partial<CandidatureEntity> = {
    ...props.candidature,
    decision,
    contacteLe,
    contacteParPersonne,
  };
  await AnnonceApi.saveCandidature(candidature);
  emits("candidatureStatusUpdate");
  isLoading.value = false;
}
</script>
