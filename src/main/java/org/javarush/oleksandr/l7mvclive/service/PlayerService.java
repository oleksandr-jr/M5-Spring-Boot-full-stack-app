package org.javarush.oleksandr.l7mvclive.service;


import lombok.RequiredArgsConstructor;
import org.javarush.oleksandr.l7mvclive.model.Player;
import org.javarush.oleksandr.l7mvclive.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerService {

    private final PlayerRepository repository;

    public Player savePlayer(Player Player) {
        return repository.save(Player);
    }

    public Player getById(long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Player> getAll() {
        return repository.findAll();
    }

    public void deleteById(long id) {
        repository.deleteById(id);
    }


    public void deleteAll() {
        repository.deleteAll();
    }

    public void delete(Player Player) {
        repository.delete(Player);
    }

    // update
    public Player updatePlayer(Player Player) {
        return repository.save(Player);
    }

    public boolean existsById(long id) {
        return repository.existsById(id);
    }

    public long count() {
        return repository.count();
    }

    public List<Player> saveAll(List<Player> Players) {
        return repository.saveAll(Players);
    }

    public List<Player> findAll() {
        return repository.findAll();
    }

    public List<Player> findAllById(List<Long> ids) {
        return repository.findAllById(ids);
    }



}
