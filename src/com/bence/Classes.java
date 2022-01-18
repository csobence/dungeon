package com.bence;

import java.util.Random;
import java.util.Scanner;

public class Classes {
    Role role;
    private int STR = 1;
    private int INT = 1;
    private int CON = 1;
    private int DEX = 1;
    private int WIS = 1;
    private int CHA = 1;
    private int EXP = 0;
    private int maxExp = 20;
    private int skillPoint = 0;
    private boolean instant = false;
    private int health = health();
    private int mana = mana();
    private int levelUpScore = 1;
    Scanner scanner = new Scanner(System.in);

    public Classes() {

    }

    public void chooseClass(String name) {
        if (name.equalsIgnoreCase("warrior")) {
            role = Role.WARRIOR;
            setSTR(16);
            setINT(12);
            setCON(16);
            setDEX(12);
            setWIS(10);
            setCHA(10);
            health = maxHealth();
            mana = maxMana();
        }
        if (name.equalsIgnoreCase("mage")) {
            role = Role.MAGE;
            setSTR(10);
            setINT(16);
            setCON(12);
            setDEX(10);
            setWIS(14);
            setCHA(14);
            health = maxHealth();
            mana = maxMana();
        }
        if (name.equalsIgnoreCase("priest")) {
            role = Role.PRIEST;
            setSTR(13);
            setINT(13);
            setCON(12);
            setDEX(12);
            setWIS(14);
            setCHA(12);
            health = maxHealth();
            mana = maxMana();
        }
        if (name.equalsIgnoreCase("rogue")) {
            role = Role.ROGUE;
            setSTR(12);
            setINT(12);
            setCON(10);
            setDEX(16);
            setWIS(10);
            setCHA(16);
            health = maxHealth();
            mana = maxMana();
        }
        if (name.equalsIgnoreCase("samurai")) {
            role = Role.SAMURAI;
            setSTR(12);
            setINT(10);
            setCON(14);
            setDEX(14);
            setWIS(10);
            setCHA(16);
            health = maxHealth();
            mana = maxMana();
        }
        if (name.equalsIgnoreCase("berserker")) {
            role = Role.BERSERKER;
            setSTR(14);
            setINT(12);
            setCON(16);
            setDEX(14);
            setWIS(10);
            setCHA(10);
            health = maxHealth();
            mana = maxMana();
        }
        if (name.equalsIgnoreCase("warlock")) {
            role = Role.WARLOCK;
            setSTR(10);
            setINT(16);
            setCON(16);
            setDEX(10);
            setWIS(14);
            setCHA(10);
            health = maxHealth();
            mana = maxMana();
        }
        if (name.equalsIgnoreCase("paladin")) {
            role = Role.PALADIN;
            setSTR(12);
            setINT(12);
            setCON(16);
            setDEX(10);
            setWIS(12);
            setCHA(14);
            health = maxHealth();
            mana = maxMana();
        }
        if (name.equalsIgnoreCase("gunslinger")) {
            role = Role.GUNSLINGER;
            setSTR(12);
            setINT(14);
            setCON(12);
            setDEX(14);
            setWIS(10);
            setCHA(14);
            health = maxHealth();
            mana = maxMana();
        }
        if (name.equalsIgnoreCase("gambler")) {
            role = Role.GAMBLER;
            setSTR(12);
            setINT(14);
            setCON(12);
            setDEX(14);
            setWIS(10);
            setCHA(14);
            health = maxHealth();
            mana = maxMana();
        }
        if (name.equalsIgnoreCase("Necromancer")) {
            role = Role.NECROMANCER;
            setSTR(12);
            setINT(14);
            setCON(12);
            setDEX(10);
            setWIS(14);
            setCHA(14);
            health = maxHealth();
            mana = maxMana();
        }
        if (name.equalsIgnoreCase("Shapeshifter")) {
            role = Role.SHAPESHIFTER;
            setSTR(14);
            setINT(14);
            setCON(14);
            setDEX(12);
            setWIS(10);
            setCHA(12);
            health = maxHealth();
            mana = maxMana();
        }
    }

    public int psychicalDamage() {
        int roll = 0;
        int damage = 0;
        Random rand = new Random();
        if (role.equals(Role.WARRIOR) || role.equals(Role.PALADIN)) {
            roll = rand.nextInt(10);
            damage = roll + attackPower();
        } else if (role.equals(Role.PRIEST) || role.equals(Role.ROGUE) || role.equals(Role.SAMURAI) || role.equals(Role.BERSERKER)) {
            roll = rand.nextInt(8);
            damage = roll + attackPower();
        } else if (role.equals(Role.GAMBLER)) {
            roll = rand.nextInt(5);
            damage = roll + attackPower();
        } else {
            damage = attackPower();
        }
        return damage;
    }

    public int magicalDamage() {
        int roll = 0;
        int damage = 0;
        Random rand = new Random();
        if (role.equals(Role.MAGE)) {
            roll = rand.nextInt(8);
            damage = roll + magicPower();
        } else if (role.equals(Role.PRIEST) || role.equals(Role.WARLOCK) || role.equals(Role.NECROMANCER)) {
            roll = rand.nextInt(3);
            damage = roll + magicPower();
        } else {
            damage = magicPower();
        }
        return damage;
    }

    public int psychicalDefense() {
        return CON - 10;
    }

    public int magicalDefense() {
        return INT - 10;
    }

    public int maxHealth() {
        return 10 + (CON - 10) * 2;
    }

    public int health() {
        return 10 + (CON - 10) * 2;
    }

    public void setHealth(int num) {
        if (num <= maxHealth()) {
            health = num;
        } else {
            health = maxHealth();
        }
    }

    public int getHealth() {
        return health;
    }

    public int maxMana() {
        return 10 + (WIS - 10) * 2;
    }

    public int mana() {
        return 10 + (WIS - 10) * 2;
    }

    public void setMana(int num) {
        if (num <= maxMana()) {
            mana = num;
        } else {
            mana = maxMana();
        }
    }

    public int getMana() {
        return mana;
    }

    public int attackPower() {
        return (STR - 10) + (STR - 10) / 2;
    }

    public int magicPower() {
        return (INT - 10) * 2;
    }

    public int initiative() {
        Random iniRand = new Random();
        int ini = iniRand.nextInt(20) + 1;
        return ini + ((CHA - 10) * 2);
    }

    public int heal() {
        return (WIS - 10) + (WIS - 10) / 2;
    }

    public int critChance() {
        return (DEX - 10);
    }

    public int getSTR() {
        return STR;
    }

    public int getINT() {
        return INT;
    }

    public int getCON() {
        return CON;
    }

    public int getDEX() {
        return DEX;
    }

    public int getWIS() {
        return WIS;
    }

    public int getCHA() {
        return CHA;
    }

    public void setSTR(int num) {
        STR = num;

    }

    public void setINT(int num) {
        INT = num;
    }

    public void setCON(int num) {
        CON = num;
    }

    public void setDEX(int num) {
        DEX = num;
    }

    public void setWIS(int num) {
        WIS = num;
    }

    public void setCHA(int num) {
        CHA = num;
    }

    public void setEXP(int num) {
        EXP = num;
    }

    public int getEXP() {
        return EXP;
    }

    public int getInitiative() {
        return (CHA - 10) * 2;
    }

    public String classAbiliti() {
        String abiliti = "";
        if (role.equals(Role.WARRIOR)) {
            abiliti = "Bloodbath";
        } else if (role.equals(Role.MAGE)) {
            abiliti = "Fireball";
        } else if (role.equals(Role.PRIEST)) {
            abiliti = "Heal";
        } else if (role.equals(Role.ROGUE)) {
            abiliti = "Stealth";
        } else if (role.equals(Role.SAMURAI)) {
            abiliti = "Iaido";
        } else if (role.equals(Role.BERSERKER)) {
            abiliti = "Rampage";
        } else if (role.equals(Role.WARLOCK)) {
            abiliti = "Shadowbolt";
        } else if (role.equals(Role.PALADIN)) {
            abiliti = "Reflect";
        } else if (role.equals(Role.GUNSLINGER)) {
            abiliti = "Barrage";
        } else if (role.equals(Role.GAMBLER)) {
            abiliti = "Roll";
        } else if (role.equals(Role.NECROMANCER)) {
            abiliti = "Claws";
        } else if (role.equals(Role.SHAPESHIFTER)) {
            abiliti = "Transform";
        }
        return abiliti;
    }

    public void levelUP() throws InterruptedException {
        levelUpScore++;
        Thread.sleep(1000);
        System.out.println("LEVEL UP!");
        System.out.println("Choose a stat to improve:");
        System.out.println("Strength(STR): + psychical damage");
        System.out.println("Intelligence(INT): + magical damage + magical defense");
        System.out.println("Constitution(CON): + health and psychical defense");
        System.out.println("Dexterity(DEX): + critical chance");
        System.out.println("Wisdom(WIS): + mana and heal");
        System.out.println("Charisma(CHA): + initiative");
        skillPoint = 2;
        maxExp = maxExp + 20;
        if (levelUpScore == 6) {
            instant = true;
        }
        while (skillPoint == 2) {
            String lup = scanner.next();
            switch (lup) {
                case "STR":
                    setSTR(getSTR() + 1);
                    System.out.println("Your STR is " + getSTR());
                    skillPoint = skillPoint - 1;
                    break;
                case "INT":
                    setINT(getINT() + 1);
                    System.out.println("Your INT is " + getINT());
                    skillPoint = skillPoint - 1;
                    break;
                case "CON":
                    setCON(getCON() + 1);
                    System.out.println("Your CON is " + getCON());
                    skillPoint = skillPoint - 1;
                    break;
                case "DEX":
                    setDEX(getDEX() + 1);
                    System.out.println("Your DEX is " + getDEX());
                    skillPoint = skillPoint - 1;
                    break;
                case "WIS":
                    setWIS(getWIS() + 1);
                    System.out.println("Your WIS is " + getWIS());
                    skillPoint = skillPoint - 1;
                    break;
                case "CHA":
                    setCHA(getCHA() + 1);
                    System.out.println("Your CHA is " + getCHA());
                    skillPoint = skillPoint - 1;
                    break;
                default:
                    System.out.println("Wrong command!");
            }
            System.out.println("Choose another stat to improve:");
            System.out.println("Strength(STR): + psychical damage");
            System.out.println("Intelligence(INT): + magical damage + magical defense");
            System.out.println("Constitution(CON): + health and psychical defense");
            System.out.println("Dexterity(DEX): + critical chance");
            System.out.println("Wisdom(WIS): + mana and heal");
            System.out.println("Charisma(CHA): + initiative");
        }
        while (skillPoint == 1) {
            String lup = scanner.next();
            switch (lup) {
                case "STR":
                    setSTR(getSTR() + 1);
                    System.out.println("Your STR is " + getSTR());
                    skillPoint = skillPoint - 1;
                    break;
                case "INT":
                    setINT(getINT() + 1);
                    System.out.println("Your INT is " + getINT());
                    skillPoint = skillPoint - 1;
                    break;
                case "CON":
                    setCON(getCON() + 1);
                    System.out.println("Your CON is " + getCON());
                    skillPoint = skillPoint - 1;
                    break;
                case "DEX":
                    setDEX(getDEX() + 1);
                    System.out.println("Your DEX is " + getDEX());
                    skillPoint = skillPoint - 1;
                    break;
                case "WIS":
                    setWIS(getWIS() + 1);
                    System.out.println("Your WIS is " + getWIS());
                    skillPoint = skillPoint - 1;
                    break;
                case "CHA":
                    setCHA(getCHA() + 1);
                    System.out.println("Your CHA is " + getCHA());
                    skillPoint = skillPoint - 1;
                    break;
                default:
                    System.out.println("Wrong command!");
            }
        }
        System.out.println("Your level is " + levelUpScore);
        System.out.println("You have " + getEXP() + "/" + getMaxExp() + " experience points.");
    }



    public int dragonTrue() {
        return levelUpScore;
    }

    public int getMaxExp() {
        return maxExp;
    }
}
