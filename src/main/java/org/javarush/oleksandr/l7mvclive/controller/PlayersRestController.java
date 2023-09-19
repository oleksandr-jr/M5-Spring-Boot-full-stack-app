package org.javarush.oleksandr.l7mvclive.controller;

import lombok.RequiredArgsConstructor;
import org.javarush.oleksandr.l7mvclive.model.Player;
import org.javarush.oleksandr.l7mvclive.service.PlayerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/player")
@RequiredArgsConstructor
@CrossOrigin
public class PlayersRestController {
    private final PlayerService playerService;

    //get all players
    @GetMapping("/list")
    public List<Player> getAllPlayers() {
        return playerService.getAll();
    }


    @GetMapping("/get/{id}")
    public Player getPlayerById(@PathVariable long id) {
        return playerService.getById(id);
    }

    @PostMapping("/create")
    public Player createPlayer(@RequestBody Player player) {
        return playerService.savePlayer(player);
    }

    @DeleteMapping("/{id}")
    public void deletePlayer(@PathVariable long id) {
        playerService.deleteById(id);
    }

    @PutMapping("/update")
    public Player updatePlayer(@RequestBody Player player) {
        return playerService.savePlayer(player);
    }
}
