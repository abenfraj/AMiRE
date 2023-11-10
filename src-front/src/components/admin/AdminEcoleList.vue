<template>
  <p v-if="listeEcoles">
    <AdminEcoleItemVue
      v-for="ecole in listeEcoles"
      :key="ecole.id"
      :ecole="ecole"
      @delete="handleDeleteEcole"
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

async function handleFetchEcole() {
  listeEcoles.value = null;
  listeEcoles.value = await EcoleApi.getEcoles();
}

async function handleDeleteEcole(ecoleId: number) {
  await EcoleApi.deleteEcole(ecoleId);
  await handleFetchEcole();
}

onMounted(handleFetchEcole);

watch(
  () => props.modalCreationState,
  (newValue, oldValue) => {
    if (newValue == false && oldValue == true) {
      handleFetchEcole();
    }
  },
);
</script>
