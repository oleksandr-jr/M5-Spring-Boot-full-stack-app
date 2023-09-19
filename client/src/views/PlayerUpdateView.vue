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
        <router-link :to="{ name: 'player',  params: { id: playerId } }">Player</router-link>
      </BreadcrumbItem>

      <BreadcrumbItem>
        <router-link :to="{ name: 'player.update' }">Update</router-link>
      </BreadcrumbItem>
    </Breadcrumb>


    <div class="body">
      <PlayerUpdateForm/>
    </div>

  </div>
</template>

<script lang="ts">
import {Breadcrumb, BreadcrumbItem} from "flowbite-vue";
import PlayerUpdateForm from "@/components/PlayerUpdateForm.vue";


export default {
  components: {PlayerUpdateForm, BreadcrumbItem, Breadcrumb},
  data() {
    return {
      playerId: 0,
    }
  },
  created() {
    this.playerId = Number(this.$route.params.id);
  },
}
</script>

<style scoped>

.body {
  margin-top: 50px;
}

</style>