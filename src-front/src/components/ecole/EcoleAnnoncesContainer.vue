<template>
  <div>
    <div class="block is-flex is-justify-content-flex-end gap-4">
      <button class="button is-primary" @click="creationModalOpened = true">Créer une nouvelle annonce</button>
      <a href="/logout" class="button is-danger">Se déconnecter</a>
    </div>
    <h1 class="title is-3 has-text-centered">Mes annonces</h1>
    <hr />
    <EcoleAnnoncesListVue :modal-creation-state="creationModalOpened"></EcoleAnnoncesListVue>
    <EcoleCreateAnnonceVue
      :opened="creationModalOpened"
      @close="creationModalOpened = false"
    />
  </div>
</template>
<script setup lang="ts">
import { ref } from "vue";
import EcoleAnnoncesListVue from "./EcoleAnnoncesList.vue";
import EcoleCreateAnnonceVue from "./EcoleCreateAnnonce.vue";

const creationModalOpened = ref(false);
</script>
