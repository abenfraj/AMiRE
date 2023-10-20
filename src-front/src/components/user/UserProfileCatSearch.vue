
<template>
    <form @submit="handleSubmit" :class="{box: isEdit}">
        <div class="is-flex gap-4 is-align-items-center">
            <span class="is-title is-size-5">Je cherche...</span>
            <button v-if="isEdit" class="button is-primary" type="submit">Enregistrer les changements</button>
            <div v-else class="button is-small" @click="handleEditBtn"><span class="icon">✏</span></div>
        </div>
        <div>
            <div class="field">
                <label class="label">Type de contrat</label>
                <EditableTags v-model="enseignant.typeDeContrat" :isEdit="isEdit" required></EditableTags>
            </div>
            
            <div class="field">
                <label class="label">Disponibilités</label>
                <EditableTextarea v-model="enseignant.disponibilites" :isEdit="isEdit" type="text" required></EditableTextarea>
            </div>
            <div class="field">
                <label class="label">Mes compétences</label>
                <EditableTextarea v-model="enseignant.competences" :isEdit="isEdit" type="text" required></EditableTextarea>
            </div>
            <div class="field">
                <label class="label">Écoles ciblées</label>
                <EditableTags v-model="enseignant.interetEcole" :isEdit="isEdit" required></EditableTags>
            </div>
        </div>
    </form>
</template>
<script setup lang="ts">
import type { EnseignantEntity } from '@/lib/api/entities';
import { reactive, ref } from 'vue';
import EditableText from '@/components/utils/EditableText.vue';
import EditableTextarea from '../utils/EditableTextarea.vue';
import EditableTags from '../utils/EditableTags.vue';

const emits = defineEmits(["triggerPatch"]);
const props = defineProps<{
    profile: EnseignantEntity;
}>();

const enseignant = reactive<EnseignantEntity>(props.profile);
const isEdit = ref<boolean>(false);
function handleDisconnect() {
    console.log("Disconnect");
}
function handleSubmit(e: Event) {
    e.preventDefault();
    emits("triggerPatch");
    isEdit.value = false;
}
function handleEditBtn() {
    isEdit.value = !isEdit.value;
}
</script>
