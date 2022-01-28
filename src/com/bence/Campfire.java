package com.bence;

public class Campfire {

    Classes classes;
    Combat combat;
    Arts arts;

    public Campfire(Combat combat, Arts arts, Classes classes) {
        this.combat = combat;
        this.arts = arts;
        this.classes = classes;
    }

    public void campfire() {
        arts.campfire();
        System.out.println("You have found a campfire.\n");
        classes.setHealth(classes.maxHealth());
        classes.setMana(classes.maxMana());
        System.out.println("Your health is: " + classes.health() + "/" + classes.maxHealth());
        System.out.println("You mana is: " + classes.getMana() + "/" + classes.maxMana());
        System.out.println("You have " + classes.getEXP() + "/" + classes.getMaxExp() + " experience points.");
        if (classes.role.equals(Role.NECROMANCER)) {
            if (combat.getUndeadSmall() > 0) {
                System.out.println("You have " + combat.getUndeadSmall() + " small sized minions.");
            }
            if (combat.getUndeadNormal() > 0) {
                System.out.println("You have " + combat.getUndeadNormal() + " normal sized minions.");
            }
            if (combat.getUndeadBig() > 0) {
                System.out.println("You have " + combat.getUndeadBig() + " big sized minions.");
            }
            if (combat.getGigantos() > 0) {
                System.out.println("You have Gigantos, the destroyer.");
            }
        }
        if (classes.role.equals(Role.SHAPESHIFTER)) {
            if (combat.getTransformPsychicalDmg() == 6) {
                System.out.println("Your current form is a rat.");
            } else if (combat.getTransformMagicalDmg() == 6) {
                System.out.println("Your current form is a slime.");
            } else if (combat.getTransformPsychicalDmg() == 8) {
                System.out.println("Your current form is a goblin.");
            } else if (combat.getTransformMagicalDmg() == 8) {
                System.out.println("Your current form is a zombie.");
            } else if (combat.getTransformPsychicalDmg() == 10) {
                System.out.println("Your current form is a skeleton.");
            } else if (combat.getTransformMagicalDmg() == 10) {
                System.out.println("Your current form is a wyvern.");
            } else if (combat.getTransformPsychicalDmg() == 12) {
                System.out.println("Your current form is a ogre.");
            } else if (combat.getTransformMagicalDmg() == 12) {
                System.out.println("Your current form is a troll.");
            }
        }
    }
}
