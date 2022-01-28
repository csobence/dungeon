package com.bence;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Armor extends Chest{

    Random random = new Random();
    Arts arts;

    ArrayList<String> currentHelmet = new ArrayList<>();
    ArrayList<String> currentChest = new ArrayList<>();
    ArrayList<String> currentLeggings = new ArrayList<>();
    ArrayList<String> currentBoots = new ArrayList<>();
    boolean should = false;
    int armorType;

    String armorPiece;
    String armorStat;

    int helmetINT;
    int helmetCON;
    int helmetWIS;
    int helmetCHA;

    int chestINT;
    int chestCON;
    int chestWIS;
    int chestCHA;

    int leggingsINT;
    int leggingsCON;
    int leggingsWIS;
    int leggingsCHA;

    int bootsINT;
    int bootsCON;
    int bootsWIS;
    int bootsCHA;

    public Armor(Classes classes, Arts arts, Scanner scanner, Items items) {
        super(classes, arts, scanner, items);
        this.classes = classes;
        this.scanner = scanner;
        this.arts = arts;
    }

    public void armorDrop() {
         armorType = random.nextInt(4);
        int drop = random.nextInt(4);
        if (drop == 0) {
            armorPiece = "helmet";
        } else if (drop == 1) {
            armorPiece = "chest";
        } else if (drop == 2) {
            armorPiece = "leggings";
        } else {
            armorPiece = "boots";
        }
        if (armorType == 0) {
            armorStat = "INT";
            armorFound();
        } else if (armorType == 1) {
            armorStat = "CON";
            armorFound();
        } else if (armorType == 2) {
            armorStat = "WIS";
            armorFound();
        }  else {
            armorStat = "CHA";
            armorFound();
        }
        while (should) {
            String answer = scanner.next();
            if (answer.equalsIgnoreCase("yes") && armorType == 0) {
                if (armorPiece.equalsIgnoreCase("helmet")) {
                    deStatHelmet();
                    currentHelmet.remove(0);
                    currentHelmet.add(armorPiece + " with " + +classes.getNewGameScore() + " " + armorStat + ".");
                    setHelmetINT(classes.getNewGameScore());
                    should = false;
                    classes.setINT(classes.getINT() + getHelmetINT());
                } else if (armorPiece.equalsIgnoreCase("chest")) {
                    deStatChest();
                    currentChest.remove(0);
                    currentChest.add(armorPiece + " with " + +classes.getNewGameScore() + " " + armorStat + ".");
                    setChestINT(classes.getNewGameScore());
                    should = false;
                    classes.setINT(classes.getINT() + getChestINT());
                } else if (armorPiece.equalsIgnoreCase("leggings")) {
                    deStatLeggings();
                    currentLeggings.remove(0);
                    currentLeggings.add(armorPiece + " with " + +classes.getNewGameScore() + " " + armorStat + ".");
                    setLeggingsINT(classes.getNewGameScore());
                    should = false;
                    classes.setINT(classes.getINT() + getLeggingsINT());
                } else if (armorPiece.equalsIgnoreCase("boots")) {
                    deStatBoots();
                    currentBoots.remove(0);
                    currentBoots.add(armorPiece + " with " + +classes.getNewGameScore() + " " + armorStat + ".");
                    setBootsINT(classes.getNewGameScore());
                    should = false;
                    classes.setINT(classes.getINT() + getBootsINT());
                }
            }  else if (answer.equalsIgnoreCase("yes") && armorType == 1) {
                if (armorPiece.equalsIgnoreCase("helmet")) {
                    deStatHelmet();
                    currentHelmet.remove(0);
                    currentHelmet.add(armorPiece + " with " + +classes.getNewGameScore() + " " + armorStat + ".");
                    setHelmetCON(classes.getNewGameScore());
                    should = false;
                    classes.setCON(classes.getCON() + getHelmetCON());
                } else if (armorPiece.equalsIgnoreCase("chest")) {
                    deStatChest();
                    currentChest.remove(0);
                    currentChest.add(armorPiece + " with " + +classes.getNewGameScore() + " " + armorStat + ".");
                    setChestCON(classes.getNewGameScore());
                    should = false;
                    classes.setCON(classes.getCON() + getChestCON());
                } else if (armorPiece.equalsIgnoreCase("leggings")) {
                    deStatLeggings();
                    currentLeggings.remove(0);
                    currentLeggings.add(armorPiece + " with " + +classes.getNewGameScore() + " " + armorStat + ".");
                    setLeggingsCON(classes.getNewGameScore());
                    should = false;
                    classes.setCON(classes.getCON() + getLeggingsCON());
                } else if (armorPiece.equalsIgnoreCase("boots")) {
                    deStatBoots();
                    currentBoots.remove(0);
                    currentBoots.add(armorPiece + " with " + +classes.getNewGameScore() + " " + armorStat + ".");
                    setBootsCON(classes.getNewGameScore());
                    should = false;
                    classes.setCON(classes.getCON() + getBootsCON());
                }
            } else if (answer.equalsIgnoreCase("yes") && armorType == 2) {
                if (armorPiece.equalsIgnoreCase("helmet")) {
                    deStatHelmet();
                    currentHelmet.remove(0);
                    currentHelmet.add(armorPiece + " with " + +classes.getNewGameScore() + " " + armorStat + ".");
                    setHelmetWIS(classes.getNewGameScore());
                    should = false;
                    classes.setWIS(classes.getWIS() + getHelmetWIS());
                } else if (armorPiece.equalsIgnoreCase("chest")) {
                    deStatChest();
                    currentChest.remove(0);
                    currentChest.add(armorPiece + " with " + +classes.getNewGameScore() + " " + armorStat + ".");
                    setChestWIS(classes.getNewGameScore());
                    should = false;
                    classes.setWIS(classes.getWIS() + getChestWIS());
                } else if (armorPiece.equalsIgnoreCase("leggings")) {
                    deStatLeggings();
                    currentLeggings.remove(0);
                    currentLeggings.add(armorPiece + " with " + +classes.getNewGameScore() + " " + armorStat + ".");
                    setLeggingsWIS(classes.getNewGameScore());
                    should = false;
                    classes.setWIS(classes.getWIS() + getLeggingsWIS());
                } else if (armorPiece.equalsIgnoreCase("boots")) {
                    deStatBoots();
                    currentBoots.remove(0);
                    currentBoots.add(armorPiece + " with " + +classes.getNewGameScore() + " " + armorStat + ".");
                    setBootsWIS(classes.getNewGameScore());
                    should = false;
                    classes.setWIS(classes.getWIS() + getBootsWIS());
                }
            } else if (answer.equalsIgnoreCase("yes") && armorType == 3) {
                if (armorPiece.equalsIgnoreCase("helmet")) {
                    deStatHelmet();
                    currentHelmet.remove(0);
                    currentHelmet.add(armorPiece + " with " + +classes.getNewGameScore() + " " + armorStat + ".");
                    setHelmetCHA(classes.getNewGameScore());
                    should = false;
                    classes.setCHA(classes.getCHA() + getHelmetCHA());
                } else if (armorPiece.equalsIgnoreCase("chest")) {
                    deStatChest();
                    currentChest.remove(0);
                    currentChest.add(armorPiece + " with " + +classes.getNewGameScore() + " " + armorStat + ".");
                    setChestCHA(classes.getNewGameScore());
                    should = false;
                    classes.setCHA(classes.getCHA() + getChestCHA());
                } else if (armorPiece.equalsIgnoreCase("leggings")) {
                    deStatLeggings();
                    currentLeggings.remove(0);
                    currentLeggings.add(armorPiece + " with " + +classes.getNewGameScore() + " " + armorStat + ".");
                    setLeggingsCHA(classes.getNewGameScore());
                    should = false;
                    classes.setCHA(classes.getCHA() + getLeggingsCHA());
                } else if (armorPiece.equalsIgnoreCase("boots")) {
                    deStatBoots();
                    currentBoots.remove(0);
                    currentBoots.add(armorPiece + " with " + +classes.getNewGameScore() + " " + armorStat + ".");
                    setBootsCHA(classes.getNewGameScore());
                    should = false;
                    classes.setCHA(classes.getCHA() + getBootsCHA());
                }
            } else if (answer.equalsIgnoreCase("no")) {
                should = false;
            } else {
                System.out.println("Wrong answer!");
            }
        }
    }
    public int getHelmetINT() {
        return helmetINT;
    }

    public void setHelmetINT(int helmetINT) {
        this.helmetINT = helmetINT;
    }

    public int getHelmetCON() {
        return helmetCON;
    }

    public void setHelmetCON(int helmetCON) {
        this.helmetCON = helmetCON;
    }

    public int getHelmetWIS() {
        return helmetWIS;
    }

    public void setHelmetWIS(int helmetWIS) {
        this.helmetWIS = helmetWIS;
    }

    public int getHelmetCHA() {
        return helmetCHA;
    }

    public void setHelmetCHA(int helmetCHA) {
        this.helmetCHA = helmetCHA;
    }
    public void deStatHelmet() {
        classes.setINT(classes.getINT() - getHelmetINT());
        classes.setCON(classes.getCON() - getHelmetCON());
        classes.setWIS(classes.getWIS() - getHelmetWIS());
        classes.setCHA(classes.getCHA() - getHelmetCHA());
        setHelmetINT(0);
        setHelmetCON(0);
        setHelmetWIS(0);
        setHelmetCHA(0);
    }

    public int getChestINT() {
        return chestINT;
    }

    public void setChestINT(int chestINT) {
        this.chestINT = chestINT;
    }

    public int getChestCON() {
        return chestCON;
    }

    public void setChestCON(int chestCON) {
        this.chestCON = chestCON;
    }

    public int getChestWIS() {
        return chestWIS;
    }

    public void setChestWIS(int chestWIS) {
        this.chestWIS = chestWIS;
    }

    public int getChestCHA() {
        return chestCHA;
    }

    public void setChestCHA(int chestCHA) {
        this.chestCHA = chestCHA;
    }
    public void deStatChest() {
        classes.setINT(classes.getINT() - getChestINT());
        classes.setCON(classes.getCON() - getChestCON());
        classes.setWIS(classes.getWIS() - getChestWIS());
        classes.setCHA(classes.getCHA() - getChestCHA());
        setChestINT(0);
        setChestCON(0);
        setChestWIS(0);
        setChestCHA(0);
    }
    public int getLeggingsINT() {
        return leggingsINT;
    }

    public void setLeggingsINT(int leggingsINT) {
        this.leggingsINT = leggingsINT;
    }

    public int getLeggingsCON() {
        return leggingsCON;
    }

    public void setLeggingsCON(int leggingsCON) {
        this.leggingsCON = leggingsCON;
    }

    public int getLeggingsWIS() {
        return leggingsWIS;
    }

    public void setLeggingsWIS(int leggingsWIS) {
        this.leggingsWIS = leggingsWIS;
    }

    public int getLeggingsCHA() {
        return leggingsCHA;
    }

    public void setLeggingsCHA(int leggingsCHA) {
        this.leggingsCHA = leggingsCHA;
    }
    public void deStatLeggings() {
        classes.setINT(classes.getINT() - getLeggingsINT());
        classes.setCON(classes.getCON() - getLeggingsCON());
        classes.setWIS(classes.getWIS() - getLeggingsWIS());
        classes.setCHA(classes.getCHA() - getLeggingsCHA());
        setLeggingsINT(0);
        setLeggingsCON(0);
        setLeggingsWIS(0);
        setLeggingsCHA(0);
    }
    public int getBootsINT() {
        return bootsINT;
    }

    public void setBootsINT(int bootsINT) {
        this.bootsINT = bootsINT;
    }

    public int getBootsCON() {
        return bootsCON;
    }

    public void setBootsCON(int bootsCON) {
        this.bootsCON = bootsCON;
    }

    public int getBootsWIS() {
        return bootsWIS;
    }

    public void setBootsWIS(int bootsWIS) {
        this.bootsWIS = bootsWIS;
    }

    public int getBootsCHA() {
        return bootsCHA;
    }

    public void setBootsCHA(int bootsCHA) {
        this.bootsCHA = bootsCHA;
    }
    public void deStatBoots() {
        classes.setINT(classes.getINT() - getBootsINT());
        classes.setCON(classes.getCON() - getBootsCON());
        classes.setWIS(classes.getWIS() - getBootsWIS());
        classes.setCHA(classes.getCHA() - getBootsCHA());
        setBootsINT(0);
        setBootsCON(0);
        setBootsWIS(0);
        setBootsCHA(0);
    }
    public void armorFound() {
        armorArt();
        System.out.println("You have found a " + armorPiece + " with + " + classes.getNewGameScore() + " " + armorStat + ".");
        System.out.println("Do you want to change your " + armorPiece + "? (yes or no)");
        if (currentHelmet.isEmpty() && armorPiece.equalsIgnoreCase("helmet")) {
            System.out.println("Your recent " + armorPiece + " is a basic " + armorPiece + ".");
            currentHelmet.add("basic " + armorPiece + ".");
        } else if (!currentHelmet.isEmpty() && armorPiece.equalsIgnoreCase("helmet")){
            System.out.println("Your recent " + armorPiece + " is a " + currentHelmet);
        }
        if (currentChest.isEmpty() && armorPiece.equalsIgnoreCase("chest")) {
            System.out.println("Your recent " + armorPiece + " is a basic " + armorPiece + ".");
            currentChest.add("basic " + armorPiece + ".");
        } else if (!currentChest.isEmpty() && armorPiece.equalsIgnoreCase("chest")){
            System.out.println("Your recent " + armorPiece + " is a " + currentChest);
        }
        if (currentLeggings.isEmpty() && armorPiece.equalsIgnoreCase("leggings")) {
            System.out.println("Your recent " + armorPiece + " is a basic " + armorPiece + ".");
            currentLeggings.add("basic " + armorPiece + ".");
        } else if (!currentLeggings.isEmpty() && armorPiece.equalsIgnoreCase("leggings")) {
            System.out.println("Your recent " + armorPiece + " is a " + currentLeggings);
        }
        if (currentBoots.isEmpty() && armorPiece.equalsIgnoreCase("boots")) {
            System.out.println("Your recent " + armorPiece + " is a basic " + armorPiece + ".");
            currentBoots.add("basic " + armorPiece + ".");
        } else if (!currentBoots.isEmpty() && armorPiece.equalsIgnoreCase("boots")) {
            System.out.println("Your recent " + armorPiece + " is a " + currentBoots);
        }
        should = true;
    }
    public void armorArt() {
        if (armorPiece.equalsIgnoreCase("helmet")) {
            arts.helmet();
        } else if (armorPiece.equalsIgnoreCase("chest")) {
            arts.chestPlate();
        } else if (armorPiece.equalsIgnoreCase("leggings")) {
            arts.leggings();
        } else if (armorPiece.equalsIgnoreCase("boots")) {
            arts.boots();
        }
    }
    public String getArmorPiece() {
        return armorPiece;
    }
}
