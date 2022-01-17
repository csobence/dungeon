package com.bence;

import java.util.Random;

public class Game {

    private boolean gameOver = false;
    Arts arts;
    Classes classes;

    public Game(Classes classes, Arts arts) {
        this.classes = classes;
        this.arts = arts;
    }

    public int roomChance() {
        Random rand = new Random();
        int roll = rand.nextInt(5);

        return roll;
    }

    public String answer(int num) {
        String word = "";
        if (num == 0) {
            word = "The room looks empty.";
        } else if (num == 1) {
            word = "You can hear some noises from the room.";
        } else if (num == 2) {
            word = "You feel warmth from the room.";
        } else if (num == 3) {
            word = "You can see a chest.";
        } else if (num == 4) {
            word = "The room looks empty, but...";
        }
        return word;
    }

    public int trapChance() {
        Random rand = new Random();
        int roll = rand.nextInt(2);
        return roll;
    }

    public boolean gameOver() {
        if (gameOver == true) {
            return true;
        } else {
            return false;
        }
    }

    public void classList() {
        System.out.println("Warrior: the strong guy with the sword");
        System.out.println("Mage: your typical magic dude");
        System.out.println("Priest: jack of all trades, master of none");
        System.out.println("Rogue: the shady guy");
        System.out.println("Samurai: the japanese guy with the katana");
        System.out.println("Berserker: the crazy guy");
        System.out.println("Warlock: the cult guy");
        System.out.println("Paladin: the guy who hiding behind his shield");
        System.out.println("Gunslinger: the guy with the guns");
        System.out.println("Gambler: the dude with the dice");
        System.out.println("Necromancer: the guy with the zombies");
        System.out.println("Shapeshifter: the copycat");
    }

    public void abilitiList() {
        System.out.println("Strike: deals psychical damage to the enemy");
        System.out.println("Magic: deals magical damage to the enemy and costs 4 mana");
        if (classes.isWarrior()) {
            System.out.println("Bloodbath: your next strike restore your health by the amount of damage you have dealt");
        } else if (classes.isMage()) {
            System.out.println("Fireball: deals a huge magical damage and costs 10 mana");
        } else if (classes.isPriest()) {
            System.out.println("Heal: restore your own health");
        } else if (classes.isRogue()) {
            System.out.println("Stealth: you become invisible and you can use backstab or flee");
            System.out.println("Backstab: deals a huge pure damage to the enemy, it breaks stealth");
            System.out.println("Flee: you can flee without taking damage");
        } else if (classes.isSamurai()) {
            System.out.println("Iaido: you sheath your weapon for one turn, and after you next time use iaido, you deals " +
                    "*4 psychical damage");
        } else if (classes.isBerserker()) {
            System.out.println("Rampage: take off half your health and increases your psychical damage that amount");
            System.out.println("Passive: you get more physical damage the lower your health are");
        } else if (classes.isWarlock()) {
            System.out.println("Shadowbolt: sacrifice 8 health for a huge magical damage");
            System.out.println("Passive: your magic skill restores health");
        } else if (classes.isPaladin()) {
            System.out.println("Reflect: you will reflect the 100% of your opponent's next damage for 6 mana");
            System.out.println("Passive: you have 30% chance to block the incoming physical attacks");
        } else if (classes.isGunslinger()) {
            System.out.println("Barrage: deals psychical damage if you used strike before or magical damage if you used magic before");
            System.out.println("Passive: your barrage has a chance to shot again");
        } else if (classes.isGambler()) {
            System.out.println("Roll: You roll a D6.");
            System.out.println("If you roll 1: Auto flee from the battle");
            System.out.println("If you roll 2: take off half of your health");
            System.out.println("If you roll 3: nothing will happen");
            System.out.println("If you roll 4: deals psychical damage * 2 damage");
            System.out.println("If you roll 5: deals magical damage * 3 damage");
            System.out.println("If you roll 6: deals 45 pure damage");
            System.out.println("Passive: you only get good items from chests");
        } else if (classes.isNecromancer()) {
            System.out.println("Claws: command your undead minions to attack, deals psychical damage");
        } else if (classes.isShapeshifter()) {
            System.out.println("Transform: you can transform into a defeated monster");
        }
        System.out.println("Flee: you can flee from the battle");
    }

    public void attributes() {
        System.out.println("Strength(STR): " + classes.getSTR());
        System.out.println("Intelligence(INT): " + classes.getINT());
        System.out.println("Constitution(CON): " + classes.getCON());
        System.out.println("Dexterity(DEX): " + classes.getDEX());
        System.out.println("Wisdom(WIS): " + classes.getWIS());
        System.out.println("Charisma(CHA): " + classes.getCHA());
    }

    public void monsterArt(int num) {
        if (num == 0) {
            arts.rat();
        } else if (num == 1) {
            arts.slime();
        } else if (num == 2) {
            arts.goblin();
        } else if (num == 3) {
            arts.zombie();
        } else if (num == 4) {
            arts.skeleton();
        } else if (num == 5) {
            arts.wyvern();
        } else if (num == 6) {
            arts.ogre();
        } else if (num == 7) {
            arts.troll();
        } else if (num == 8) {
            arts.dragon();
        }
    }
}
