<template>
    <RouterLink class="button x-navButton pr-3" :class="{current: route.path == (props.href ?? '/') }" :to="props.href ?? '/'">
        <span class="icon mr-2">
            <Icon :name="props.icon" />
        </span>
        <span>
            <slot></slot>
        </span>
    </RouterLink>
</template>
<script setup lang="ts">
import { useRoute } from 'vue-router';
import type { IconName } from './Icon.vue';
import Icon from './Icon.vue';

const props = defineProps<{
    icon: IconName;
    href?: string;
}>();

const route = useRoute();
console.log(route.path);
</script>
<style scoped lang="scss">
.button.x-navButton {
    border: none;
    &:hover {
        background-color: #00d1b222;
    }
    
    &.current {
        border: 2px solid #00d1b222;
    }
}
</style>