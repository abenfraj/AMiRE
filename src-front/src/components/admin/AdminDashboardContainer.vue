<template>
  <div>
    <div class="block is-flex is-justify-content-flex-end gap-4">
      <button
        class="button is-primary"
        @click="ecoleCreationModalOpened = true"
      >
        Ajouter une école
      </button>
      <a href="logout" class="button is-danger">Se déconnecter</a>
    </div>
    <h1 class="title is-3 has-text-centered">Liste des écoles</h1>
    <hr />
    <AdminEcoleListVue :modal-creation-state="ecoleCreationModalOpened" />
    <AdminCreateEcole
      :opened="ecoleCreationModalOpened"
      @close="ecoleCreationModalOpened = false"
    ></AdminCreateEcole>
  </div>
</template>
<script setup lang="ts">
import AdminCreateEcole from "@/components/admin/AdminCreateEcole.vue";
import { ref } from "vue";
import AdminEcoleListVue from "./AdminEcoleList.vue";
const ecoleCreationModalOpened = ref(false);
</script>
