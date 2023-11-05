<template>
  <p v-if="listeAnnonces">
    <EcoleAnnonceItem
      v-for="annonce in listeAnnonces"
      :key="annonce.id"
      :annonce="annonce"
    />
  </p>
  <LoadingSpinner v-else />
</template>
<script setup lang="ts">
import { AnnonceApi } from "@/lib/api/annonce.api";
import type { AnnonceEntity } from "@/lib/api/entities";
import { onMounted, ref, watch } from "vue";
import LoadingSpinner from "../utils/LoadingSpinner.vue";
import EcoleAnnonceItem from "./EcoleAnnonceItem.vue";
const listeAnnonces = ref<AnnonceEntity[] | null>();

const props = defineProps<{
  modalCreationState: boolean;
}>();

onMounted(handleFetchAnnonces);

async function handleFetchAnnonces() {
  listeAnnonces.value = await AnnonceApi.getAnnonces();
}

watch(
  () => props.modalCreationState,
  (newValue, oldValue) => {
    if (newValue == false && oldValue == true) {
      handleFetchAnnonces();
    }
  },
);

</script>
