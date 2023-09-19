



<template>

  <Breadcrumb solid>
    <BreadcrumbItem href="#" home>
      Home
    </BreadcrumbItem>
    <BreadcrumbItem>
      <router-link :to="{ name: 'players.list' }">Players</router-link>
    </BreadcrumbItem>
    <BreadcrumbItem>
      Create player
    </BreadcrumbItem>
  </Breadcrumb>

  <div class="body">
    <CreatePlayerForm />
  </div>


</template>

<script lang="ts">
import CreatePlayerForm from "@/components/CreatePlayerForm.vue";
import {Breadcrumb, BreadcrumbItem} from "flowbite-vue";

export default {
  components: {BreadcrumbItem, Breadcrumb, CreatePlayerForm},
}
</script>

<style scoped>

.body {
  margin-top: 50px;
}

</style>