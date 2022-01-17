package com.bence;

import java.util.Random;
import java.util.Scanner;

public class UserInterface {
    Game game;
    Classes classes;
    Monsters monsters;
    Scanner scanner;
    Arts arts;
    Random rand = new Random();
    boolean select = false;
    boolean should = false;
    boolean reset = true;
    boolean battle = false;
    boolean yourTurn = false;
    boolean monsterTurn = false;
    boolean levelUp = false;
    boolean bloodTrue = false;
    boolean iaidoTrue = false;
    boolean rampageTrue = true;
    boolean blockTrue = false;
    boolean reflectTrue = false;
    boolean magicTrue = false;
    boolean strikeTrue = false;
    boolean chestTrue = false;
    boolean itemsTrue = false;
    boolean ratTrue = false;
    boolean slimeTrue = false;
    boolean goblinTrue = false;
    boolean zombieTrue = false;
    boolean skeletonTrue = false;
    boolean wyvernTrue = false;
    boolean ogreTrue = false;
    boolean trollTrue = false;
    int chance10;
    int damage;
    int reload = 9;
    int abilitiScore = 0;
    int dragonScore = 0;
    int look = 1;
    int right = 0;
    int left = 0;
    int forward = 0;
    int healthPotion = 0;
    int manaPotion = 0;
    int smokeBomb = 0;
    int undeadSmall = 0;
    int undeadNormal = 0;
    int undeadBig = 0;
    int gigantos = 0;
    int transformPsychicalDmg = 0;
    int transformMagicalDmg = 0;
    int transformPsychicalDef = 0;
    int transformMagicalDef = 0;

    public UserInterface(Game game, Classes classes, Monsters monsters, Scanner scanner, Arts arts) {
        this.game = game;
        this.classes = classes;
        this.monsters = monsters;
        this.scanner = scanner;
        this.arts = arts;
    }

    public void gameOver() {
        yourTurn = false;
        monsterTurn = false;
        should = false;
    }

    public void startGame() throws InterruptedException {
        select = true;

        while (select) {
            System.out.println("Choose a class (classlist): ");
            String choose = scanner.next();

            switch (choose) {
                case "classlist":
                    game.classList();
                    break;
                case "warrior":
                    System.out.println("Your class is the warrior");
                    classes.chooseClass(choose);
                    select = false;
                    should = true;
                    break;
                case "mage":
                    System.out.println("Your class is the mage");
                    classes.chooseClass(choose);
                    select = false;
                    should = true;
                    break;
                case "priest":
                    System.out.println("Your class is the priest");
                    classes.chooseClass(choose);
                    select = false;
                    should = true;
                    break;
                case "rogue":
                    System.out.println("Your class is the rogue");
                    classes.chooseClass(choose);
                    select = false;
                    should = true;
                    break;
                case "samurai":
                    System.out.println("Your class is the samurai");
                    classes.chooseClass(choose);
                    select = false;
                    should = true;
                    break;
                case "berserker":
                    System.out.println("Your class is the berserker");
                    classes.chooseClass(choose);
                    select = false;
                    should = true;
                    break;
                case "warlock":
                    System.out.println("Your class is the warlock");
                    classes.chooseClass(choose);
                    select = false;
                    should = true;
                    break;
                case "paladin":
                    System.out.println("Your class is the paladin");
                    classes.chooseClass(choose);
                    select = false;
                    should = true;
                    blockTrue = true;
                    break;
                case "gunslinger":
                    System.out.println("Your class is the gunslinger");
                    classes.chooseClass(choose);
                    select = false;
                    should = true;
                    break;
                case "gambler":
                    System.out.println("Your class is the gambler");
                    System.out.println("Good luck!");
                    classes.chooseClass(choose);
                    select = false;
                    should = true;
                    break;
                case "necromancer":
                    System.out.println("Your class is the necromancer");
                    classes.chooseClass(choose);
                    select = false;
                    should = true;
                    break;
                case "shapeshifter":
                    System.out.println("Your class is the shapeshifter");
                    classes.chooseClass(choose);
                    select = false;
                    should = true;
                    break;
                case "quit":
                    System.out.println("Bye");
                    select = false;
                    break;
                default:
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
                while (left == right) {
                    left = game.roomChance();
                }
                forward = game.roomChance();
                while (left == forward || right == forward) {
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
                case "commandlist": {
                    System.out.println("Right: go right");
                    System.out.println("Left: go left");
                    System.out.println("Forward: go forward");
                    System.out.println("Look: you can look inside one of the rooms, once per turn");
                    System.out.println("Items: you can look at your items and you can use them");
                    System.out.println("Stats: the list of your stats");
                    System.out.println("Attributes: the list of your attributes");
                    System.out.println("Abilities: the list of your abilities");
                    System.out.println("Quit: quit the game");
                    break;
                }
                case "abilities":
                    game.abilitiList();
                    break;
                case "items":
                    items();
                    break;
                case "stats":
                    stats();
                    break;
                case "attributes":
                    game.attributes();
                    break;
                case "look":
                    if (look > 0) {
                        System.out.println("Which room? (right, left, forward)");
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
                        }
                    } else if (look == 0) {
                        System.out.println("You already used your look command.");
                        reset = false;
                    }
                    break;
                case "right":
                    if (game.gameOver()) {
                        gameOver();
                    }
                    if (right == 0) {
                        System.out.println("The room is empty.");
                    } else if (right == 1) {
                        combat();
                    } else if (right == 2) {
                        campfire();
                    } else if (right == 3) {
                        chest();
                    } else if (right == 4) {
                        trapRoom();
                    }
                    reset = true;
                    break;
                case "left":
                    if (game.gameOver()) {
                        gameOver();
                    }
                    if (left == 0) {
                        System.out.println("The room is empty.");
                    } else if (left == 1) {
                        combat();
                    } else if (left == 2) {
                        campfire();
                    } else if (left == 3) {
                        chest();
                    } else if (left == 4) {
                        trapRoom();
                    }
                    reset = true;
                    break;
                case "forward":
                    if (game.gameOver()) {
                        gameOver();
                    }
                    if (forward == 0) {
                        System.out.println("The room is empty.");
                    } else if (forward == 1) {
                        combat();
                    } else if (forward == 2) {
                        campfire();
                    } else if (forward == 3) {
                        chest();
                    } else if (forward == 4) {
                        trapRoom();
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

    public void flee() {
        damage = (monsters.getMagicalDamage() + monsters.getPsychicalDamage()) / 2;
        if (dragonScore == 1) {
            damage = monsters.getMagicalDamage() / 2;
        }
        System.out.println("You trying to flee and the monster attacks you in the back");
        System.out.println("");
        System.out.println("The " + monsters.getName() + " deals " + damage + "  damage.");
        if (classes.getHealth() - damage <= 0) {
            playerDeath();
        } else {
            System.out.println("You ran away!");
            dragonScore = 0;
            classes.setHealth(classes.getHealth() - damage);
            System.out.println("");
            System.out.println("You have " + classes.getHealth() + "/" + classes.maxHealth() + " health.");
            System.out.println("You have " + classes.getMana() + "/" + classes.maxMana() + " mana.");
            deform();
            strikeTrue = false;
            magicTrue = false;
            battle = false;
            yourTurn = false;
            monsterTurn = false;
            bloodTrue = false;
            iaidoTrue = false;
            reflectTrue = false;
        }
    }

    public void items() {
        itemsTrue = true;
        while (itemsTrue) {
            int rollPotion = rand.nextInt(6);
            System.out.println("Health, mana, smoke or close: ");
            System.out.println("Health Potions: " + healthPotion);
            System.out.println("Mana Potions: " + manaPotion);
            System.out.println("Smoke bombs: " + smokeBomb);
            String use = scanner.next();
            switch (use) {
                case "health":
                    if (healthPotion > 0) {
                        healthPotion = healthPotion - 1;
                        if ((rollPotion + 4) + classes.getHealth() >= classes.maxHealth()) {
                            classes.setHealth(classes.maxHealth());
                        } else if ((rollPotion + 4) + classes.getHealth() < classes.maxHealth()) {
                            classes.setHealth(classes.getHealth() + (rollPotion + 4));
                        }
                        System.out.println("You used a health potion.");
                        System.out.println("Your health is " + classes.getHealth());
                        itemsTrue = false;
                    } else {
                        System.out.println("You don't have health potions.");
                    }
                    break;
                case "mana":
                    if (manaPotion > 0) {
                        manaPotion = manaPotion - 1;
                        if ((rollPotion + 4) + classes.getMana() >= classes.maxMana()) {
                            classes.setMana(classes.maxMana());
                        } else if ((rollPotion + 4) + classes.getMana() < classes.maxMana()) {
                            classes.setMana(classes.getMana() + (rollPotion + 4));
                        }
                        System.out.println("You used a mana potion.");
                        System.out.println("Your mana is " + classes.getMana());
                        itemsTrue = false;
                    } else {
                        System.out.println("You don't have mana potions.");
                    }
                    break;
                case "smoke":
                    if (smokeBomb > 0) {
                        if (battle) {
                            smokeBomb = smokeBomb - 1;
                            System.out.println("You have used a smoke bomb and fled from the battle!");
                            dragonScore = 0;
                            battle = false;
                            yourTurn = false;
                            monsterTurn = false;
                        } else {
                            smokeBomb = smokeBomb - 1;
                            System.out.println("You have used a smoke bomb...");
                        }
                    } else {
                        System.out.println("You don't have smoke bombs.");
                    }
                case "close":
                    itemsTrue = false;
                    reset = false;
                    break;
                default:
                    System.out.println("Wrong command!");
            }
        }
    }

    public void campfire() {
        arts.campfire();
        System.out.println("You found a campfire.");
        System.out.println("");
        classes.setHealth(classes.maxHealth());
        classes.setMana(classes.maxMana());
        System.out.println("Your health is: " + classes.health() + "/" + classes.maxHealth());
        System.out.println("You mana is: " + classes.getMana() + "/" + classes.maxMana());
        System.out.println("You have " + classes.getEXP() + "/" + classes.getMaxExp() + " experience points.");
        if (classes.isNecromancer()) {
            if (undeadSmall > 0) {
                System.out.println("You have " + undeadSmall + " small sized minions.");
            }
            if (undeadNormal > 0) {
                System.out.println("You have " + undeadNormal + " normal sized minions.");
            }
            if (undeadBig > 0) {
                System.out.println("You have " + undeadBig + " big sized minions.");
            }
            if (gigantos > 0) {
                System.out.println("You have Gigantos, the destroyer.");
            }
        }
        if (classes.isShapeshifter()) {
            if (transformPsychicalDmg == 6) {
                System.out.println("Your current form is a rat.");
            } else if (transformMagicalDmg == 6) {
                System.out.println("Your current form is a slime.");
            } else if (transformPsychicalDmg == 8) {
                System.out.println("Your current form is a goblin.");
            } else if (transformMagicalDmg == 8) {
                System.out.println("Your current form is a zombie.");
            } else if (transformPsychicalDmg == 10) {
                System.out.println("Your current form is a skeleton.");
            } else if (transformMagicalDmg == 10) {
                System.out.println("Your current form is a wyvern.");
            } else if (transformPsychicalDmg == 12) {
                System.out.println("Your current form is a ogre.");
            } else if (transformMagicalDmg == 12) {
                System.out.println("Your current form is a troll.");
            }
        }
    }

    public void trapRoom() {
        int trap = game.trapChance();
        System.out.println("ITS A TRAP!");
        System.out.println("");
        if (classes.isRogue()) {
            System.out.println("You have dodged the trap.");
        } else {
            if (trap == 0) {
                System.out.println("Bear trap: 8 psychical damage.");
                System.out.println("");
                if (classes.psychicalDefense() + transformPsychicalDef >= 8) {
                    System.out.println("You have blocked the trap");
                } else {
                    classes.setHealth(classes.getHealth() + transformPsychicalDef - Math.abs(classes.psychicalDefense() - 8));
                }
                System.out.println("Your health is: " + classes.getHealth() + "/" + classes.maxHealth());
                System.out.println("You mana is: " + classes.getMana() + "/" + classes.maxMana());
            } else if (trap == 1) {
                System.out.println("Fire trap: 8 magical damage");
                System.out.println("");
                if (classes.magicalDefense() + transformMagicalDef >= 8) {
                    System.out.println("You have absorbed the damage.");
                } else {
                    classes.setHealth(classes.getHealth() + transformMagicalDef - Math.abs(classes.magicalDefense() - 8));
                }
                System.out.println("Your health is: " + classes.getHealth() + "/" + classes.maxHealth());
                System.out.println("You mana is: " + classes.getMana() + "/" + classes.maxMana());
            }
        }
    }

    public void chest() {
        arts.chest();
        System.out.println("You found a chest.");
        System.out.println("Open the chest or leave?");
        chestTrue = true;
        while (chestTrue) {
            String chest = scanner.next();
            if (chest.equalsIgnoreCase("open")) {
                int roll = rand.nextInt(9);
                if (classes.isGambler()) {
                    while (roll == 0 || roll == 8) {
                        roll = rand.nextInt(9);
                    }
                }
                if (roll == 0) {
                    arts.empty();
                    System.out.println("The chest is empty.");
                    chestTrue = false;
                } else if (roll == 1) {
                    arts.bomb();
                    System.out.println("You found a Smoke bomb.");
                    smokeBomb = smokeBomb + 1;
                    chestTrue = false;
                } else if (roll == 2 || roll == 3) {
                    arts.hpotion();
                    System.out.println("You found a Health Potion.");
                    healthPotion = healthPotion + 1;
                    chestTrue = false;
                } else if (roll == 4 || roll == 5) {
                    arts.mpotion();
                    System.out.println("You found a Mana Potion.");
                    manaPotion = manaPotion + 1;
                    chestTrue = false;
                } else if (roll == 6) {
                    int armorRoll1 = rand.nextInt(4);
                    int armorRoll2 = rand.nextInt(4);
                    while (armorRoll1 == armorRoll2) {
                        armorRoll2 = rand.nextInt(4);
                    }
                    arts.armor();
                    System.out.println("You found an Armor Update.");
                    if (armorRoll1 == 0 || armorRoll2 == 0) {
                        classes.setINT(classes.getINT() + 1);
                        System.out.println("Your intelligence is " + classes.getINT() + ".");
                    } else if (armorRoll1 == 1 || armorRoll2 == 1) {
                        classes.setWIS(classes.getWIS() + 1);
                        System.out.println("Your wisdom is " + classes.getWIS() + ".");
                    } else if (armorRoll1 == 2 || armorRoll2 == 2) {
                        classes.setCON(classes.getCON() + 1);
                        System.out.println("Your constitution is " + classes.getCON() + ".");
                    } else if (armorRoll1 == 3 || armorRoll2 == 3) {
                        classes.setCHA(classes.getCHA() + 1);
                        System.out.println("Your charisma is " + classes.getCHA() + ".");
                    }
                    chestTrue = false;
                } else if (roll == 7) {
                    int weaponRoll = rand.nextInt(3);
                    arts.weapon();
                    System.out.println("You found a Weapon Update.");
                    if (weaponRoll == 0) {
                        classes.setINT(classes.getINT() + 1);
                        System.out.println("Your intelligence is " + classes.getINT() + ".");
                    } else if (weaponRoll == 1) {
                        classes.setSTR(classes.getSTR() + 1);
                        System.out.println("Your strength is " + classes.getSTR() + ".");
                    } else if (weaponRoll == 2) {
                        classes.setDEX(classes.getDEX() + 1);
                        System.out.println("Your dexterity is " + classes.getDEX() + ".");
                    }
                    chestTrue = false;
                } else if (roll == 8) {
                    arts.mimic();
                    System.out.println("You have found MIMIC, the deadly battle chest!");
                    if (classes.isRogue() == true) {
                        System.out.println("You have dodged the mimic's attack and it ran away.");
                    } else {
                        System.out.println("It has dealt 5 damage and ran away!");
                        if (classes.getHealth() - 5 > 0) {
                            classes.setHealth(classes.getHealth() - 5);
                        } else {
                            classes.setHealth(0);
                        }
                        System.out.println("You have " + classes.getHealth() + "/" + classes.maxHealth() + " health.");
                        System.out.println("You have " + classes.getMana() + "/" + classes.maxMana() + " mana.");
                    }
                    chestTrue = false;
                }
            } else if (chest.equalsIgnoreCase("leave")) {
                System.out.println("You left the room.");
                chestTrue = false;
                reset = true;
            } else {
                System.out.println("Wrong command!");
            }
        }
    }

    public void monsterDeath() throws InterruptedException {
        System.out.println("The monster has died");
        System.out.println("");
        System.out.println("You have " + classes.getHealth() + "/" + classes.maxHealth() + " health.");
        System.out.println("You have " + classes.getMana() + "/" + classes.maxMana() + " mana.");
        System.out.println("You get " + monsters.getExp() + " experience points");
        monsters.setMaxHealth(monsters.getMaxHealth());
        if (dragonScore == 1) {
            arts.dragonDeath();
            System.out.println("You killed the Dragon at level " + classes.dragonTrue() + ".");
            System.out.println("Congratulations!");
            System.exit(0);
        }
        if (monsters.getTransformCode() == 0) {
            ratTrue = true;
        } else if (monsters.getTransformCode() == 1) {
            slimeTrue = true;
        } else if (monsters.getTransformCode() == 2) {
            goblinTrue = true;
        } else if (monsters.getTransformCode() == 3) {
            zombieTrue = true;
        } else if (monsters.getTransformCode() == 4) {
            skeletonTrue = true;
        } else if (monsters.getTransformCode() == 5) {
            wyvernTrue = true;
        } else if (monsters.getTransformCode() == 6) {
            ogreTrue = true;
        } else if (monsters.getTransformCode() == 7) {
            trollTrue = true;
        }
        if (classes.getEXP() + monsters.getExp() == classes.getMaxExp()) {
            levelUp = true;
            classes.setEXP(0);
        } else if (classes.getEXP() + monsters.getExp() < classes.getMaxExp()) {
            classes.setEXP(classes.getEXP() + monsters.getExp());
            System.out.println("You have " + classes.getEXP() + "/" + classes.getMaxExp() + " experience points.");
            levelUp = false;
        } else if (classes.getEXP() + monsters.getExp() > classes.getMaxExp()) {
            classes.setEXP(classes.getEXP() + monsters.getExp() - classes.getMaxExp());
            levelUp = true;
        }
        if (levelUp) {
            levelUp = false;
            classes.setHealth(classes.maxHealth());
            classes.setMana(classes.maxMana());
            classes.levelUP();
        }
        if (classes.isNecromancer()) {
            undead();
        }
        strikeTrue = false;
        magicTrue = false;
        yourTurn = false;
        monsterTurn = false;
        battle = false;
        iaidoTrue = false;
    }

    public void undead() {
        System.out.println("You have raised a small sized undead minion from your enemy's corpse's.");
        undeadSmall++;
        if (undeadSmall == 3) {
            undeadSmall = 0;
            undeadNormal++;
            System.out.println("Your 3 small sized undead merged into a normal size undead.");
        }
        if (undeadNormal == 3) {
            undeadNormal = 0;
            undeadBig++;
            System.out.println("Your 3 normal sized undead merged into a big size undead.");
        }
        if (undeadBig == 2) {
            undeadBig = 0;
            gigantos = 1;
            System.out.println("Your 2 big sized undead merged into Gigantos, the destroyer.");
        }
    }

    public void transform() {
        System.out.println("Which creature you would you transform into?");
        if (ratTrue) {
            System.out.println("Rat: psychical damage + 6, magical damage + 0, psychical defense + 2, magical defense + 0");
        }
        if (slimeTrue) {
            System.out.println("Slime: psychical damage + 0, magical damage + 6, psychical defense + 0, magical defense + 2");
        }
        if (goblinTrue) {
            System.out.println("Goblin: psychical damage + 8, magical damage + 0, psychical defense + 3, magical defense + 0");
        }
        if (zombieTrue) {
            System.out.println("Zombie: psychical damage + 0, magical damage + 8, psychical defense + 0, magical defense + 3");
        }
        if (skeletonTrue) {
            System.out.println("Skeleton: psychical damage + 10 , magical damage + 0, psychical defense + 5, magical defense + 2");
        }
        if (wyvernTrue) {
            System.out.println("Wyvern: psychical damage + 0, magical damage + 10, psychical defense + 2, magical defense + 5");
        }
        if (ogreTrue) {
            System.out.println("Ogre: psychical damage + 12, magical damage + 0, psychical defense + 7, magical defense + 4");
        }
        if (trollTrue) {
            System.out.println("Troll: psychical damage + 0, magical damage + 12, psychical defense + 4, magical defense + 7");
        }
        String transform = scanner.next();
        switch (transform) {
            case "rat":
                if (ratTrue) {
                    deform();
                    transformPsychicalDmg = 6;
                    transformMagicalDmg = 0;
                    transformPsychicalDef = 2;
                    transformMagicalDef = 0;
                    System.out.println("You are transformed into a rat.");
                } else {
                    System.out.println("You cant transform into that!");
                }
                break;
            case "slime":
                if (slimeTrue) {
                    deform();
                    transformPsychicalDmg = 0;
                    transformMagicalDmg = 6;
                    transformPsychicalDef = 0;
                    transformMagicalDef = 2;
                    System.out.println("You are transformed into a slime.");
                } else {
                    System.out.println("You cant transform into that!");
                }
                break;
            case "goblin":
                if (goblinTrue) {
                    deform();
                    transformPsychicalDmg = 8;
                    transformMagicalDmg = 0;
                    transformPsychicalDef = 3;
                    transformMagicalDef = 0;
                    System.out.println("You are transformed into a goblin.");
                } else {
                    System.out.println("You cant transform into that!");
                }
                break;
            case "zombie":
                if (zombieTrue) {
                    deform();
                    transformPsychicalDmg = 0;
                    transformMagicalDmg = 8;
                    transformPsychicalDef = 0;
                    transformMagicalDef = 3;
                    System.out.println("You are transformed into a zombie.");
                } else {
                    System.out.println("You cant transform into that!");
                }
                break;
            case "skeleton":
                if (skeletonTrue) {
                    deform();
                    transformPsychicalDmg = 10;
                    transformMagicalDmg = 0;
                    transformPsychicalDef = 5;
                    transformMagicalDef = 2;
                    System.out.println("You are transformed into a skeleton.");
                } else {
                    System.out.println("You cant transform into that!");
                }
                break;
            case "wyvern":
                if (wyvernTrue) {
                    deform();
                    transformPsychicalDmg = 0;
                    transformMagicalDmg = 10;
                    transformPsychicalDef = 2;
                    transformMagicalDef = 5;
                    System.out.println("You are transformed into a wyvern.");
                } else {
                    System.out.println("You cant transform into that!");
                }
                break;
            case "ogre":
                if (ogreTrue) {
                    deform();
                    transformPsychicalDmg = 12;
                    transformMagicalDmg = 0;
                    transformPsychicalDef = 7;
                    transformMagicalDef = 4;
                    System.out.println("You are transformed into a ogre.");
                } else {
                    System.out.println("You cant transform into that!");
                }
                break;
            case "troll":
                if (trollTrue) {
                    deform();
                    transformPsychicalDmg = 0;
                    transformMagicalDmg = 12;
                    transformPsychicalDef = 4;
                    transformMagicalDef = 7;
                    System.out.println("You are transformed into a troll.");
                } else {
                    System.out.println("You cant transform into that!");
                }
                break;
            default:
                System.out.println("You cant transform into that!");
        }
    }

    public void deform() {
        transformPsychicalDmg = 0;
        transformMagicalDmg = 0;
        transformPsychicalDef = 0;
        transformMagicalDef = 0;
    }

    public void playerDeath() {
        System.out.println("You have died!");
        yourTurn = false;
        monsterTurn = false;
        battle = false;
        should = false;
    }

    public void playerSurvived() {
        System.out.println("You have " + classes.getHealth() + "/" + classes.maxHealth() + " health.");
        System.out.println("You have " + classes.getMana() + "/" + classes.maxMana() + " mana.");
        rampageTrue = true;
        monsterTurn = false;
        yourTurn = true;
    }

    public void stats() {
        System.out.println("Level: " + classes.dragonTrue());
        System.out.println("Exp: " + classes.getEXP() + "/" + classes.getMaxExp());
        System.out.println("Maximum health: " + classes.maxHealth());
        System.out.println("Health: " + classes.getHealth());
        System.out.println("Maximum mana: " + classes.maxMana());
        System.out.println("Mana: " + classes.getMana());
        System.out.println("Psychical defense: " + (classes.psychicalDefense() + transformPsychicalDef));
        System.out.println("Magical defense: " + (classes.magicalDefense() + transformMagicalDef));
        System.out.println("Attack power: " + (classes.attackPower() + transformPsychicalDmg));
        System.out.println("Magic power: " + (classes.magicPower() + transformMagicalDmg));
        System.out.println("Initiative: " + classes.getInitiative());
        System.out.println("Critical chance: " + classes.critChance());
    }

    public void combat() throws InterruptedException {
        System.out.println("Enemy encounter: ");
        blockTrue = true;
        int chance;
        if (classes.dragonTrue() >= 1 && classes.dragonTrue() < 2) {
            chance = rand.nextInt(2);
        } else if (classes.dragonTrue() >= 2 && classes.dragonTrue() < 3) {
            chance = rand.nextInt(4);
        } else if (classes.dragonTrue() >= 3 && classes.dragonTrue() < 4) {
            chance = rand.nextInt(6);
        } else if (classes.dragonTrue() >= 4 && classes.dragonTrue() <= 5) {
            chance = rand.nextInt(8);
        } else if (classes.dragonTrue() >= 6 && classes.dragonTrue() < 8) {
            chance = rand.nextInt(9);
        } else if (classes.dragonTrue() == 8) {
            chance = 8;
        } else {
            chance = 8;
        }
        monsters.monsterDraw(chance);
        abilitiScore = 1;
        game.monsterArt(chance);
        System.out.println("You encountered a " + monsters.getName() + ", health: " + monsters.getMaxHealth());
        if (monsters.getName().equalsIgnoreCase("dragon")) {
            dragonScore = 1;
        }
        int monsterIni = monsters.getInitiative();
        int playerIni = classes.initiative();
        System.out.println("");
        System.out.println("Your initiative is " + playerIni);
        System.out.println("The monster's initiative is " + monsterIni);
        if (playerIni >= monsterIni) {
            monsterTurn = false;
            yourTurn = true;
            battle = true;
        } else if (playerIni < monsterIni) {
            yourTurn = false;
            monsterTurn = true;
            battle = true;
        }
        while (battle) {
            reload = 9;
            while (yourTurn) {
                System.out.println("Choose an abiliti: ");
                System.out.println("Strike, Magic, " + classes.classAbiliti() + ", Items or Flee: ");
                String abiliti = scanner.next();
                switch (abiliti) {
                    case "strike":
                        strikeTrue = true;
                        damage = classes.psychicalDamage() + transformPsychicalDmg;
                        int secondDamage = classes.psychicalDamage() / 2;
                        chance10 = rand.nextInt(10) + 1;
                        if (classes.critChance() >= chance10) {
                            damage = damage * 2;
                            System.out.println("Critical hit!");
                            System.out.println("");
                        }
                        if (classes.isRogue()) {
                            System.out.println("You dealt " + damage + " psychical damage to the enemy");
                            System.out.println("You dealt " + secondDamage + " psychical damage to the enemy");
                            if (monsters.getMaxHealth() - Math.abs(monsters.getPsychicalDefense() - damage - secondDamage) <= 0) {
                                monsterDeath();
                            } else {
                                monsters.setMaxHealth(monsters.getMaxHealth() - Math.abs(monsters.getPsychicalDefense() - damage - secondDamage));
                                System.out.println("The " + monsters.getName() + " has " + monsters.getMaxHealth() +
                                        " health");
                                yourTurn = false;
                                monsterTurn = true;
                            }
                        } else if (classes.isBerserker()) {
                            int missingHealth = classes.maxHealth() - classes.getHealth();
                            damage = damage + missingHealth;
                            System.out.println("You dealt " + damage + " psychical damage to the enemy");
                            if (monsters.getMaxHealth() - Math.abs(monsters.getPsychicalDefense() - damage) <= 0) {
                                monsterDeath();
                            } else {
                                monsters.setMaxHealth(monsters.getMaxHealth() - Math.abs(monsters.getPsychicalDefense() - damage));
                                System.out.println("The " + monsters.getName() + " has " + monsters.getMaxHealth() +
                                        " health");
                                yourTurn = false;
                                monsterTurn = true;
                            }
                        } else {
                            System.out.println("You have dealt " + damage + " psychical damage to the enemy");
                            if (bloodTrue) {
                                System.out.println("You have restored " + damage + " health to yourself");
                                if (classes.getHealth() + damage >= classes.maxHealth()) {
                                    classes.setHealth(classes.maxHealth());
                                    bloodTrue = false;
                                } else if (classes.getHealth() + damage < classes.maxHealth()) {
                                    classes.setHealth(classes.getHealth() + damage);
                                    bloodTrue = false;
                                }
                            }
                            if (monsters.getMaxHealth() - Math.abs(monsters.getPsychicalDefense() - damage) <= 0) {
                                monsterDeath();
                            } else {
                                monsters.setMaxHealth(monsters.getMaxHealth() - Math.abs(monsters.getPsychicalDefense() - damage));
                                System.out.println("The " + monsters.getName() + " has " + monsters.getMaxHealth() +
                                        " health");
                                yourTurn = false;
                                monsterTurn = true;
                            }
                        }
                        break;
                    case "magic":
                        magicTrue = true;
                        damage = classes.magicalDamage() + transformMagicalDmg;
                        if (classes.getMana() >= 4) {
                            System.out.println("You have dealt " + damage + " magical damage to the enemy");
                            if (classes.isWarlock()) {
                                System.out.println("You have restored " + damage / 3 + " health to yourself");
                                if (damage / 3 + classes.getHealth() >= classes.maxHealth()) {
                                    classes.setHealth(classes.maxHealth());
                                } else if (damage / 3 + classes.getHealth() < classes.maxHealth()) {
                                    classes.setHealth(classes.getHealth() + damage / 3);
                                }
                            }
                            if (monsters.getMaxHealth() - Math.abs(monsters.getMagicalDefense() - damage) <= 0) {
                                classes.setMana(classes.getMana() - 4);
                                monsterDeath();
                            } else {
                                monsters.setMaxHealth(monsters.getMaxHealth() - Math.abs(monsters.getMagicalDefense() - damage));
                                System.out.println("The " + monsters.getName() + " has " + monsters.getMaxHealth() +
                                        " health");
                                classes.setMana(classes.getMana() - 4);
                                yourTurn = false;
                                monsterTurn = true;
                            }
                        } else {
                            System.out.println("You don't have enough mana.");
                        }
                        break;
                    case "bloodbath":
                        if (classes.isWarrior()) {
                            System.out.println("You have activated Bloodbath.");
                            bloodTrue = true;
                            yourTurn = false;
                            monsterTurn = true;
                        } else {
                            System.out.println("You cant use this command!");
                        }
                        break;
                    case "stealth":
                        if (classes.isRogue() && abilitiScore == 1) {
                            damage = classes.psychicalDamage() * 2;
                            System.out.println("You are in stealth mode.");
                            System.out.println("You can use backstab or flee.");
                            String stealthAttack = scanner.next();
                            if (stealthAttack.equalsIgnoreCase("backstab")) {
                                chance10 = rand.nextInt(10) + 1;
                                if (classes.critChance() >= chance10) {
                                    damage = damage * 2;
                                    System.out.println("Critical hit!");
                                    System.out.println("");
                                }
                                System.out.println("You have dealt " + damage + " pure damage to the enemy");
                                if ((monsters.getMaxHealth() - damage) <= 0) {
                                    monsterDeath();
                                } else {
                                    monsters.setMaxHealth(monsters.getMaxHealth() - damage);
                                    System.out.println("The " + monsters.getName() + " has " + monsters.getMaxHealth() +
                                            " health");
                                    yourTurn = false;
                                    monsterTurn = true;
                                    abilitiScore = 0;
                                }
                            } else if (stealthAttack.equalsIgnoreCase("flee")) {
                                System.out.println("You have ran away!");
                                dragonScore = 0;
                                battle = false;
                                yourTurn = false;
                                monsterTurn = false;
                            } else {
                                yourTurn = false;
                                monsterTurn = true;
                            }
                        } else {
                            System.out.println("You cant use this command!");
                        }
                        break;
                    case "fireball":
                        if (classes.isMage()) {
                            damage = classes.magicalDamage() + classes.magicalDamage() / 2;
                            if (classes.getMana() >= 10) {
                                System.out.println("You dealt " + damage + " magical damage to the enemy");
                                if (monsters.getMaxHealth() - Math.abs(monsters.getMagicalDefense() - damage) <= 0) {
                                    classes.setMana(classes.getMana() - 10);
                                    monsterDeath();
                                } else {
                                    monsters.setMaxHealth(monsters.getMaxHealth() - Math.abs(monsters.getMagicalDefense() - damage));
                                    System.out.println("The " + monsters.getName() + " has " + monsters.getMaxHealth() +
                                            " health");
                                    classes.setMana(classes.getMana() - 10);
                                    yourTurn = false;
                                    monsterTurn = true;
                                }
                            } else {
                                System.out.println("You don't have enough mana.");
                            }
                        } else {
                            System.out.println("You cant use this command!");
                        }
                        break;
                    case "heal":
                        int trueHeal = rand.nextInt(8) + 1 + classes.heal();
                        if (classes.isPriest()) {
                            if (classes.getMana() >= 6) {
                                if (trueHeal + classes.getHealth() >= classes.maxHealth()) {
                                    classes.setHealth(classes.maxHealth());
                                } else if (trueHeal + classes.getHealth() < classes.maxHealth()) {
                                    classes.setHealth(classes.getHealth() + trueHeal);
                                }
                                classes.setMana(classes.getMana() - 6);
                                System.out.println("You restored " + trueHeal + " health.");
                                System.out.println("");
                                System.out.println("You have " + classes.getHealth() + "/" + classes.maxHealth() + " health.");
                                System.out.println("You have " + classes.getMana() + "/" + classes.maxMana() + " mana.");
                            } else {
                                System.out.println("You don't have enough mana.");
                            }
                        } else {
                            System.out.println("You cant use this command!");
                        }
                        break;
                    case "iaido":
                        if (classes.isSamurai()) {
                            if (iaidoTrue) {
                                iaidoTrue = false;
                                damage = classes.psychicalDamage() * 3;
                                chance10 = rand.nextInt(10) + 1;
                                if (classes.critChance() >= chance10) {
                                    damage = damage * 2;
                                    System.out.println("Critical hit!");
                                    System.out.println("");
                                }
                                System.out.println("You have dealt " + damage + " psychical damage to the enemy");
                                if (monsters.getMaxHealth() - Math.abs(monsters.getPsychicalDefense() - damage) <= 0) {
                                    monsterDeath();
                                } else {
                                    monsters.setMaxHealth(monsters.getMaxHealth() - Math.abs(monsters.getPsychicalDefense() - damage));
                                    System.out.println("The " + monsters.getName() + " has " + monsters.getMaxHealth() +
                                            " health");
                                    yourTurn = false;
                                    monsterTurn = true;
                                }
                            } else {
                                System.out.println("You sheathe your sword, ready to unleash your attack at the next turn");
                                System.out.println("");
                                iaidoTrue = true;
                                yourTurn = false;
                                monsterTurn = true;
                            }
                        } else
                            System.out.println("You cant use this command!");

                        break;
                    case "rampage":
                        if (classes.isBerserker() && rampageTrue) {
                            classes.setHealth(classes.getHealth() / 2);
                            System.out.println("You have used rampage");
                            System.out.println("You have " + classes.getHealth() + "/" + classes.maxHealth() + " health.");
                            System.out.println();
                            rampageTrue = false;
                        } else {
                            System.out.println("You cant use this command!");
                        }
                        break;
                    case "shadowbolt":
                        if (classes.isWarlock()) {
                            damage = classes.magicalDamage() + classes.magicalDamage() / 2;
                            if (classes.getHealth() > 8) {
                                System.out.println("You have sacrificed 8 health points");
                                System.out.println("You have dealt " + damage + " magical damage to the enemy");
                                if (monsters.getMaxHealth() - Math.abs(monsters.getMagicalDefense() - damage) <= 0) {
                                    classes.setHealth(classes.getHealth() - 8);
                                    monsterDeath();
                                } else {
                                    monsters.setMaxHealth(monsters.getMaxHealth() - Math.abs(monsters.getMagicalDefense() - damage));
                                    System.out.println("The " + monsters.getName() + " has " + monsters.getMaxHealth() +
                                            " health");
                                    classes.setHealth(classes.getHealth() - 8);
                                    yourTurn = false;
                                    monsterTurn = true;
                                }
                            } else {
                                System.out.println("You don't have enough health.");
                            }
                        } else {
                            System.out.println("You cant use this command!");
                        }
                        break;
                    case "reflect":
                        if (classes.isPaladin()) {
                            if (classes.getMana() >= 6) {
                                blockTrue = false;
                                reflectTrue = true;
                                yourTurn = false;
                                monsterTurn = true;
                                System.out.println("You have activated Reflect.");
                                classes.setMana(classes.getMana() - 6);
                            } else {
                                System.out.println("You don't have enough mana.");
                            }
                        } else {
                            System.out.println("You cant use this command!");
                        }
                        break;
                    case "barrage":
                        if (classes.isGunslinger()) {
                            if (strikeTrue) {
                                damage = classes.psychicalDamage();
                                chance10 = rand.nextInt(10) + 1;
                                if (classes.critChance() >= chance10) {
                                    damage = damage * 2;
                                    System.out.println("Critical hit!");
                                    System.out.println("");
                                }
                                System.out.println("You have dealt " + damage + " psychical damage to the enemy");
                                if (monsters.getMaxHealth() - Math.abs(monsters.getPsychicalDefense() - damage) <= 0) {
                                    monsterDeath();
                                } else {
                                    monsters.setMaxHealth(monsters.getMaxHealth() - Math.abs(monsters.getPsychicalDefense() - damage));
                                    System.out.println("The " + monsters.getName() + " has " + monsters.getMaxHealth() +
                                            " health");
                                    chance10 = rand.nextInt(10) + 1;
                                    if (reload >= chance10) {
                                        System.out.println("You can shoot again!");
                                        yourTurn = true;
                                        monsterTurn = false;
                                        reload = reload - 1;
                                    } else if (reload < chance10) {
                                        System.out.println("You have to reload your gun.");
                                        yourTurn = false;
                                        monsterTurn = true;
                                    }
                                }
                            } else if (magicTrue) {
                                damage = classes.magicalDamage();
                                System.out.println("You have dealt " + damage + " magic damage to the enemy");
                                if (monsters.getMaxHealth() - Math.abs(monsters.getMagicalDefense() - damage) <= 0) {
                                    monsterDeath();
                                } else {
                                    monsters.setMaxHealth(monsters.getMaxHealth() - Math.abs(monsters.getMagicalDefense() - damage));
                                    System.out.println("The " + monsters.getName() + " has " + monsters.getMaxHealth() +
                                            " health");
                                    chance10 = rand.nextInt(10) + 1;
                                    if (reload >= chance10) {
                                        System.out.println("You can shoot again!");
                                        yourTurn = true;
                                        monsterTurn = false;
                                        reload = reload - 1;
                                    } else if (reload < chance10) {
                                        System.out.println("You have to reload your gun.");
                                        yourTurn = false;
                                        monsterTurn = true;
                                    }
                                }
                            } else {
                                System.out.println("You have to use strike or magic first!");
                            }
                        } else {
                            System.out.println("You cant use this command!");
                        }
                        break;
                    case "roll":
                        if (classes.isGambler()) {
                            int dieRoll = rand.nextInt(6) + 1;
                            if (dieRoll == 1) {
                                System.out.println("Bad luck!");
                                System.out.println("Auto flee");
                                flee();
                            } else if (dieRoll == 2) {
                                System.out.println("Bad luck!");
                                System.out.println("Your health is halved.");
                                classes.setHealth(classes.getHealth() / 2);
                                System.out.println("");
                                System.out.println("You have " + classes.getHealth() + "/" + classes.maxHealth() + " health.");
                                System.out.println("You have " + classes.getMana() + "/" + classes.maxMana() + " mana.");
                                yourTurn = false;
                                monsterTurn = true;
                            } else if (dieRoll == 3) {
                                System.out.println("Bad luck!");
                                System.out.println("Nothing happened.");
                                yourTurn = false;
                                monsterTurn = true;
                            } else if (dieRoll == 4) {
                                System.out.println("Good luck!");
                                damage = classes.psychicalDamage() * 2;
                                chance10 = rand.nextInt(10) + 1;
                                if (classes.critChance() <= chance10) {
                                    System.out.println("Critical hit!");
                                    damage = damage * 2;
                                }
                                System.out.println("You have dealt " + damage + " psychical damage to the enemy");
                                if (monsters.getMaxHealth() - Math.abs(monsters.getPsychicalDefense() - damage) <= 0) {
                                    monsterDeath();
                                } else {
                                    monsters.setMaxHealth(monsters.getMaxHealth() - Math.abs(monsters.getPsychicalDefense() - damage));
                                    System.out.println("The " + monsters.getName() + " has " + monsters.getMaxHealth() +
                                            " health");
                                    yourTurn = false;
                                    monsterTurn = true;
                                }
                            } else if (dieRoll == 5) {
                                damage = classes.magicalDamage() * 3;
                                System.out.println("Good luck!");
                                System.out.println("You have dealt " + damage + " magical damage to the enemy");
                                if (monsters.getMaxHealth() - Math.abs(monsters.getMagicalDefense() - damage) <= 0) {
                                    monsterDeath();
                                } else {
                                    monsters.setMaxHealth(monsters.getMaxHealth() - Math.abs(monsters.getMagicalDefense() - damage));
                                    System.out.println("The " + monsters.getName() + " has " + monsters.getMaxHealth() +
                                            " health");
                                    yourTurn = false;
                                    monsterTurn = true;
                                }
                            } else if (dieRoll == 6) {
                                damage = 45;
                                System.out.println("Good luck!");
                                System.out.println("You have dealt " + damage + " pure damage to the enemy");
                                if ((monsters.getMaxHealth() - damage) <= 0) {
                                    monsterDeath();
                                } else {
                                    monsters.setMaxHealth(monsters.getMaxHealth() - damage);
                                    System.out.println("The " + monsters.getName() + " has " + monsters.getMaxHealth() +
                                            " health");
                                    yourTurn = false;
                                    monsterTurn = true;
                                }
                            }
                        } else {
                            System.out.println("You cant use this command!");
                        }
                        break;
                    case "claws":
                        damage = undeadSmall * 2 + undeadNormal * 8 + undeadBig * 26 + gigantos * 55;
                        if (classes.isNecromancer()) {
                            if (undeadSmall > 0 || undeadNormal > 0 || undeadBig > 0 || gigantos > 0) {
                                if (undeadSmall == 1) {
                                    System.out.println("Your small undead deals 2 psychical damage");
                                } else if (undeadSmall > 0) {
                                    System.out.println("Your small undeads deals " + 2 * undeadSmall + " psychical damage");
                                }
                                if (undeadNormal == 1) {
                                    System.out.println("Your normal undead deals 8 psychical damage");
                                } else if (undeadNormal > 0) {
                                    System.out.println("Your normal undeads deals " + 8 * undeadNormal + " psychical damage");
                                }
                                if (undeadBig == 1) {
                                    System.out.println("Your big undead deals 26 psychical damage");
                                } else if (undeadBig > 0) {
                                    System.out.println("Your big undeads deals " + 26 * undeadBig + " psychical damage");
                                }
                                if (gigantos == 1) {
                                    System.out.println("Your Gigantos, the destroyer deals 55 psychical damage");
                                } else if (gigantos > 0) {
                                    System.out.println("Your Gigantos, the destroyer deals " + 55 * gigantos + " psychical damage");
                                }
                            } else {
                                System.out.println("You have no undead minions.");
                                yourTurn = true;
                                monsterTurn = false;
                            }
                            if (monsters.getMaxHealth() - Math.abs(monsters.getPsychicalDefense() - damage) <= 0) {
                                monsterDeath();
                            } else {
                                monsters.setMaxHealth(monsters.getMaxHealth() - Math.abs(monsters.getPsychicalDefense() - damage));
                                System.out.println("The " + monsters.getName() + " has " + monsters.getMaxHealth() +
                                        " health");
                                yourTurn = false;
                                monsterTurn = true;
                            }
                        }
                        break;
                    case "transform":
                        transform();
                        break;
                    case "flee":
                        flee();
                        break;
                    case "items":
                        items();
                        break;
                }
            }
            while (monsterTurn) {
                rampageTrue = true;
                int monsterPsychicalDmg = rand.nextInt(monsters.dmg()) + monsters.getPsychicalDamage();
                int monsterMagicalDmg = rand.nextInt(monsters.dmg()) + monsters.getMagicalDamage();
                if (monsters.getPsychicalDamage() > monsters.getMagicalDamage()) {
                    if (blockTrue && classes.isPaladin()) {
                        chance10 = rand.nextInt(10) + 1;
                        if (chance10 <= 3) {
                            System.out.println("The " + monsters.getName() + " deals " + monsterPsychicalDmg +
                                    " psychical damage.");
                            System.out.println("You successfully blocked the attack");
                            playerSurvived();
                        }
                    } else {
                        if (reflectTrue) {
                            System.out.println("The " + monsters.getName() + " deals " + monsterPsychicalDmg +
                                    " psychical damage.");
                            System.out.println("You have reflected back the damage to the monster");
                            System.out.println("The " + monsters.getName() + " gets " + monsterPsychicalDmg +
                                    " psychical damage.");
                            if (monsters.getMaxHealth() - monsterPsychicalDmg <= 0) {
                                reflectTrue = false;
                                monsterDeath();
                            } else {
                                monsters.setMaxHealth(monsters.getMaxHealth() - monsterPsychicalDmg);
                                System.out.println("The " + monsters.getName() + " has " + monsters.getMaxHealth() +
                                        " health");
                                reflectTrue = false;
                                yourTurn = true;
                                monsterTurn = false;
                            }
                        } else {
                            System.out.println("The " + monsters.getName() + " deals " + monsterPsychicalDmg +
                                    " psychical damage.");
                            if (classes.getHealth() + transformPsychicalDef - Math.abs(classes.psychicalDefense() - monsterPsychicalDmg) <= 0) {
                                playerDeath();
                            } else if ((classes.getHealth() + transformPsychicalDef - Math.abs(classes.psychicalDefense() - monsterPsychicalDmg)) > 0
                                    && (classes.getHealth() + transformPsychicalDef - Math.abs(classes.psychicalDefense() - monsterPsychicalDmg) <= classes.getHealth())) {
                                classes.setHealth(classes.getHealth() + transformPsychicalDef - Math.abs(classes.psychicalDefense() - monsterPsychicalDmg));
                                playerSurvived();
                            } else {
                                playerSurvived();
                            }
                        }
                    }
                } else if (monsters.getPsychicalDamage() < monsters.getMagicalDamage()) {
                    if (reflectTrue == true) {
                        System.out.println("The " + monsters.getName() + " deals " + monsterMagicalDmg +
                                " magical damage.");
                        System.out.println("You have reflected back the damage to the monster");
                        System.out.println("The " + monsters.getName() + " gets " + monsterMagicalDmg +
                                " magical damage.");
                        if (monsters.getMaxHealth() - monsterMagicalDmg <= 0) {
                            reflectTrue = false;
                            monsterDeath();
                        } else {
                            monsters.setMaxHealth(monsters.getMaxHealth() - monsterMagicalDmg);
                            System.out.println("The " + monsters.getName() + " has " + monsters.getMaxHealth() +
                                    " health");
                            reflectTrue = false;
                            yourTurn = true;
                            monsterTurn = false;
                        }
                    } else {
                        System.out.println("The " + monsters.getName() + " deals " + monsterMagicalDmg +
                                " magical damage.");
                        if (classes.getHealth() + transformMagicalDef - Math.abs(classes.magicalDefense() - monsterMagicalDmg) <= 0) {
                            playerDeath();
                        } else if ((classes.getHealth() + transformMagicalDef - Math.abs(classes.magicalDefense() - monsterMagicalDmg)) > 0
                                && (classes.getHealth() + transformMagicalDef - Math.abs(classes.magicalDefense() - monsterMagicalDmg) <= classes.getHealth())) {
                            classes.setHealth(classes.getHealth() + transformMagicalDef - Math.abs(classes.magicalDefense() - monsterMagicalDmg));
                            playerSurvived();
                        } else {
                            playerSurvived();
                        }

                    }
                } else if (monsters.getPsychicalDamage() == monsters.getMagicalDamage()) {
                    if (reflectTrue == true) {
                        System.out.println("The " + monsters.getName() + " deals " + monsterMagicalDmg +
                                " pure damage.");
                        System.out.println("You have reflected back the damage to the monster");
                        System.out.println("The " + monsters.getName() + " gets " + monsterMagicalDmg +
                                " pure damage.");
                        if (monsters.getMaxHealth() - monsterMagicalDmg <= 0) {
                            reflectTrue = false;
                            monsterDeath();
                        } else {
                            monsters.setMaxHealth(monsters.getMaxHealth() - monsterMagicalDmg);
                            System.out.println("The " + monsters.getName() + " has " + monsters.getMaxHealth() +
                                    " health");
                            reflectTrue = false;
                            yourTurn = true;
                            monsterTurn = false;
                        }
                    } else {
                        System.out.println("The " + monsters.getName() + " deals " + monsterMagicalDmg +
                                " pure damage.");
                        if (classes.getHealth() - monsterMagicalDmg <= 0) {
                            playerDeath();
                        } else if (classes.getHealth() - monsterMagicalDmg > 0) {
                            classes.setHealth(classes.getHealth() - monsterMagicalDmg);
                            playerSurvived();
                        }
                    }
                }
            }
        }
    }
}




