package org.javarush.oleksandr.service;

import org.javarush.oleksandr.entity.Player;
import org.javarush.oleksandr.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepository repository;

    public Player savePlayer(Player Player) {
        return repository.save(Player);
    }

    public Player getPlayer(long id) {
        return repository.findById(id).orElse(null);
    }



}
