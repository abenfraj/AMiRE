<template>
    <span v-if="!isEdit" :class="className">{{ modelValue }}</span>
    <input v-else 
        :value="modelValue"
        @input="$emit('update:modelValue', $event.target.value)"
        class="input is-inline"
        :placeholder="placeholder"
        :type="type ?? 'text'"
        :required="required"
    />
</template>
  
<script setup lang="ts">
const events = defineEmits(["update:modelValue"]);
const props = defineProps<{
    modelValue: string;
    isEdit: boolean;
    type?: string;
    required?: true;
    placeholder?: string;
    className?: string | string[];
}>();


</script>
