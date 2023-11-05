<template>
    <p v-if="!isEdit" :class="className" class="is-flex gap-2">
        <span v-for="tag in tags" :key="tag.key" class="tag">
            {{ tag.tag }}
        </span>
    </p>
    <input v-else 
        :value="modelValue"
        @input="$emit('update:modelValue', $event.target.value)"
        class="input is-inline"
        :placeholder="placeholder"
        type="type"
        :required="required"
    />
</template>
  
<script setup lang="ts">
import { computed } from 'vue';

const events = defineEmits(["update:modelValue"]);
const props = defineProps<{
    modelValue: string;
    isEdit: boolean;
    type?: string;
    required?: true;
    placeholder?: string;
    className?: string | string[];
}>();

const tags = computed(() => props.modelValue.split(",").map((tag, i) => ({
    tag: tag.trim(),
    key: i,
})));
</script>
