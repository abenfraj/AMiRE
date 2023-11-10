<template>
  <Modal
    title="Créer une nouvelle école"
    :is-loading="isLoading"
    :is-active="props.opened"
    @save="handleSave"
    @close="handleClose"
  >
    <div class="field">
      <label class="label">Raison sociale</label>
      <div class="control">
        <input
          class="input"
          type="text"
          v-model="ecoleToSend.raisonSociale"
          placeholder="Efrei"
        />
      </div>
    </div>
    <div class="field">
      <label class="label">Compétences</label>
      <div class="control">
        <textarea
          class="textarea"
          v-model="ecoleToSend.competences"
          placeholder="Informatique, Marketing digital..."
        ></textarea>
      </div>
    </div>
    <div class="field">
      <label class="label">Besoins</label>
      <div class="control">
        <textarea
          class="textarea"
          v-model="ecoleToSend.besoins"
          placeholder="Besoins en intervenants extérieurs et en enseignants chercheurs..."
        ></textarea>
      </div>
    </div>
    <div class="field">
      <label class="label">Exigences</label>
      <div class="control">
        <textarea
          class="textarea"
          v-model="ecoleToSend.exigences"
          placeholder="Présentiel uniquement."
        ></textarea>
      </div>
    </div>
    <div class="field">
      <label class="label">Période</label>
      <div class="control">
        <input
          class="input"
          type="text"
          v-model="ecoleToSend.periode"
          placeholder="Septembre 2024 à Aout 2025."
        />
      </div>
    </div>
    <div class="field">
      <label class="label">Remarques</label>
      <div class="control">
        <textarea
          class="textarea"
          v-model="ecoleToSend.remarques"
          placeholder="Remarques."
        ></textarea>
      </div>
    </div>
  </Modal>
</template>

<script setup lang="ts">
import Modal from "@/components/utils/Modal.vue";
import { EcoleApi } from "@/lib/api/ecole.api";
import type { EcoleEntity } from "@/lib/api/entities";
import { reactive, ref } from "vue";
const props = defineProps<{
  opened: boolean;
}>();
const emits = defineEmits(["close"]);
const isLoading = ref(false);

const ecoleToSend: Omit<EcoleEntity, "id"> = reactive({
  raisonSociale: "",
  competences: "",
  besoins: "",
  exigences: "",
  periode: "",
  remarques: "",
});
async function handleSave() {
  isLoading.value = true;
  await EcoleApi.createEcole(ecoleToSend);
  isLoading.value = false;
  reset();
  emits("close");
}
function handleClose() {
  reset();
  emits("close");
}

function reset() {
  ecoleToSend.raisonSociale = "";
  ecoleToSend.competences = "";
  ecoleToSend.besoins = "";
  ecoleToSend.exigences = "";
  ecoleToSend.periode = "";
  ecoleToSend.remarques = "";
}
</script>
