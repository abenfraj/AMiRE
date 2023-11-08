<template>
  <Modal
    title="Créer une nouvelle annonce"
    :is-loading="isLoading"
    :is-active="props.opened"
    @save="handleSave"
    @close="handleClose"
  >
    <div class="field">
      <label class="label">Titre de l'annonce</label>
      <div class="control">
        <input
          class="input"
          type="text"
          v-model="annonceToSend.titre"
          placeholder="Professeur d'informatique"
        />
      </div>
    </div>
    <div class="field">
      <label class="label"
        >Niveaux souhaités
        <span style="font-weight: 500">(séparés par virgule)</span></label
      >
      <div class="control">
        <input
          class="input"
          type="text"
          v-model="annonceToSend.niveauxSouhaites"
          placeholder="L3, M1, M2"
        />
      </div>
    </div>
    <div class="field">
      <label class="label"
        >Type de contrat
        <span style="font-weight: 500">(séparés par virgule)</span></label
      >
      <div class="control">
        <input
          class="input"
          type="text"
          v-model="annonceToSend.typeDeContrat"
          placeholder="CDD, CDI"
        />
      </div>
    </div>
    <div class="field">
      <label class="label">Description</label>
      <div class="control">
        <textarea
          class="textarea"
          v-model="annonceToSend.description"
          placeholder="Nous recherchons..."
        ></textarea>
      </div>
    </div>
    <div class="field">
      <label class="label">Date d'expiration de l'annonce</label>
      <div class="control">
        <input
          class="input"
          type="date"
          v-model="annonceToSend.expirationAnnonce"
        />
      </div>
    </div>
  </Modal>
</template>

<script setup lang="ts">
import Modal from "@/components/utils/Modal.vue";
import { AnnonceApi } from "@/lib/api/annonce.api";
import type { AnnonceEntity } from "@/lib/api/entities";
import { reactive, ref } from "vue";
const props = defineProps<{
  opened: boolean;
}>();
const emits = defineEmits(["close"]);
const isLoading = ref(false);

const annonceToSend: Omit<AnnonceEntity, "id" | "idEcole" | "nbCandidatures"> =
  reactive({
    titre: "",
    niveauxSouhaites: "",
    typeDeContrat: "",
    description: "",
    expirationAnnonce: "",
  });

async function handleSave() {
  isLoading.value = true;
  await AnnonceApi.createAnnonce(annonceToSend);
  isLoading.value = false;
  reset();
  emits("close");
}
function handleClose() {
  reset();
  emits("close");
}

function reset() {
  annonceToSend.titre = "";
  annonceToSend.niveauxSouhaites = "";
  annonceToSend.typeDeContrat = "";
  annonceToSend.description = "";
  annonceToSend.expirationAnnonce = "";
}
</script>
