<template>
  <main class="container is-max-desktop pb-6 mb-3 content">
    <RouterLink to="/">Retour</RouterLink>
    <h3>Mes candidatures</h3>
    <CandidatureList v-if="candidatures.length > 0" :candidatures="candidatures"></CandidatureList>
    <LoadingSpinner v-else-if="isLoading"></LoadingSpinner>
    <p v-else>Aucune candidature</p>
  </main>
</template>
<script setup lang="ts">
import { EnseignantApi } from '@/lib/api/enseignant.api';
import type { CandidatureEntity } from '@/lib/api/entities';
import { onMounted, ref } from 'vue';
import CandidatureList from '@/components/candidature/CandidatureList.vue';
import LoadingSpinner from '@/components/utils/LoadingSpinner.vue';
const isLoading = ref<boolean>(true);
const candidatures = ref<CandidatureEntity[]>([]);
onMounted(async () => {
  candidatures.value = await EnseignantApi.getCandidatures();
  isLoading.value = false;
});
</script>
