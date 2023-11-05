<template>
  <div>
    <div class="title is-4 mb-1">{{ props.annonce.titre }}</div>
    <div class="is-inline-flex gap-2 is-justify-content-center my-2">
      <span style="font-weight: 550">Niveaux souhaités : </span>
      <EditableTags
        :model-value="props.annonce.niveauxSouhaites"
        :isEdit="false"
      ></EditableTags>
    </div>
    <p class="annonceDescription">{{ props.annonce.description }}</p>
    <div class="buttons is-justify-content-end">
      <button class="button no-border is-small">Détails de l'annonce</button>
      <button class="button is-primary is-small">Liste des candidatures</button>
    </div>
    <hr />
  </div>
</template>
<script setup lang="ts">
import type { AnnonceEntity } from "@/lib/api/entities";
import EditableTags from "@/components/utils/EditableTags.vue";

const props = defineProps<{
  annonce: AnnonceEntity;
}>();
</script>
<style scoped>
.annonceDescription {
  color: #909090;
  font-size: 0.85rem;
}
</style>
