<template>
  <div>
    <div class="title is-4 mb-1">{{ props.ecole.raisonSociale }}</div>
    <!--
      <div class="is-inline-flex gap-2 is-justify-content-center my-2">
        <span style="font-weight: 550">Nombre de candidatures : </span>
        <EditableTags
          :model-value="props.ecole.niveauxSouhaites"
          :isEdit="false"
        ></EditableTags>
      </div>
      -->
    <p class="ecoleDescription">{{ props.ecole.besoins }}</p>
    <div class="buttons is-justify-content-end">
      <button class="button no-border has-text-danger">
        Supprimer l'école
      </button>
    </div>
    <hr />
  </div>
</template>
<script setup lang="ts">
import type { EcoleEntity } from "@/lib/api/entities";

const props = defineProps<{
  ecole: EcoleEntity;
}>();
</script>
<style scoped>
.ecoleDescription {
  color: #909090;
  font-size: 0.85rem;
}
</style>
