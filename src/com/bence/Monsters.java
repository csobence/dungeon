package com.bence;

import java.util.Random;

public class Monsters {

    private String name;
    private int maxHealth;
    private int psychicalDamage;
    private int magicalDamage;
    private int psychicalDefense;
    private int magicalDefense;
    private int exp;
    private int dmg;
    private int initiative;
    private int transformCode;

    private int newGamePlus = 1;

    public Monsters() {

    }

    public void monsterDraw(int num) {
        if (num == 0) {
            name = "Rat";
            maxHealth = 15;
            dmg = 5;
            psychicalDamage = 6;
            magicalDamage = 0;
            psychicalDefense = 2;
            magicalDefense = 0;
            exp = 10;
            initiative = 0;
            transformCode = 0;
            setMaxHealth(maxHealth);
        } else if (num == 1) {
            name = "Slime";
            maxHealth = 15;
            dmg = 5;
            psychicalDamage = 0;
            magicalDamage = 6;
            psychicalDefense = 0;
            magicalDefense = 2;
            exp = 10;
            initiative = 0;
            transformCode = 1;
            setMaxHealth(maxHealth);
        } else if (num == 2) {
            name = "Goblin";
            maxHealth = 20;
            dmg = 5;
            psychicalDamage = 10;
            magicalDamage = 0;
            psychicalDefense = 5;
            magicalDefense = 2;
            exp = 20;
            initiative = 2;
            transformCode = 2;
            setMaxHealth(maxHealth);
        } else if (num == 3) {
            name = "Zombie";
            maxHealth = 20;
            dmg = 5;
            psychicalDamage = 0;
            magicalDamage = 10;
            psychicalDefense = 2;
            magicalDefense = 5;
            exp = 20;
            initiative = 2;
            transformCode = 3;
            setMaxHealth(maxHealth);
        } else if (num == 4) {
            name = "Skeleton";
            maxHealth = 25;
            dmg = 5;
            psychicalDamage = 12;
            magicalDamage = 0;
            psychicalDefense = 7;
            magicalDefense = 4;
            exp = 30;
            initiative = 4;
            transformCode = 4;
            setMaxHealth(maxHealth);
        } else if (num == 5) {
            name = "Wyvern";
            maxHealth = 25;
            dmg = 5;
            psychicalDamage = 0;
            magicalDamage = 12;
            psychicalDefense = 4;
            magicalDefense = 7;
            exp = 30;
            initiative = 4;
            transformCode = 5;
            setMaxHealth(maxHealth);
        } else if (num == 6) {
            name = "Ogre";
            maxHealth = 30;
            dmg = 5;
            psychicalDamage = 15;
            magicalDamage = 0;
            psychicalDefense = 10;
            magicalDefense = 7;
            exp = 40;
            initiative = 6;
            transformCode = 6;
            setMaxHealth(maxHealth);
        } else if (num == 7) {
            name = "Troll";
            maxHealth = 30;
            dmg = 5;
            psychicalDamage = 0;
            magicalDamage = 15;
            psychicalDefense = 7;
            magicalDefense = 10;
            exp = 40;
            initiative = 6;
            transformCode = 7;
            setMaxHealth(maxHealth);
        } else if (num == 8) {
            name = "Dragon";
            maxHealth = 50;
            dmg = 5;
            psychicalDamage = 14;
            magicalDamage = 14;
            psychicalDefense = 14;
            magicalDefense = 14;
            exp = 0;
            initiative = 8;
            setMaxHealth(maxHealth);
        }
    }

    public String getName() {
        return name;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int num) {
        maxHealth = num;
    }

    public int dmg() {
        return dmg;
    }

    public int getPsychicalDamage() {
        return psychicalDamage;
    }

    public int getMagicalDamage() {
        return magicalDamage;
    }

    public int getPsychicalDefense() {
        return psychicalDefense;
    }

    public int getMagicalDefense() {
        return magicalDefense;
    }

    public int getExp() {
        return exp;
    }

    public int getInitiative() {
        Random rand = new Random();
        int roll = rand.nextInt(20) + 1;
        return roll + initiative;
    }

    public int getTransformCode() {
        return transformCode;
    }

    public void setNewGamePlus(int newGamePlus) {
        this.newGamePlus = newGamePlus;
    }
    public int getNewGamePlus() {
        return newGamePlus;
    }

    public void increaseStats() {
            maxHealth = maxHealth * getNewGamePlus();
            dmg = dmg * getNewGamePlus();
            psychicalDamage = psychicalDamage * getNewGamePlus();
            magicalDamage = magicalDamage * getNewGamePlus();
            psychicalDefense = psychicalDefense * getNewGamePlus();
            magicalDefense = magicalDefense * getNewGamePlus();
            initiative = initiative * getNewGamePlus();
    }
}
