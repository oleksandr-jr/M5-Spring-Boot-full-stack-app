<template>
  <Modal :size="xs" v-if="isShowModal" @close="closeModal">
    <template #header>
      <div class="flex items-center text-lg">
        Are you sure you want to delete this player?
      </div>
    </template>
    <template #body>
      <p class="text-base leading-relaxed text-gray-500 dark:text-gray-400">
        Once you delete this player, it cannot be undone.
      </p>
    </template>
    <template #footer>
      <div class="flex justify-between">
        <button @click="closeModal" type="button" class="text-gray-500 bg-white hover:bg-gray-100 focus:ring-4 focus:outline-none focus:ring-blue-300 rounded-lg border border-gray-200 text-sm font-medium px-5 py-2.5 hover:text-gray-900 focus:z-10 dark:bg-gray-700 dark:text-gray-300 dark:border-gray-500 dark:hover:text-white dark:hover:bg-gray-600 dark:focus:ring-gray-600">
          CANCEL
        </button>
        <button @click="deletePlayerProfile" type="button" class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">
                    <router-link :to="{ name: 'players.list' }">DELETE</router-link>
        </button>
      </div>
    </template>
  </Modal>



  <div class="flex justify-center">

    <div class="player-profile">

      <div class="flex align-ite flex-col items-center justify-center mb-5">
        <h2>{{ player.name }}</h2>
        <p>{{ player.title }}</p>
      </div>
      <div class="profile-details ml-2">
        <div><strong>Race:</strong> {{ player.race }}</div>
        <div><strong>Profession:</strong> {{ player.profession }}</div>
        <div><strong>Birthday:</strong> {{ new Date(player.birthday).toLocaleDateString() }}</div>
        <div><strong>Banned:</strong> {{ player.banned ? 'Yes' : 'No' }}</div>
        <div><strong>Experience:</strong> {{ player.experience }}</div>
        <div><strong>Level:</strong> {{ player.level }}</div>
        <div v-if="player.untilNextLevel !== null">
          <strong>Until Next Level:</strong> {{ player.untilNextLevel }}
        </div>
      </div>
      <div class="mt-5">
        <Button class="m-2" color="default">
          <router-link :to="{ name: 'player.update' }">EDIT</router-link>
        </Button>

        <Button @click="showModal" class="m-2" color="red">
          DELETE
        </Button>
      </div>

    </div>
  </div>

</template>

<script lang="ts">
import {defineComponent} from 'vue'
import {Button, Modal} from 'flowbite-vue'
import axios from "axios";
import type Player from "@/types/Player";
import { ref } from 'vue'

export default defineComponent({
  // eslint-disable-next-line vue/no-reserved-component-names
  components: {Modal, Button},
  data() {
    return {
      id: 0,
      player: {} as Player,
      isShowModal: ref(false),
    }
  },
  methods: {
    getPlayerProfile() {
      const path = "http://localhost:8080/api/player/get/" + this.id;
      axios
          .get(path)
          .then((res) => {
            this.player = res.data;
          })
          .catch((error) => {
            console.error(error);
          });
    },
    deletePlayerProfile() {
      const path = "http://localhost:8080/api/player/" + this.id;
      axios.delete(path)

    },
    closeModal() {
      this.isShowModal = false
    },
    showModal() {
      this.isShowModal = true
    }

  },
  created() {
    this.id = Number(this.$route.params.id);
    this.getPlayerProfile();
  },

});

</script>

<style scoped>
.player-profile {
  width: 500px;
  padding: 20px;
  border: 1px solid #ccc;
  border-radius: 5px;
  background-color: #fff;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
}
</style>