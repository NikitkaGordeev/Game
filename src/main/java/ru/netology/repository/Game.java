package ru.netology.repository;

import ru.netology.domain.Player;
import java.util.ArrayList;
import java.util.List;

public class Game {
    List<Player> playersList = new ArrayList<>();

    public void register(Player player) {
        playersList.add(player);
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = null;
        Player player2 = null;
        for (Player player : playersList) {
            if (player.getName().equals(playerName1)) {
                player1 = player;
            }
            if (player.getName().equals(playerName2)) {
                player2 = player;

            }
        }
        if (player1 == null) {
            throw new NotRegisteredException(playerName1 + "Не зарегестрирован");
        }
        if (player2 == null) {
            throw new NotRegisteredException(playerName2 + "Не зарегестрирован");
        }
        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        }
        if (player1.getStrength() < player2.getStrength()) {
            return 2;
        } else {
            return 0;
        }
    }
}
