<template>
  <p>Home view</p>

  <router-link :to="{ name: 'players.list' }">
    <Button>Players list </Button>
  </router-link>


  <router-link :to="{ name: 'player.create' }">
    <Button>  Create Player</Button>
  </router-link>
</template>


<script lang="ts">
import {Button} from "flowbite-vue";

export default {
  components: {Button},
  data() {
    return {

    }
  },
  methods: {

  },
  created() {

  },

}
</script>

