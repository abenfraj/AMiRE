<template>
    <p class="navbar-item control has-icons-left searchbar">
        <span class="input-container">
            <input class="input is-rounded ds-input" type="text" placeholder="Rechercher une offre" autocomplete="off">

            <span class="icon is-small is-left">
                <img :src="IconSearch" alt="🔎" width="18">
            </span>
        </span>
    </p>
</template>
<script setup lang="ts">
import IconSearch from "../../assets/icon_search.svg";
</script>
<style scoped lang="scss">
.input-container {
    position: relative;
    display: inline-block;

    input {
        background-color: #f5f5f5;
        position: relative;
        vertical-align: top;

    }
}
</style>