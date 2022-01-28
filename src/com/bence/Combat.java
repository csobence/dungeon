package com.bence;

import java.util.Random;
import java.util.Scanner;

public class Combat {
    Game game;
    Classes classes;
    Monsters monsters;
    Scanner scanner;
    Arts arts;
    Items items;
    Random rand = new Random();
    boolean should = false;
    boolean battle = false;
    boolean abilityAction = false;
    boolean magicBullet = false;
    boolean psychicalBullet = false;
    boolean ratForm = false;
    boolean slimeForm = false;
    boolean goblinForm = false;
    boolean zombieForm = false;
    boolean skeletonForm = false;
    boolean wyvernForm = false;
    boolean ogreForm = false;
    boolean trollForm = false;

    int turn;
    int chance10;
    int damage;
    int reload = 9;
    int abilityScore = 0;
    int dragonScore = 0;

    int undeadSmall = 0;
    int undeadNormal = 0;
    int undeadBig = 0;
    int gigantos = 0;

    int transformPsychicalDmg = 0;
    int transformMagicalDmg = 0;
    int transformPsychicalDef = 0;
    int transformMagicalDef = 0;

    public Combat(Game game, Classes classes, Arts arts, Items items, Monsters monsters, Scanner scanner) {
        this.game = game;
        this.classes = classes;
        this.arts = arts;
        this.items = items;
        this.monsters = monsters;
        this.scanner = scanner;

    }

    public void combat() throws InterruptedException {
        System.out.println("Enemy encounter: ");
        int chance;
        if (classes.getLevelUpScore() == 1) {
            chance = rand.nextInt(2);
        } else if (classes.getLevelUpScore() == 2) {
            chance = rand.nextInt(4);
        } else if (classes.getLevelUpScore() == 3) {
            chance = rand.nextInt(6);
        } else if (classes.getLevelUpScore() >= 4 && classes.getLevelUpScore() < 6) {
            chance = rand.nextInt(8);
        } else if (classes.getLevelUpScore() >= 6 && classes.getLevelUpScore() < 8) {
            chance = rand.nextInt(9);
        } else {
            chance = 8;
        }
        monsters.monsterDraw(chance);
        abilityScore = 1;
        game.monsterArt(chance);
        monsters.increaseStats();
        System.out.println("You have encountered a " + monsters.getName() + ", health: " + monsters.getMaxHealth() + "\n");
        if (monsters.getName().equalsIgnoreCase("dragon")) {
            dragonScore = 1;
        }
        int monsterIni = monsters.getInitiative();
        int playerIni = classes.initiative();
        System.out.println("Your initiative is " + playerIni);
        System.out.println("The monster's initiative is " + monsterIni);
        if (playerIni >= monsterIni) {
            turn = 1;
        } else {
            turn = 2;
        }
        battle = true;
        while (battle) {
            reload = 9;
            while (turn == 1) {
                System.out.println("Choose an ability: ");
                System.out.println("Strike, Magic, " + classes.classAbility() + ", Items or Flee: ");
                String ability = scanner.next();
                switch (ability) {
                    case "strike":
                        psychicalBullet = true;
                        damage = (classes.psychicalDamage() + transformPsychicalDmg) - monsters.getPsychicalDefense();
                        int secondDamage = (classes.psychicalDamage() / 2) - monsters.getPsychicalDefense();
                        chance10 = rand.nextInt(10) + 1;
                        if (classes.critChance() >= chance10) {
                            damage = (damage + classes.critDMG()) * 2;
                            System.out.println("Critical hit!\n");
                        }
                        if (classes.role.equals(Role.ROGUE)) {
                            if (damage <= 0) {
                                System.out.println("The " + monsters.getName() + " successfully blocked your first attack.");
                            } else {
                                System.out.println("You dealt " + damage + " psychical damage to the enemy");
                            }
                            if (secondDamage <= 0) {
                                System.out.println("The " + monsters.getName() + " successfully blocked your second attack.");
                            } else {
                                System.out.println("You dealt " + secondDamage + " psychical damage to the enemy");
                            }
                                if ((monsters.getMaxHealth() - damage - secondDamage) <= 0) {
                                    monsterDeath();
                                } else {
                                    monsters.setMaxHealth(monsters.getMaxHealth() - (monsters.getMaxHealth() - damage - secondDamage));
                                    System.out.println("The " + monsters.getName() + " has " + monsters.getMaxHealth() +
                                            " health");
                                    turn = 2;
                            }
                        } else if (classes.role.equals(Role.BERSERKER)) {
                            int missingHealth = classes.maxHealth() - classes.getHealth();
                            damage = damage + missingHealth;
                            if (damage <= 0) {
                                System.out.println("The " + monsters.getName() + " successfully blocked your attack.");
                                turn = 2;
                            } else {
                                System.out.println("You dealt " + damage + " psychical damage to the enemy");
                                monsterTakeDamage();
                            }
                        } else {
                            if (damage <= 0) {
                                System.out.println("The " + monsters.getName() + " successfully blocked your attack.");
                                turn = 2;
                            } else {
                                System.out.println("You have dealt " + damage + " psychical damage to the enemy.");
                                monsterTakeDamage();
                                if (classes.role.equals(Role.WARRIOR) && abilityAction) {
                                    System.out.println("You have restored " + damage + " health to yourself.");
                                    if (classes.getHealth() + damage >= classes.maxHealth()) {
                                        classes.setHealth(classes.maxHealth());
                                        abilityAction = false;
                                    } else if (classes.getHealth() + damage < classes.maxHealth()) {
                                        classes.setHealth(classes.getHealth() + damage);
                                        abilityAction = false;
                                    }
                                }
                            }
                        }
                        break;
                    case "magic":
                        magicBullet = true;
                        damage = (classes.magicalDamage() + transformMagicalDmg) - monsters.getMagicalDefense();
                        if (classes.getMana() >= 4) {
                            classes.setMana(classes.getMana() - 4);
                            if (damage <= 0) {
                                System.out.println("The " + monsters.getName() + " successfully absorbed your attack.");
                                turn = 2;
                            } else {
                                System.out.println("You have dealt " + damage + " magical damage to the enemy");
                                if (classes.role.equals(Role.WARLOCK)) {
                                    System.out.println("You have restored " + damage / 3 + " health to yourself");
                                    if (damage / 3 + classes.getHealth() >= classes.maxHealth()) {
                                        classes.setHealth(classes.maxHealth());
                                    } else if (damage / 3 + classes.getHealth() < classes.maxHealth()) {
                                        classes.setHealth(classes.getHealth() + damage / 3);
                                    }
                                }
                                monsterTakeDamage();
                            }
                            } else {
                                System.out.println("You don't have enough mana.");
                            }

                        break;
                    case "bloodbath":
                        if (classes.role.equals(Role.WARRIOR)) {
                            System.out.println("You have activated Bloodbath.");
                            abilityAction = true;
                            turn = 2;
                        } else {
                            System.out.println("You cant use this command!");
                        }
                        break;
                    case "stealth":
                        if (classes.role.equals(Role.ROGUE) && abilityScore == 1) {
                            damage = classes.psychicalDamage() * 2;
                            System.out.println("You are in stealth mode.");
                            System.out.println("You can use backstab or flee.");
                            String stealthAttack = scanner.next();
                            if (stealthAttack.equalsIgnoreCase("backstab")) {
                                chance10 = rand.nextInt(10) + 1;
                                if (classes.critChance() >= chance10) {
                                    damage = (damage + classes.critDMG()) * 2;
                                    System.out.println("Critical hit!\n");
                                }
                                System.out.println("You have dealt " + damage + " pure damage to the enemy");
                                monsterTakeDamage();
                                abilityScore = 0;
                            } else if (stealthAttack.equalsIgnoreCase("flee")) {
                                System.out.println("You have ran away!");
                                dragonScore = 0;
                                battle = false;
                                turn = 2;
                            } else {
                                turn = 2;
                            }
                        } else {
                            System.out.println("You cant use this command!");
                        }
                        break;
                    case "fireball":
                        if (classes.role.equals(Role.MAGE)) {
                            damage = (classes.magicalDamage() + classes.magicalDamage() / 2) - monsters.getMagicalDefense();
                            if (classes.getMana() >= 10) {
                                classes.setMana(classes.getMana() - 10);
                                if (damage <= 0) {
                                    System.out.println("The " + monsters.getName() + " successfully absorbed your attack.");
                                    turn = 2;
                                } else {
                                    System.out.println("You dealt " + damage + " magical damage to the enemy");
                                    monsterTakeDamage();
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
                        if (classes.role.equals(Role.PRIEST)) {
                            if (classes.getMana() >= 6) {
                                classes.setMana(classes.getMana() - 6);
                                if (trueHeal + classes.getHealth() >= classes.maxHealth()) {
                                    classes.setHealth(classes.maxHealth());
                                } else if (trueHeal + classes.getHealth() < classes.maxHealth()) {
                                    classes.setHealth(classes.getHealth() + trueHeal);
                                }
                                System.out.println("You restored " + trueHeal + " health.\n");
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
                        if (classes.role.equals(Role.SAMURAI)) {
                            if (abilityAction) {
                                abilityAction = false;
                                damage = (classes.psychicalDamage() * 3) - monsters.getPsychicalDefense();
                                chance10 = rand.nextInt(10) + 1;
                                if (classes.critChance() >= chance10) {
                                    damage = (damage + classes.critDMG()) * 2;
                                    System.out.println("Critical hit!\n");
                                }
                                if (damage <= 0) {
                                    System.out.println("The " + monsters.getName() + " successfully blocked your attack.");
                                    turn = 2;
                                } else {
                                    System.out.println("You have dealt " + damage + " psychical damage to the enemy");
                                    monsterTakeDamage();
                                }
                            } else {
                                System.out.println("You sheathe your sword, ready to unleash your attack at the next turn\n");
                                abilityAction = true;
                                turn = 2;
                            }
                        } else
                            System.out.println("You cant use this command!");

                        break;
                    case "rampage":
                        if (classes.role.equals(Role.BERSERKER) && abilityScore == 1) {
                            classes.setHealth(classes.getHealth() / 2);
                            System.out.println("You have used rampage");
                            System.out.println("You have " + classes.getHealth() + "/" + classes.maxHealth() + " health.");
                            System.out.println();
                            abilityScore = 0;
                        } else {
                            System.out.println("You cant use this command!");
                        }
                        break;
                    case "shadowbolt":
                        if (classes.role.equals(Role.WARLOCK)) {
                            damage = (classes.magicalDamage() + classes.magicalDamage() / 2) - monsters.getMagicalDefense();
                            if (classes.getHealth() > 8) {
                                classes.setHealth(classes.getHealth() - 8);
                                if (damage <= 0) {
                                    System.out.println("The " + monsters.getName() + " successfully absorbed your attack.");
                                    turn = 2;
                                } else {
                                    System.out.println("You have sacrificed 8 health points");
                                    System.out.println("You have dealt " + damage + " magical damage to the enemy");
                                    monsterTakeDamage();
                                }
                            } else {
                                System.out.println("You don't have enough health.");
                            }
                        } else {
                            System.out.println("You cant use this command!");
                        }
                        break;
                    case "reflect":
                        if (classes.role.equals(Role.PALADIN)) {
                            if (classes.getMana() >= 6) {
                                abilityAction = true;
                                turn = 2;
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
                        if (classes.role.equals(Role.GUNSLINGER)) {
                            if (psychicalBullet) {
                                damage = classes.psychicalDamage() - monsters.getPsychicalDefense();
                                chance10 = rand.nextInt(10) + 1;
                                if (classes.critChance() >= chance10) {
                                    damage = (damage + classes.critDMG()) * 2;
                                    System.out.println("Critical hit!\n");
                                }
                                if (damage <= 0) {
                                    System.out.println("The " + monsters.getName() + " successfully blocked your attack.");
                                    turn = 2;
                                } else {
                                System.out.println("You have dealt " + damage + " psychical damage to the enemy");
                                    monsterTakeDamage();
                                if (turn != 0) {
                                    chance10 = rand.nextInt(10) + 1;
                                    if (reload >= chance10) {
                                        System.out.println("You can shoot again!");
                                        turn = 1;
                                        reload--;
                                    } else {
                                        System.out.println("You have to reload your gun.");
                                        turn = 2;
                                    }
                                }
                                }
                            } else if (magicBullet) {
                                damage = classes.magicalDamage() - monsters.getMagicalDefense();
                                if (damage <= 0) {
                                    System.out.println("The " + monsters.getName() + " successfully absorbed your attack.");
                                    turn = 2;
                                } else {
                                    System.out.println("You have dealt " + damage + " magic damage to the enemy");
                                    monsterTakeDamage();
                                    if (turn != 0) {
                                        chance10 = rand.nextInt(10) + 1;
                                        if (reload >= chance10) {
                                            System.out.println("You can shoot again!");
                                            turn = 1;
                                            reload--;
                                        } else {
                                            System.out.println("You have to reload your gun.");
                                            turn = 2;
                                        }
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
                        if (classes.role.equals(Role.GAMBLER)) {
                            int dieRoll = rand.nextInt(6) + 1;
                            if (dieRoll == 1) {
                                System.out.println("Bad luck!");
                                System.out.println("Auto flee");
                                flee();
                            } else if (dieRoll == 2) {
                                System.out.println("Bad luck!");
                                System.out.println("Your health is halved.\n");
                                classes.setHealth(classes.getHealth() / 2);
                                System.out.println("You have " + classes.getHealth() + "/" + classes.maxHealth() + " health.");
                                System.out.println("You have " + classes.getMana() + "/" + classes.maxMana() + " mana.");
                                turn = 2;
                            } else if (dieRoll == 3) {
                                System.out.println("Bad luck!");
                                System.out.println("Nothing happened.");
                                turn = 2;
                            } else if (dieRoll == 4) {
                                System.out.println("Good luck!");
                                damage = (classes.psychicalDamage() * 2) - monsters.getPsychicalDefense();
                                chance10 = rand.nextInt(10) + 1;
                                if (classes.critChance() <= chance10) {
                                    System.out.println("Critical hit!");
                                    damage = (damage + classes.critDMG()) * 2;
                                }
                                if (damage <= 0) {
                                    System.out.println("The " + monsters.getName() + " successfully blocked your attack.");
                                    turn = 2;
                                } else {
                                    System.out.println("You have dealt " + damage + " psychical damage to the enemy");
                                    monsterTakeDamage();
                                }
                            } else if (dieRoll == 5) {
                                damage = classes.magicalDamage() * 3 - monsters.getMagicalDefense();
                                System.out.println("Good luck!");
                                if (damage <= 0) {
                                    System.out.println("The " + monsters.getName() + " successfully absorbed your attack.");
                                    turn = 2;
                                } else {
                                    System.out.println("You have dealt " + damage + " magical damage to the enemy");
                                    monsterTakeDamage();
                                }
                            } else {
                                damage = 45;
                                System.out.println("Good luck!");
                                System.out.println("You have dealt " + damage + " pure damage to the enemy");
                                if ((monsters.getMaxHealth() - damage) <= 0) {
                                    monsterDeath();
                                } else {
                                    monsters.setMaxHealth(monsters.getMaxHealth() - damage);
                                    System.out.println("The " + monsters.getName() + " has " + monsters.getMaxHealth() +
                                            " health");
                                    turn = 2;
                                }
                            }
                        } else {
                            System.out.println("You cant use this command!");
                        }
                        break;
                    case "claws":
                        int undeadSmallDamage = 1 + (classes.magicPower())/16;
                        int undeadNormalDamage = 4 + (classes.magicPower())/16;
                        int undeadBigDamage = 13 + (classes.magicPower())/16;
                        int gigantosDamage = 40 + (classes.magicPower())/4;
                        damage = undeadSmall * undeadSmallDamage + undeadNormal * undeadNormalDamage + undeadBig * undeadBigDamage + gigantos * gigantosDamage;
                        if (classes.role.equals(Role.NECROMANCER)) {
                            if (undeadSmall > 0 || undeadNormal > 0 || undeadBig > 0 || gigantos > 0) {
                                if (undeadSmall == 1) {
                                    System.out.println("Your small undead minion deals " + undeadSmallDamage * undeadSmall + " pure damage");
                                } else if (undeadSmall > 0) {
                                    System.out.println("Your small undead minions deals " + undeadSmallDamage * undeadSmall + " pure damage");
                                }
                                if (undeadNormal == 1) {
                                    System.out.println("Your normal undead minion deals " + undeadNormalDamage * undeadNormal + " psychical damage");
                                } else if (undeadNormal > 0) {
                                    System.out.println("Your normal undead minions deals " + undeadNormalDamage * undeadNormal + " pure damage");
                                }
                                if (undeadBig == 1) {
                                    System.out.println("Your big undead minion deals " + undeadBigDamage * undeadBig + " psychical damage");
                                } else if (undeadBig > 0) {
                                    System.out.println("Your big undead minions deals " + undeadBigDamage * undeadBig + " pure damage");
                                }
                                if (gigantos == 1) {
                                    System.out.println("Your Gigantos, the destroyer deals " + gigantosDamage + " psychical damage");
                                }
                            } else {
                                System.out.println("You have no undead minions.");
                                turn = 2;
                            }
                            monsterTakeDamage();
                        }
                        break;
                    case "transform":
                        transform();
                        break;
                    case "flee":
                        flee();
                        break;
                    case "items":
                        if (battle) {
                            items.setBattle(true);
                        }
                        items.items();
                        if (!items.getBattle()) {
                            turn = 0;
                            battle = false;
                            dragonScore = 0;
                        }
                        break;
                }
            }
            while (turn == 2) {
                if (classes.role.equals(Role.BERSERKER)) {
                    abilityScore = 1;
                }
                int monsterPsychicalDmg = ((rand.nextInt(monsters.dmg()) + monsters.getPsychicalDamage()) - (classes.psychicalDefense() + transformPsychicalDef));
                int monsterMagicalDmg = ((rand.nextInt(monsters.dmg()) + monsters.getMagicalDamage()) - (classes.magicalDefense() + transformMagicalDef));
                int monsterPureDmg = (rand.nextInt(monsters.dmg()) + monsters.getMagicalDamage());

                if (monsters.getPsychicalDamage() > monsters.getMagicalDamage()) {
                    chance10 = rand.nextInt(10) + 1;
                    if (classes.role.equals(Role.PALADIN) && !abilityAction && chance10 <= 3) {
                            System.out.println("You successfully blocked the " + monsters.getName() + "'s attack.");
                            turn = 1;
                    } else if (classes.role.equals(Role.PALADIN) && abilityAction) {
                            int reflectPsychical = rand.nextInt(monsters.dmg()) + monsters.getMagicalDamage();
                            System.out.println("The " + monsters.getName() + " deals " + reflectPsychical +
                                    " psychical damage.");
                            System.out.println("You have reflected back the damage to the monster");
                            System.out.println("The " + monsters.getName() + " gets " + reflectPsychical +
                                    " psychical damage.");
                            if (monsters.getMaxHealth() - reflectPsychical <= 0) {
                                abilityAction = false;
                                monsterDeath();
                            } else {
                                monsters.setMaxHealth(monsters.getMaxHealth() - reflectPsychical);
                                System.out.println("The " + monsters.getName() + " has " + monsters.getMaxHealth() +
                                        " health");
                                abilityAction = false;
                                turn = 1;
                            }
                        } else {
                            if (monsterPsychicalDmg < 0) {
                                System.out.println("You successfully blocked the " + monsters.getName() + "'s attack.");
                                playerSurvived();
                            } else {
                                System.out.println("The " + monsters.getName() + " deals " + monsterPsychicalDmg +
                                        " psychical damage.");
                                if ((classes.getHealth() - monsterPsychicalDmg) <= 0) {
                                    playerDeath();
                                } else if ((classes.getHealth() - monsterPsychicalDmg) > 0) {
                                    classes.setHealth(classes.getHealth() - monsterPsychicalDmg);
                                    playerSurvived();
                                } else {
                                    playerSurvived();
                                }
                            }
                        }
                } else if (monsters.getPsychicalDamage() < monsters.getMagicalDamage()) {
                    if (classes.role.equals(Role.PALADIN) && abilityAction) {
                        int reflectMagical = rand.nextInt(monsters.dmg()) + monsters.getMagicalDamage();
                        System.out.println("The " + monsters.getName() + " deals " + reflectMagical +
                                " magical damage.");
                        System.out.println("You have reflected back the damage to the monster");
                        System.out.println("The " + monsters.getName() + " gets " + reflectMagical +
                                " magical damage.");
                        if (monsters.getMaxHealth() - reflectMagical <= 0) {
                            abilityAction = false;
                            monsterDeath();
                        } else {
                            monsters.setMaxHealth(monsters.getMaxHealth() - reflectMagical);
                            System.out.println("The " + monsters.getName() + " has " + monsters.getMaxHealth() +
                                    " health");
                            abilityAction = false;
                            turn = 1;
                        }
                    } else {
                        if (monsterMagicalDmg < 0) {
                            System.out.println("You have fully absorbed the " + monsters.getName() + "'s attack.");
                            playerSurvived();
                        } else {
                            System.out.println("The " + monsters.getName() + " deals " + monsterMagicalDmg +
                                    " magical damage.");
                            if ((classes.getHealth() - monsterMagicalDmg) <= 0) {
                                playerDeath();
                            } else if ((classes.getHealth() - monsterMagicalDmg) > 0) {
                                classes.setHealth(classes.getHealth() - monsterMagicalDmg);
                                playerSurvived();
                            } else {
                                playerSurvived();
                            }
                        }
                    }
                } else if (monsters.getPsychicalDamage() == monsters.getMagicalDamage()) {
                    if (classes.role.equals(Role.PALADIN) && abilityAction) {
                        System.out.println("The " + monsters.getName() + " deals " + monsterPureDmg +
                                " pure damage.");
                        System.out.println("You have reflected back the damage to the monster");
                        System.out.println("The " + monsters.getName() + " gets " + monsterPureDmg +
                                " pure damage.");
                        if (monsters.getMaxHealth() - monsterPureDmg <= 0) {
                            abilityAction = false;
                            monsterDeath();
                        } else {
                            monsters.setMaxHealth(monsters.getMaxHealth() - monsterPureDmg);
                            System.out.println("The " + monsters.getName() + " has " + monsters.getMaxHealth() +
                                    " health");
                            abilityAction = false;
                            turn = 1;
                        }
                    } else {
                        System.out.println("The " + monsters.getName() + " deals " + monsterPureDmg +
                                " pure damage.");
                        if (classes.getHealth() - monsterPureDmg <= 0) {
                            playerDeath();
                        } else if (classes.getHealth() - monsterPureDmg > 0) {
                            classes.setHealth(classes.getHealth() - monsterPureDmg);
                            playerSurvived();
                        }
                    }
                }
            }
        }
    }

    public void flee() {
        damage = (monsters.getMagicalDamage() + monsters.getPsychicalDamage()) / 2;
        if (dragonScore == 1) {
            damage = monsters.getMagicalDamage() / 2;
        }
        System.out.println("While you are trying to flee, the monster attacks you in the back.\n");
        System.out.println("The " + monsters.getName() + " deals " + damage + "  damage.");
        if (classes.getHealth() - damage <= 0) {
            playerDeath();
        } else {
            System.out.println("You have ran away!\n");
            dragonScore = 0;
            classes.setHealth(classes.getHealth() - damage);
            System.out.println("You have " + classes.getHealth() + "/" + classes.maxHealth() + " health.");
            System.out.println("You have " + classes.getMana() + "/" + classes.maxMana() + " mana.");
            deform();
            psychicalBullet = false;
            magicBullet = false;
            battle = false;
            turn = 0;
            abilityAction = false;
        }
    }

    public void monsterDeath() throws InterruptedException {
        psychicalBullet = false;
        magicBullet = false;
        turn = 0;
        battle = false;
        if (classes.role.equals(Role.WARRIOR) && abilityAction) {
            System.out.println("You have restored " + damage + " health to yourself.");
            if (classes.getHealth() + damage >= classes.maxHealth()) {
                classes.setHealth(classes.maxHealth());
            } else if (classes.getHealth() + damage < classes.maxHealth()) {
                classes.setHealth(classes.getHealth() + damage);
            }
        }
        abilityAction = false;
        System.out.println("The " + monsters.getName() + " has died\n");
        System.out.println("You have " + classes.getHealth() + "/" + classes.maxHealth() + " health.");
        System.out.println("You have " + classes.getMana() + "/" + classes.maxMana() + " mana.");
        System.out.println("You get " + monsters.getExp() + " experience points");
        monsters.setMaxHealth(monsters.getMaxHealth());
        if (dragonScore == 1) {
            arts.dragonDeath();
            if (monsters.getNewGamePlus() == 1) {
                System.out.println("You have killed the Dragon at level " + classes.getLevelUpScore() + ".");
            } else {
                System.out.println("You have killed the Dragon at level " + classes.getLevelUpScore() + " at new game + " + (monsters.getNewGamePlus() -1) + ".");
            }
            System.out.println("Congratulations!");
            System.out.println("You would like to continue with new game + " + monsters.getNewGamePlus() + "? (yes or no)");
            String answer = scanner.next();
            if (answer.equalsIgnoreCase("yes")) {
                System.out.println("You are starting from level 1 again but with all of your gained stats and equipments.");
                System.out.println("The monsters are grown stronger!");
                System.out.println("Good luck!");
                classes.setLevelUpScore(1);
                classes.setMaxExp(20);
                classes.setEXP(0);
                classes.setHealth(classes.maxHealth());
                classes.setMana(classes.maxMana());
                dragonScore = 0;
                monsters.setNewGamePlus(monsters.getNewGamePlus() + 1);
            } else {
                System.out.println("Thank you for trying out the game. \n Goodbye!");
                System.exit(0);
            }
        }
        if (monsters.getTransformCode() == 0) {
            ratForm = true;
        } else if (monsters.getTransformCode() == 1) {
            slimeForm = true;
        } else if (monsters.getTransformCode() == 2) {
            goblinForm = true;
        } else if (monsters.getTransformCode() == 3) {
            zombieForm = true;
        } else if (monsters.getTransformCode() == 4) {
            skeletonForm = true;
        } else if (monsters.getTransformCode() == 5) {
            wyvernForm = true;
        } else if (monsters.getTransformCode() == 6) {
            ogreForm = true;
        } else if (monsters.getTransformCode() == 7) {
            trollForm = true;
        }
        if (classes.getEXP() + monsters.getExp() == classes.getMaxExp()) {
            classes.setHealth(classes.maxHealth());
            classes.setMana(classes.maxMana());
            classes.levelUP();
            classes.setEXP(0);
        } else if (classes.getEXP() + monsters.getExp() < classes.getMaxExp()) {
            classes.setEXP(classes.getEXP() + monsters.getExp());
            System.out.println("You have " + classes.getEXP() + "/" + classes.getMaxExp() + " experience points.");
        } else if (classes.getEXP() + monsters.getExp() > classes.getMaxExp()) {
            classes.setEXP(classes.getEXP() + monsters.getExp() - classes.getMaxExp());
            classes.setHealth(classes.maxHealth());
            classes.setMana(classes.maxMana());
            classes.levelUP();
        }

        if (classes.role.equals(Role.NECROMANCER) && gigantos < 1) {
            undead();
        }
    }

    public void undead() {
        System.out.println("You have raised a small sized undead minion from your enemy's corpse's.");
        undeadSmall++;
        if (undeadSmall == 3) {
            undeadSmall = 0;
            undeadNormal++;
            System.out.println("Your 3 small sized undead minions have merged into a normal size undead.");
        }
        if (undeadNormal == 3) {
            undeadNormal = 0;
            undeadBig++;
            System.out.println("Your 3 normal sized undead minions have merged into a big size undead.");
        }
        if (undeadBig == 3) {
            undeadBig = 0;
            gigantos++;
            System.out.println("Your 3 big sized undead minions have merged into Gigantos, the destroyer.");
        }
    }

    public void transform() {
        System.out.println("Which creature you would you transform into?");
        if (ratForm) {
            System.out.println("Rat: psychical damage + 6, magical damage + 0, psychical defense + 2, magical defense + 0");
        }
        if (slimeForm) {
            System.out.println("Slime: psychical damage + 0, magical damage + 6, psychical defense + 0, magical defense + 2");
        }
        if (goblinForm) {
            System.out.println("Goblin: psychical damage + 8, magical damage + 0, psychical defense + 3, magical defense + 0");
        }
        if (zombieForm) {
            System.out.println("Zombie: psychical damage + 0, magical damage + 8, psychical defense + 0, magical defense + 3");
        }
        if (skeletonForm) {
            System.out.println("Skeleton: psychical damage + 10 , magical damage + 0, psychical defense + 5, magical defense + 2");
        }
        if (wyvernForm) {
            System.out.println("Wyvern: psychical damage + 0, magical damage + 10, psychical defense + 2, magical defense + 5");
        }
        if (ogreForm) {
            System.out.println("Ogre: psychical damage + 12, magical damage + 0, psychical defense + 7, magical defense + 4");
        }
        if (trollForm) {
            System.out.println("Troll: psychical damage + 0, magical damage + 12, psychical defense + 4, magical defense + 7");
        }
        String transform = scanner.next();
        switch (transform) {
            case "rat":
                if (ratForm) {
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
                if (slimeForm) {
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
                if (goblinForm) {
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
                if (zombieForm) {
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
                if (skeletonForm) {
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
                if (wyvernForm) {
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
                if (ogreForm) {
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
                if (trollForm) {
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
        battle = false;
        should = false;
        System.exit(0);
    }

    public void playerSurvived() {
        System.out.println("You have " + classes.getHealth() + "/" + classes.maxHealth() + " health.");
        System.out.println("You have " + classes.getMana() + "/" + classes.maxMana() + " mana.");
        turn = 1;
    }

    public void stats() {
        System.out.println("Level: " + classes.getLevelUpScore());
        System.out.println("Exp: " + classes.getEXP() + "/" + classes.getMaxExp());
        System.out.println("Maximum health: " + classes.maxHealth());
        System.out.println("Health: " + classes.getHealth());
        System.out.println("Maximum mana: " + classes.maxMana());
        System.out.println("Mana: " + classes.getMana());
        System.out.println("Psychical defense: " + (classes.psychicalDefense() + getTransformPsychicalDef()));
        System.out.println("Magical defense: " + (classes.magicalDefense() + getTransformMagicalDef()));
        System.out.println("Attack power: " + (classes.attackPower() + getTransformPsychicalDmg()));
        System.out.println("Magic power: " + (classes.magicPower() + getTransformMagicalDmg()));
        System.out.println("Initiative: " + classes.getInitiative());
        System.out.println("Critical chance: " + classes.critChance());
    }

    public void monsterTakeDamage() throws InterruptedException {
        if (monsters.getMaxHealth() - damage <= 0) {
            monsterDeath();
        } else {
            monsters.setMaxHealth(monsters.getMaxHealth() - damage);
            System.out.println("The " + monsters.getName() + " has " + monsters.getMaxHealth() +
                    " health");
            turn = 2;
        }
    }

    public int getTransformPsychicalDmg() {
        return transformPsychicalDmg;
    }

    public int getTransformMagicalDmg() {
        return transformMagicalDmg;
    }

    public int getTransformMagicalDef() {
        return transformMagicalDef;
    }

    public int getTransformPsychicalDef() {
        return transformPsychicalDef;
    }
    public int getUndeadSmall() {
        return undeadSmall;
    }

    public int getUndeadNormal() {
        return undeadNormal;
    }

    public int getUndeadBig() {
        return undeadBig;
    }

    public int getGigantos() {
        return gigantos;
    }
}
