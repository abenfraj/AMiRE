<template>
  <div :class="{ loading: isLoading }" v-if="profile">
    <UserProfileCatHeader
      :profile="profile"
      @trigger-patch="patchProfile(profile)"
    ></UserProfileCatHeader>
    <UserProfileCatSearch
      :profile="profile"
      @trigger-patch="patchProfile(profile)"
    ></UserProfileCatSearch>
    <UserProfileCatExperience
      :profile="profile"
      @trigger-patch="patchProfile(profile)"
    ></UserProfileCatExperience>
  </div>
</template>
<script setup lang="ts">
import { EnseignantApi } from "@/lib/api/enseignant.api";
import type { EnseignantEntity } from "@/lib/api/entities";
import { ref } from "vue";
import UserProfileCatHeader from "./UserProfileCatHeader.vue";
import UserProfileCatSearch from "./UserProfileCatSearch.vue";
import UserProfileCatExperience from "./UserProfileCatExperience.vue";

const profile = ref<EnseignantEntity | null>(null);
const isLoading = ref<boolean>(false);

const getProfile = async () => {
  profile.value = await EnseignantApi.getEnseignant();
};
const patchProfile = async (newProfile: Partial<EnseignantEntity>) => {
  isLoading.value = true;
  profile.value = await EnseignantApi.saveEnseignant(newProfile);
  isLoading.value = false;
};

getProfile();
</script>
<style scoped>
.loading {
  opacity: 0.5;
  pointer-events: none;
}
</style>
