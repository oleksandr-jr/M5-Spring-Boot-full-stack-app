package org.javarush.oleksandr.l7mvclive.repository;

import org.apache.catalina.User;
import org.javarush.oleksandr.l7mvclive.model.Player;
import org.javarush.oleksandr.l7mvclive.model.Profession;
import org.javarush.oleksandr.l7mvclive.model.Race;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@AutoConfigureTestDatabase
@Rollback
public class RepositoryTest {
    @Autowired
    private PlayerRepository playerRepository;

    @Test
    public void testAddNewPlayer() {
        Player player = Player.builder()
                .name("testName")
                .title("best")
                .level(1)
                .experience(0)
                .profession(Profession.CLERIC)
                .race(Race.DWARF)
                .untilNextLevel(1000)
                .banned(false)
                .birthday(new java.util.Date())
                .build();

        playerRepository.save(player);

        assertNotNull(player);
        assertTrue(player.getId() > 0);
    }

}
