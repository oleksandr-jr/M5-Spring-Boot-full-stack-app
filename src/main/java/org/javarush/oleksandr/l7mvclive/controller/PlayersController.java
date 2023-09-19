package org.javarush.oleksandr.l7mvclive.controller;

import lombok.RequiredArgsConstructor;
import org.javarush.oleksandr.l7mvclive.model.Player;
import org.javarush.oleksandr.l7mvclive.service.PlayerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/player")
@RequiredArgsConstructor
public class PlayersController {

    private final PlayerService playerService;
    // key -> value
    @GetMapping("/list")
    public String index(Model model) {
        model.addAttribute("players", playerService.getAll());

        return "players/index";
    }

    @GetMapping("/{id}")
    public String showPlayerPage(@PathVariable long id, Model model) {
        model.addAttribute("player", playerService.getById(id));
        return "players/player-page";
    }

    @GetMapping("/edit/{id}")
    public String updatePlayerPage(@PathVariable long id, Model model) {
        model.addAttribute("player", playerService.getById(id));
        return "players/edit";
    }

    @GetMapping("/create")
    public String createPlayerPage(Model model) {
        model.addAttribute("player", new Player());
        return "players/create";
    }

    @PostMapping("/create")
    public String createPlayer(Player player, Model model) {
        System.out.println("creste Player");
        playerService.savePlayer(player);
        return "redirect:/player/" + player.getId();
    }

    @PostMapping("/update/{id}")
    public String updatePlayerPage(@PathVariable long id, Player player, Model model) {
        playerService.savePlayer(player);
        return "redirect:/player/" + id;
    }

    @GetMapping("/delete/{id}")
    public String deletePlayer(@PathVariable long id, Model model) {
        playerService.deleteById(id);
        return "redirect:/player/list";
    }
}
