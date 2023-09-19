package org.javarush.oleksandr.l7mvclive.repository;


import org.javarush.oleksandr.l7mvclive.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

}

