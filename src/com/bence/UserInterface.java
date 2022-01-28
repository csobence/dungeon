package com.bence;

import java.util.Scanner;

public class UserInterface {
    Game game;
    Combat combat;
    Items items;
    Classes classes;
    Monsters monsters;
    Scanner scanner;
    Arts arts;
    Chest chest;
    Traproom traproom;
    Campfire campfire;
    Weapon weapon;
    Armor armor;
    boolean select = false;
    boolean should = false;
    boolean reset = true;
    int look = 1;
    int right = 0;
    int left = 0;
    int forward = 0;


    public UserInterface(Game game, Classes classes, Monsters monsters, Scanner scanner, Arts arts, Combat combat, Items items, Chest chest, Traproom traproom,
                         Campfire campfire, Weapon weapon, Armor armor) {
        this.game = game;
        this.traproom = traproom;
        this.campfire = campfire;
        this.chest = chest;
        this.combat = combat;
        this.items = items;
        this.classes = classes;
        this.monsters = monsters;
        this.scanner = scanner;
        this.arts = arts;
        this.weapon = weapon;
        this.armor = armor;
    }

    public void startGame() throws InterruptedException {
        select = true;

        while (select) {
            System.out.println("Choose a class: ");
            game.classList();
            String choose = scanner.next();
            classes.chooseClass(choose);
            if (classes.isChosen()) {
                System.out.println("Your class is the " + choose);
                select = false;
                should = true;
            } else {
                System.out.println("Wrong class!");
            }
        }
        while (should) {
            if (classes.getHealth() <= 0) {
                should = false;
                System.out.println("You have died!");
                break;
            }
            System.out.println("Type a command (commandlist): ");
            String command = scanner.next();

            if (reset) {
                right = game.roomChance();
                left = game.roomChance();
                forward = game.roomChance();
                while (left == right || right == forward || forward == left) {
                    right = game.roomChance();
                    left = game.roomChance();
                    forward = game.roomChance();
                }
                reset = false;
                look = 1;
            }
            switch (command) {
                case "quit":
                    System.out.println("Bye!");
                    should = false;
                    break;
                case "commandlist":
                    game.commandList();
                    break;
                case "abilities":
                    game.abilityList();
                    break;
                case "items":
                    items.items();
                    break;
                case "stats":
                    combat.stats();
                    break;
                case "attributes":
                    game.attributes();
                    break;
                case "equipment":
                    if (weapon.getCurrentWeapon().isEmpty()) {
                        System.out.println("Weapon: basic weapon" );
                    } else {
                        System.out.println("Weapon: " + weapon.getCurrentWeapon());
                    }
                    if (armor.currentHelmet.isEmpty()) {
                        System.out.println("Helmet: basic helmet" );
                    } else {
                        System.out.println("Helmet: " + armor.currentHelmet);
                    }
                    if (armor.currentChest.isEmpty()) {
                        System.out.println("Chest: basic chest" );
                    } else {
                        System.out.println("Chest: " + armor.currentChest);
                    }
                    if (armor.currentLeggings.isEmpty()) {
                        System.out.println("Leggings: basic leggings" );
                    } else {
                        System.out.println("Leggings: " + armor.currentLeggings);
                    }
                    if (armor.currentBoots.isEmpty()) {
                        System.out.println("Boots: basic boots" );
                    } else {
                        System.out.println("Boots: " + armor.currentBoots);
                    }
                    break;
                case "look":
                    if (look > 0) {
                        System.out.println("Which direction? (right, left, forward)");
                        String answer = scanner.next();
                        if (answer.equalsIgnoreCase("right")) {
                            System.out.println(game.answer(right));
                            look = 0;
                            reset = false;
                        } else if (answer.equalsIgnoreCase("left")) {
                            game.answer(left);
                            System.out.println(game.answer(left));
                            look = 0;
                            reset = false;
                        } else if (answer.equalsIgnoreCase("forward")) {
                            game.answer(forward);
                            System.out.println(game.answer(forward));
                            look = 0;
                            reset = false;
                        } else {
                            System.out.println("You can't look that way!");
                        }
                    } else if (look == 0) {
                        System.out.println("You already used your look command.");
                        reset = false;
                    }
                    break;
                case "right":
                    if (right == 0) {
                        System.out.println("The room is empty.");
                    } else if (right == 1) {
                        combat.combat();
                    } else if (right == 2) {
                        campfire.campfire();
                    } else if (right == 3) {
                        chest.chest();
                    } else if (right == 4) {
                        traproom.trapRoom();
                    }
                    reset = true;
                    break;
                case "left":
                    if (left == 0) {
                        System.out.println("The room is empty.");
                    } else if (left == 1) {
                        combat.combat();
                    } else if (left == 2) {
                        campfire.campfire();
                    } else if (left == 3) {
                        chest.chest();
                    } else if (left == 4) {
                        traproom.trapRoom();
                    }
                    reset = true;
                    break;
                case "forward":
                    if (forward == 0) {
                        System.out.println("The room is empty.");
                    } else if (forward == 1) {
                        combat.combat();
                    } else if (forward == 2) {
                        campfire.campfire();
                    } else if (forward == 3) {
                        chest.chest();
                    } else if (forward == 4) {
                        traproom.trapRoom();
                    }
                    reset = true;
                    break;
                case "back":
                    System.out.println("You can go back.");
                    reset = false;
                    break;
                default:
                    System.out.println("Wrong command!");
            }
        }
    }
}
