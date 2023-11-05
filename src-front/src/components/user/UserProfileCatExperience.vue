<template>
  <form
    @submit="handleSubmit"
    :class="{ box: isEdit }"
    class="block"
    style="margin-top: 3rem"
  >
    <div class="is-flex gap-4 is-align-items-center">
      <span class="is-title is-size-5">J'ai fait...</span>
      <button v-if="isEdit" class="button is-primary" type="submit">
        Enregistrer les changements
      </button>
      <div v-else class="button is-small" @click="handleEditBtn">Modifier</div>
    </div>
    <div>
      <div class="field">
        <label class="label">Expérience</label>
        <EditableTextarea
          v-model="enseignant.experience"
          :isEdit="isEdit"
          type="text"
          required
        ></EditableTextarea>
      </div>

      <div class="field">
        <label class="label">Titres académiques</label>
        <EditableTextarea
          v-model="enseignant.titresAcademiques"
          :isEdit="isEdit"
          type="text"
          required
        ></EditableTextarea>
      </div>
      <div class="field">
        <label class="label">Autres informations</label>
        <EditableTextarea
          v-model="enseignant.divers"
          :isEdit="isEdit"
          type="text"
          required
        ></EditableTextarea>
      </div>
      <div class="field">
        <label class="label">Références</label>
        <EditableTextarea
          v-model="enseignant.recommandations"
          :isEdit="isEdit"
          type="text"
          required
        ></EditableTextarea>
      </div>
      <div class="field">
        <label class="label">Évaluations</label>
        <EditableTextarea
          v-model="enseignant.evaluation"
          :isEdit="isEdit"
          type="text"
          required
        ></EditableTextarea>
      </div>
    </div>
  </form>
</template>
<script setup lang="ts">
import type { EnseignantEntity } from "@/lib/api/entities";
import { reactive, ref } from "vue";
import EditableText from "@/components/utils/EditableText.vue";
import EditableTextarea from "../utils/EditableTextarea.vue";
import EditableTags from "../utils/EditableTags.vue";

const emits = defineEmits(["triggerPatch"]);
const props = defineProps<{
  profile: EnseignantEntity;
}>();

const enseignant = reactive<EnseignantEntity>(props.profile);
const isEdit = ref<boolean>(false);
function handleSubmit(e: Event) {
  e.preventDefault();
  emits("triggerPatch");
  isEdit.value = false;
}
function handleEditBtn() {
  isEdit.value = !isEdit.value;
}
</script>
