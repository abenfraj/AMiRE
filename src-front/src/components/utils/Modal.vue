<template>
  <div class="modal" :class="{ 'is-active': props.isActive }">
    <div class="modal-background"></div>
    <div class="modal-card">
      <header class="modal-card-head">
        <p class="modal-card-title">{{ props.title }}</p>
        <button class="delete" aria-label="close" @click="handleClose"></button>
      </header>
      <section class="modal-card-body">
        <slot></slot>
      </section>
      <footer class="modal-card-foot is-justify-content-end">
        <button
          v-if="props.variant == 'ok'"
          class="button"
          @click="handleClose"
        >
          Fermer
        </button>
        <template v-else>
          <button class="button" @click="handleClose">Annuler</button>
          <button
            class="button is-success"
            @click="handleSave"
            :disabled="props.isLoading"
          >
            {{ props.isLoading ? "Sauvegarde en cours..." : "Enregistrer" }}
          </button>
        </template>
      </footer>
    </div>
  </div>
</template>
<script setup lang="ts">
const props = defineProps<{
  title: string;
  isLoading?: boolean;
  isActive: boolean;
  variant?: "ok";
}>();
const emits = defineEmits(["close", "save"]);
const handleClose = (e: Event) => {
  e.preventDefault();
  emits("close");
};
const handleSave = (e: Event) => {
  e.preventDefault();
  emits("save");
};
</script>
