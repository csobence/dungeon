package com.bence;

import java.util.Random;
import java.util.Scanner;

public class Items{

    Classes classes;
    Scanner scanner;
    Random rand = new Random();
    boolean select = false;
    boolean reset = true;

    boolean battle = true;
    int healthPotion = 0;
    int manaPotion = 0;
    int smokeBomb = 0;

    public Items(Classes classes, Scanner scanner) {
        this.classes = classes;
        this.scanner = scanner;
    }

    public void items() {
        select = true;
        while (select) {
            int rollPotion = rand.nextInt(6);
            System.out.println("Health, mana, smoke or close: ");
            System.out.println("Health Potions: " + getHealthPotion());
            System.out.println("Mana Potions: " + getManaPotion());
            System.out.println("Smoke bombs: " + getSmokeBomb());
            String use = scanner.next();
            switch (use) {
                case "health":
                    if (getHealthPotion() > 0) {
                        setHealthPotion(getHealthPotion() - 1);
                        if ((rollPotion + classes.getNewGameScore()) + classes.getHealth() >= classes.maxHealth()) {
                            classes.setHealth(classes.maxHealth());
                        } else if ((rollPotion + classes.getNewGameScore()) + classes.getHealth() < classes.maxHealth()) {
                            classes.setHealth(classes.getHealth() + (rollPotion + classes.getNewGameScore()));
                        }
                        System.out.println("You used a health potion.");
                        System.out.println("Your health is " + classes.getHealth());
                        select = false;
                    } else {
                        System.out.println("You don't have health potions.");
                    }
                    break;
                case "mana":
                    if (getManaPotion() > 0) {
                        setManaPotion(getManaPotion() - 1);
                        if ((rollPotion + classes.getNewGameScore()) + classes.getMana() >= classes.maxMana()) {
                            classes.setMana(classes.maxMana());
                        } else if ((rollPotion + classes.getNewGameScore()) + classes.getMana() < classes.maxMana()) {
                            classes.setMana(classes.getMana() + (rollPotion + classes.getNewGameScore()));
                        }
                        System.out.println("You used a mana potion.");
                        System.out.println("Your mana is " + classes.getMana());
                        select = false;
                    } else {
                        System.out.println("You don't have mana potions.");
                    }
                    break;
                case "smoke":
                    if (getSmokeBomb() > 0) {
                        if (battle) {
                            setSmokeBomb(getSmokeBomb() - 1);
                            System.out.println("You have used a smoke bomb and fled from the battle!");
                            battle = false;
                        } else {
                            setSmokeBomb(getSmokeBomb() - 1);
                            System.out.println("You have used a smoke bomb...");
                        }
                    } else {
                        System.out.println("You don't have smoke bombs.");
                    }
                case "close":
                    select = false;
                    reset = false;
                    break;
                default:
                    System.out.println("Wrong command!");
            }
        }
    }
    public int getHealthPotion() {
        return healthPotion;
    }

    public void setHealthPotion(int healthPotion) {
        this.healthPotion = healthPotion;
    }

    public int getManaPotion() {
        return manaPotion;
    }

    public void setManaPotion(int manaPotion) {
        this.manaPotion = manaPotion;
    }

    public int getSmokeBomb() {
        return smokeBomb;
    }

    public void setSmokeBomb(int smokeBomb) {
        this.smokeBomb = smokeBomb;
    }

    public void setBattle(boolean battle) {
        this.battle = battle;
    }

    public boolean getBattle() {
        return battle;
    }
}
