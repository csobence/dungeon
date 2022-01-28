package com.bence;

public class Traproom {
    Game game;
    Classes classes;
    Combat combat;
    Monsters monsters;

    public Traproom(Game game, Classes classes, Combat combat, Monsters monsters) {
        this.game = game;
        this.classes = classes;
        this.combat = combat;
        this.monsters = monsters;
    }

    public void trapRoom() {
        int trap = game.trapChance();
        int trapDamage = 8 * monsters.getNewGamePlus();
        System.out.println("ITS A TRAP!\n");
        if (classes.role.equals(Role.ROGUE)) {
            System.out.println("You have dodged the trap.");
        } else {
            if (trap == 0) {
                System.out.println("Bear trap: " + trapDamage + " psychical damage.\n");
                if (classes.psychicalDefense() + combat.getTransformPsychicalDef() >= trapDamage) {
                    System.out.println("You have blocked the trap");
                } else {
                    classes.setHealth(classes.getHealth() + combat.getTransformPsychicalDef() - Math.abs(classes.psychicalDefense() - trapDamage));
                }
                System.out.println("Your health is: " + classes.getHealth() + "/" + classes.maxHealth());
                System.out.println("You mana is: " + classes.getMana() + "/" + classes.maxMana());
            } else if (trap == 1) {
                System.out.println("Fire trap: " + trapDamage + " magical damage\n");
                if (classes.magicalDefense() + combat.getTransformMagicalDef() >= trapDamage) {
                    System.out.println("You have absorbed the damage.");
                } else {
                    classes.setHealth(classes.getHealth() + combat.getTransformMagicalDef() - Math.abs(classes.magicalDefense() - trapDamage));
                }
                System.out.println("Your health is: " + classes.getHealth() + "/" + classes.maxHealth());
                System.out.println("You mana is: " + classes.getMana() + "/" + classes.maxMana());
            }
        }
    }
}
