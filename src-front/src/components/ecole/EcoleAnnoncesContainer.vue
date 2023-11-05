<template>
  <div>
    <div class="block is-flex is-justify-content-flex-end gap-4">
      <button class="button is-primary">
        Créer une nouvelle annonce
      </button>
      <a href="/logout" class="button is-danger">Se déconnecter</a>
    </div>
    <h1 class="title is-3 has-text-centered">
        Mes annonces
    </h1>
    <hr>
    <EcoleAnnoncesListVue></EcoleAnnoncesListVue>
  </div>
</template>
<script setup lang="ts">
import EcoleAnnoncesListVue from './EcoleAnnoncesList.vue';
</script>