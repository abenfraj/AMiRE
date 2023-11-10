<template>
  <p v-if="!isEdit" :class="className">
    <span v-for="line in lines" :key="line.key"> {{ line.line }} <br /> </span>
  </p>
  <textarea
    v-else
    :value="modelValue"
    @input="$emit('update:modelValue', ($event.target as any).value)"
    class="textarea"
    :placeholder="placeholder"
    :required="required"
  />
</template>

<script setup lang="ts">
import { computed } from "vue";

const events = defineEmits(["update:modelValue"]);
const props = defineProps<{
  modelValue: string;
  isEdit: boolean;
  type?: string;
  required?: true;
  placeholder?: string;
  className?: string | string[];
}>();

const lines = computed(() =>
  props.modelValue.split("\n").map((line, i) => ({
    line: line.trim().replace(/^- /, "• "),
    key: i,
  })),
);
</script>
