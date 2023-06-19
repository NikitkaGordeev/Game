package ru.netology.domain;

public class Main {
    public static void main(String[] args) {
        Player player1 = new Player();
        player1.name = "Иван";
        player1.id = 001;
        player1.strength = 87;
        System.out.println(player1);
        Player player2 = new Player();
        player2.name = "Андрей";
        player2.id = 002;
        player2.strength = 86;
        System.out.println(player2);
    }

}
