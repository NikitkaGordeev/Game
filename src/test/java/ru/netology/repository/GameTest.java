package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Player;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    Game game = new Game();
    Player player1 = new Player(001, "Илья", 90);
    Player player2 = new Player(002, "Иван", 98);
    Player player3 = new Player(003, "Андрей", 90);

    @BeforeEach
    public void addPlayers() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
    }

    @Test
    public void shouldIssueId() {
        player1.setId(001);
        int expected = 001;
        int actual = player1.getId();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldIssueName() {
        player2.setName("Иван");
        String expected = "Иван";
        String actual = player2.getName();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldIssueStrength() {
        player2.setStrength(98);
        int expected = 98;
        int actual = player2.getStrength();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCheckNoOneIsRegistered() {
        Assertions.assertThrows(NotRegisteredException.class, () ->
                game.round("Александр", "Дмитрий"));
    }

    @Test
    public void shouldCheckNoIsRegisteredPlayerOne() {
        Assertions.assertThrows(NotRegisteredException.class, () ->
                game.round("Илья", "Дмитрий"));
    }

    @Test
    public void shouldCheckNoIsRegisteredPlayerTwo() {
        Assertions.assertThrows(NotRegisteredException.class, () ->
                game.round("Денис", "Иван"));
    }
    @Test
    public void shouldWinPlayerTwo() {
        Assertions.assertEquals(2,game.round("Илья","Иван"));
    }
    @Test
    public void Draw() {
        Assertions.assertEquals(0,game.round("Илья","Андрей"));
    }
    @Test
    public void shouldWinPlayerOne() {
        Assertions.assertEquals(1,game.round("Иван","Андрей"));
    }
}