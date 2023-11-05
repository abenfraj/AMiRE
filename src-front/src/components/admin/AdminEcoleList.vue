<template>
  <p v-if="listeEcoles">
    <AdminEcoleItemVue
      v-for="ecole in listeEcoles"
      :key="ecole.idEcole"
      :ecole="ecole"
    />
  </p>
  <LoadingSpinner v-else />
</template>
<script setup lang="ts">
import type { EcoleEntity } from "@/lib/api/entities";
import { onMounted, ref, watch } from "vue";
import LoadingSpinner from "../utils/LoadingSpinner.vue";
import { EcoleApi } from "@/lib/api/ecole.api";
import AdminEcoleItemVue from "./AdminEcoleItem.vue";

const props = defineProps<{
  modalCreationState: boolean;
}>();
const listeEcoles = ref<EcoleEntity[] | null>();

async function handleFetchAnnonces() {
  listeEcoles.value = null;
  listeEcoles.value = await EcoleApi.getEcoles();
}

onMounted(handleFetchAnnonces);

watch(
  () => props.modalCreationState,
  (newValue, oldValue) => {
    if (newValue == false && oldValue == true) {
      handleFetchAnnonces();
    }
  },
);
</script>
