<template>
  <form @submit="handleSubmit" :class="{ box: isEdit }">
    <div
      v-if="account.type.value == 'Enseignant'"
      class="block is-flex is-justify-content-flex-end gap-4"
    >
      <button v-if="isEdit" class="button is-primary" type="submit">
        Sauvegarder
      </button>
      <template v-else>
        <button class="button is-primary" @click="handleEditBtn">
          Modifier les infos de contact
        </button>
        <a href="logout" class="button is-danger">Se déconnecter</a>
      </template>
    </div>

    <div class="has-text-centered block">
      <p class="title is-1">
        <EditableText
          v-model="enseignant.prenomEnseignant"
          :isEdit="isEdit"
          style="margin-right: 0.5ch"
          placeholder="Prénom"
          required
        ></EditableText>
        <EditableText
          v-model="enseignant.nomEnseignant"
          :isEdit="isEdit"
          placeholder="Nom"
          required
        ></EditableText>
      </p>
      <div class="is-flex is-justify-content-center" style="gap: 2rem">
        <div>
          🌐
          <EditableText
            v-model="enseignant.siteWeb"
            :isEdit="isEdit"
            placeholder="https://site.web/"
            type="url"
            required
          ></EditableText>
        </div>

        <div>
          📧
          <EditableText
            v-model="enseignant.email"
            :isEdit="isEdit"
            placeholer="votre@email.com"
            type="email"
            required
          ></EditableText>
        </div>
        <div>
          📞
          <EditableText
            v-model="enseignant.telephone"
            :isEdit="isEdit"
            placeholder="+33 00 00 00 00"
            type="tel"
            required
          ></EditableText>
        </div>
      </div>
    </div>
  </form>
</template>
<script setup lang="ts">
import type { EnseignantEntity } from "@/lib/api/entities";
import { reactive, ref } from "vue";
import EditableText from "@/components/utils/EditableText.vue";
import { UseAccount } from "@/lib/composables/useAccount";

const emits = defineEmits(["triggerPatch"]);
const props = defineProps<{
  profile: EnseignantEntity;
}>();

const account = UseAccount();
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
