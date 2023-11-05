<template>
    <img v-if="icon" :src="icon.src" :alt="icon.alt">
</template>

<script setup lang="ts">
import IconCrown from "@/assets/icon_crown.svg";
import IconBriefcase from "@/assets/icon_briefcase.svg";
import IconStudent from "@/assets/icon_student.svg";
import IconUser from "@/assets/icon_user.svg";

import { computed } from "vue";


const ICONS = {
    "crown": { src: IconCrown, alt: "👑" },
    "briefcase": { src: IconBriefcase, alt: "💼" },
    "student": { src: IconStudent, alt: "👨‍🎓" },
    "user": { src: IconUser, alt: "👤" },
};
export type IconName = keyof typeof ICONS | undefined;

const props = defineProps<{
    name: IconName;
}>();

const icon = computed(() => props.name ? ICONS[props.name] : undefined);
</script>