package com.bence;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Classes classes = new Classes();
        Arts arts = new Arts();
        Monsters monsters = new Monsters();
        Items items = new Items(classes, scanner);
        Game game = new Game(classes, arts);
        Combat combat = new Combat(game, classes, arts, items, monsters, scanner);
        Weapon weapon = new Weapon(classes, arts, scanner, items);
        Armor armor = new Armor(classes, arts, scanner, items);
        Chest chest = new Chest(classes, arts, scanner, items, weapon, armor, monsters);
        Traproom traproom = new Traproom(game, classes, combat, monsters);
        Campfire campfire = new Campfire(combat, arts, classes);

        UserInterface userInterface = new UserInterface(game, classes, monsters, scanner, arts, combat, items, chest, traproom, campfire, weapon, armor);

        userInterface.startGame();
    }
}
