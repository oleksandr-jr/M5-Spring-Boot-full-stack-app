<script lang="ts">

import {Breadcrumb, BreadcrumbItem} from "flowbite-vue";
import PlayersList from "@/components/PlayersList.vue";
export default {
  components: {PlayersList, BreadcrumbItem, Breadcrumb},
}


</script>

<template>
  <div>
    <Breadcrumb solid>
      <BreadcrumbItem home>
        <router-link :to="{ name: 'home' }">Home</router-link>
      </BreadcrumbItem>
      <BreadcrumbItem>
        Players
      </BreadcrumbItem>
    </Breadcrumb>

    <PlayersList />
  </div>
</template>

<style scoped>

</style>