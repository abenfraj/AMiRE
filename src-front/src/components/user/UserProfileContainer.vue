<template>
  <div v-if="profile">
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
  <LoadingSpinner v-if="!profile || isLoading" />
</template>
<script setup lang="ts">
import { EnseignantApi } from "@/lib/api/enseignant.api";
import type { EnseignantEntity } from "@/lib/api/entities";
import { ref } from "vue";
import UserProfileCatHeader from "./UserProfileCatHeader.vue";
import UserProfileCatSearch from "./UserProfileCatSearch.vue";
import UserProfileCatExperience from "./UserProfileCatExperience.vue";
import LoadingSpinner from "../utils/LoadingSpinner.vue";
import { UseAccount } from "@/lib/composables/useAccount";

const props = defineProps<{
  userId?: number;
}>();
const profile = ref<EnseignantEntity | null>(null);
const isLoading = ref<boolean>(false);
const account = UseAccount();

const getProfile = async () => {
  profile.value = await EnseignantApi.getEnseignant(
    props.userId ?? account.id.value,
  );
};
const patchProfile = async (newProfile: Partial<EnseignantEntity>) => {
  isLoading.value = true;
  profile.value = await EnseignantApi.saveEnseignant(
    props.userId ?? account.id.value,
    newProfile,
  );
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
