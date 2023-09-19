<template>
  <div>
    <Breadcrumb solid>
      <BreadcrumbItem href="#" home>
        Home
      </BreadcrumbItem>
      <BreadcrumbItem>
        <router-link :to="{ name: 'players.list' }">Players</router-link>
      </BreadcrumbItem>
      <BreadcrumbItem>
        Player
      </BreadcrumbItem>
    </Breadcrumb>

    <div class="body">
      <PlayerProfile/>
    </div>

  </div>
</template>


<script lang="ts">
import PlayerProfile from "@/components/PlayerProfile.vue";
import {Breadcrumb, BreadcrumbItem} from 'flowbite-vue'

export default {
  components: {BreadcrumbItem, PlayerProfile, Breadcrumb},

}
</script>

<style>
.body {
  margin-top: 50px;
}
</style>
