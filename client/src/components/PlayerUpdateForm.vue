<template>

  <div class="flex justify-center">

    <div class="player-create-form">

      <Input class="form-input" v-model="player.name" placeholder="enter player name" label="Name"/>
      <Input class="form-input" v-model="player.title" placeholder="enter player title" label="Title"/>

      <Select class="form-input" v-model="player.race" :options="parseRaceEnum()" label="Race"/>
      <Select class="form-input" v-model="player.profession" :options="parseProfessionEnum()" label="Profession"/>


      <label for="birthday">Birthday:</label>

      <input class="form-input" id="birthday" type="date" v-model="player.birthday" label="Birthday"/>

      <Input class="form-input" v-model="player.level" placeholder="enter player level" label="Level"/>

      <Checkbox class="form-input" v-model="player.banned" label="Banned"/>


      <Button @click="updatePlayer" color="default">Update</Button>

    </div>
  </div>

</template>

<script lang="ts">
import {Checkbox, Input, Select, Button} from 'flowbite-vue'
import axios from "axios";
import {Race} from "@/types/Race";
import {Player} from "@/types/Player";
import {Profession} from "@/types/Profession";


export default {
  name: "PlayerUpdateForm",
  // eslint-disable-next-line vue/no-reserved-component-names
  components: {Checkbox, Input, Select, Button},
  data() {
    return {
      id: 0,
      player: {} as Player,
    }
  },
  computed: {
    Race() {
      return Race
    }
  },
  methods: {
    updatePlayer() {
      axios.put("http://localhost:8080/api/player/update", {
            id: this.player.id,
            name: this.player.name,
            title: this.player.title,
            race: this.player.race,
            profession: this.player.profession,
            birthday: new Date(this.player.birthday).getTime(),
            level: this.player.level,
            banned: this.player.banned,
          }
      ).then(function (response) {
        console.log(response);
      })
          .catch(function (error) {
            console.log(error);
          });
    },
    getPlayerProfile() {
      const path = "http://localhost:8080/api/player/get/" + this.id;
      axios
          .get(path)
          .then((res) => {
            this.player.id = res.data.id;
            this.player.name = res.data.name;
            this.player.title = res.data.title;
            this.player.race = res.data.race;
            this.player.profession = res.data.profession;
            this.player.birthday = new Date(res.data.birthday).toISOString().slice(0,10);
            this.player.level = res.data.level;
            this.player.banned = res.data.banned;
          })
          .catch((error) => {
            console.error(error);
          });
    },

    parseRaceEnum() {
      const raceArray = Object.keys(Race).map((key) => ({
        value: key,
        name: Race[key],
      }));

      return raceArray;
    },

    parseProfessionEnum() {
      const ProfessionArray = Object.keys(Profession).map((key) => ({
        value: key,
        name: Profession[key],
      }));

      return ProfessionArray;
    },

  },
  created() {
    this.id = Number(this.$route.params.id);
    this.getPlayerProfile();
  },
}
</script>

<style scoped>
.player-create-form {
  width: 500px;
  padding: 20px;
  border: 1px solid #ccc;
  border-radius: 5px;
  background-color: #fff;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
}

.form-input {
  margin-bottom: 10px;
}

input {
  display:block;
  width: 100%;
}
label {
  display:block;
  margin-bottom: 5px;
}
</style>

