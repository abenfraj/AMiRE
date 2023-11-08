<template>
  <div :data-account-type="account.type.value">
    <Navbar></Navbar>
    <RouterView />
    <footer class="footer">
      <div class="content has-text-centered">
        <p>AMiRE - Projet Java Avancé semestre 7</p>
        <em>par Logan, Ayoub, Adam, Ali (LSI-1)</em>
      </div>
    </footer>
  </div>
</template>
<script setup lang="ts">
import { RouterView } from "vue-router";
import Navbar from "@/components/nav/Navbar.vue";
import { UseAccount } from "@/lib/composables/useAccount";
const account = UseAccount();
</script>
