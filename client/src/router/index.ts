import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import PlayerView from "../views/PlayerView.vue";
import PlayersListView from "@/views/PlayersListView.vue";
import PlayerCreateView from "@/views/PlayerCreateView.vue";
import PlayerUpdateView from "@/views/PlayerUpdateView.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/player/:id',
      name: 'player',
      component: PlayerView
    },
    {
      path: '/player/create',
      name: 'player.create',
      component: PlayerCreateView
    },
    {
      path: '/player/update/:id',
      name: 'player.update',
      component: PlayerUpdateView
    },

    {
      path: '/players/list',
      name: 'players.list',
      component: PlayersListView
    },
  ]
})

export default router
