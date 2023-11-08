<template>
  <LoadingSpinner v-if="isLoading"></LoadingSpinner>
  <main v-else class="container is-max-desktop pb-6 mb-3">
    <div v-if="annonce" class="content">
      <RouterLink to="/">Retour</RouterLink>
      <h3 class="title is-3">{{ annonce?.titre }}</h3>
      <blockquote class="">{{ annonce.description }}</blockquote>
      <p>Niveaux souhaités : {{ annonce.niveauxSouhaites }}</p>
      <p>Type de contrats : {{ annonce.typeDeContrat }}</p>
      <p>Expire le : {{ annonce.expirationAnnonce }}</p>
    </div>
    <h3 class="title is-5">Liste des candidatures</h3>
    <CandidatureList :candidatures="candidatures" @candidature-status-update="loadCandidatures()"></CandidatureList>
  </main>
</template>
<script setup lang="ts">
import CandidatureList from '@/components/candidature/CandidatureList.vue';
import LoadingSpinner from '@/components/utils/LoadingSpinner.vue';
import { AnnonceApi } from '@/lib/api/annonce.api';
import type { AnnonceEntity, CandidatureEntity } from '@/lib/api/entities';
import { onMounted, ref } from 'vue';

const props = defineProps<{
    idAnnonce: string;
}>()

const candidatures = ref<CandidatureEntity[]>([]);
const annonce = ref<AnnonceEntity | undefined>(undefined);
const isLoading = ref<boolean>(true);

onMounted(async () => {
    const idAnnonce = Number(props.idAnnonce);
    annonce.value = (await AnnonceApi.getAnnonces()).find(a => a.id == idAnnonce);
    await loadCandidatures();
});
async function loadCandidatures() {
    const idAnnonce = Number(props.idAnnonce);
    isLoading.value = true;
    candidatures.value = await AnnonceApi.getCandidaturesOfOffer(idAnnonce);
    isLoading.value = false;
}
</script>
