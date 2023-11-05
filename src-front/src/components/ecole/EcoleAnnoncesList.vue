<template>
    <p v-if="listeAnnonces">
        {{ listeAnnonces }}
        <Icon name="loader"></Icon>
    </p>
    <LoadingSpinner v-else />
</template>
<script setup lang="ts">
import { AnnonceApi } from '@/lib/api/annonce.api';
import type { AnnonceEntity } from '@/lib/api/entities';
import { onMounted, ref } from 'vue';
import Icon from '../utils/Icon.vue';
import LoadingSpinner from "../utils/LoadingSpinner.vue";
const listeAnnonces = ref<AnnonceEntity[] | null>()

onMounted(handleFetchAnnonces);

async function handleFetchAnnonces() {
    listeAnnonces.value = await AnnonceApi.getAnnonces();
}

</script>
