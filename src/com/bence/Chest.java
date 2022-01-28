package com.bence;

import java.util.Random;
import java.util.Scanner;

public class Chest {

    Classes classes;
    Scanner scanner;
    Arts arts;
    Items items;
    Weapon weapon;
    Armor armor;
    Random rand = new Random();
    Monsters monsters;
    boolean select = false;
    boolean reset = true;

    public Chest(Classes classes, Arts arts, Scanner scanner, Items items, Weapon weapon, Armor armor, Monsters monsters) {
        this.classes = classes;
        this.arts = arts;
        this.scanner = scanner;
        this.items = items;
        this.weapon = weapon;
        this.armor = armor;
        this.monsters = monsters;
    }

    public Chest(Classes classes, Arts arts, Scanner scanner, Items items) {
    }


    public void chest() {
        arts.chest();
        System.out.println("You have found a chest.");
        System.out.println("Open the chest or leave?");
        select = true;
        while (select) {
            String chest = scanner.next();
            if (chest.equalsIgnoreCase("open")) {
                int roll = rand.nextInt(10);
                if (classes.role.equals(Role.GAMBLER)) {
                    while (roll == 0 || roll == 9) {
                        roll = rand.nextInt(10);
                    }
                }
                if (roll == 0) {
                    arts.empty();
                    System.out.println("The chest is empty.");
                    select = false;
                } else if (roll == 1) {
                    arts.bomb();
                    System.out.println("You have found a Smoke bomb.");
                    items.setSmokeBomb(items.getSmokeBomb() + 1);
                    select = false;
                } else if (roll == 2 || roll == 3) {
                    arts.hpotion();
                    System.out.println("You have  found a Health Potion.");
                    items.setHealthPotion(items.getHealthPotion() + 1);
                    select = false;
                } else if (roll == 4 || roll == 5) {
                    arts.mpotion();
                    System.out.println("You have  found a Mana Potion.");
                    items.setManaPotion(items.getManaPotion() + 1);
                    select = false;
                } else if (roll == 6 ||roll == 7) {
                    armor.armorDrop();
                    select = false;
                } else if (roll == 8) {
                    arts.weapon();
                    weapon.weaponDrop();
                    select = false;
                } else {
                    arts.mimic();
                    System.out.println("You have found MIMIC, the deadly battle chest!");
                    if (classes.role.equals(Role.ROGUE)) {
                        System.out.println("You have dodged the mimic's attack and it ran away.");
                    } else {
                        int mimicDamage = 5* monsters.getNewGamePlus();
                        System.out.println("MIMC has dealt " + mimicDamage + " damage and ran away!");
                        classes.setHealth(Math.max(classes.getHealth() - mimicDamage, 0));
                        System.out.println("You have " + classes.getHealth() + "/" + classes.maxHealth() + " health.");
                        System.out.println("You have " + classes.getMana() + "/" + classes.maxMana() + " mana.");
                    }
                    select = false;
                }
            } else if (chest.equalsIgnoreCase("leave")) {
                System.out.println("You have left the room.");
                select = false;
                reset = true;
            } else {
                System.out.println("Wrong command!");
            }
        }
    }

}
