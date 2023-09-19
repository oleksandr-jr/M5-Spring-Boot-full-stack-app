<template>

  <div>
    <Table hoverable>
      <table-head>
        <table-head-cell>Name</table-head-cell>
        <table-head-cell>Title</table-head-cell>
        <table-head-cell>Race</table-head-cell>
        <table-head-cell>Profession</table-head-cell>
        <table-head-cell>Birthday</table-head-cell>
        <table-head-cell>Banned</table-head-cell>
        <table-head-cell>Experience</table-head-cell>
        <table-head-cell>Level</table-head-cell>
        <table-head-cell>Until next level</table-head-cell>
      </table-head>
      <table-body>
        <table-row v-for="player in players" v-bind:key="player.id">
          <table-cell> {{ player.name }}</table-cell>
          <table-cell> {{ player.title }}</table-cell>
          <table-cell> {{ player.race }}</table-cell>
          <table-cell> {{ player.profession }}</table-cell>
          <table-cell> {{ player.birthday }}</table-cell>
          <table-cell> {{ player.banned }}</table-cell>
          <table-cell> {{ player.experience }}</table-cell>
          <table-cell> {{ player.level }}</table-cell>
          <table-cell> {{ player.untilNextLevel }}</table-cell>
        </table-row>

      </table-body>
    </Table>

  </div>
</template>

<script lang="ts">
import {Table, TableBody, TableCell, TableHead, TableHeadCell, TableRow} from 'flowbite-vue'
import {defineComponent} from 'vue'
import axios from "axios";
import type Player from "@/types/Player";

export default defineComponent({
  // eslint-disable-next-line vue/no-reserved-component-names
  components: {TableRow, TableCell, TableHeadCell, TableBody, TableHead, Table},
  props: {},
  data() {
    return {
      players: [] as Player[]
    }

  },
  mounted() {

  },
  methods: {
    getPlayersList() {
      const path = "http://localhost:8080/api/player/list";
      axios
          .get(path)
          .then((res) => {
            this.players = res.data;
          })
          .catch((error) => {
            console.error(error);
          });
    },

  },
  created() {
    this.getPlayersList();
  },
})

</script>

<style scoped>

</style>