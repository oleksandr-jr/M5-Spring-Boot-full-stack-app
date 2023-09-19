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
    

  </div>
</template>

<script setup lang="ts">

import {Breadcrumb, BreadcrumbItem} from "flowbite-vue";
</script>

<style scoped>

</style>