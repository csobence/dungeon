package com.bence;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Weapon extends Chest{

    Random random = new Random();

    ArrayList<String> currentWeapon = new ArrayList<>();
    boolean should = false;
    int weaponINT;
    int weaponSTR;
    int weaponDEX;

    public Weapon(Classes classes, Arts arts, Scanner scanner, Items items) {
        super(classes, arts, scanner, items);
        this.classes = classes;
        this.scanner = scanner;
    }

    public void weaponDrop() {
        int i = 0;
        int weaponType = random.nextInt(3);
        if (weaponType == 0) {
            System.out.println("You have found a weapon with + " + classes.getNewGameScore() + " INT.");
            System.out.println("Do you want to change your weapon? (yes or no)");
            if (currentWeapon.isEmpty()) {
                System.out.println("Your recent weapon is a basic weapon.");
                currentWeapon.add("basic weapon");
            } else {
                System.out.println("Your recent weapon is a " + currentWeapon);
            }
            should = true;
        } else if (weaponType == 1) {
            System.out.println("You have found a weapon with + " + classes.getNewGameScore() + " STR.");
            System.out.println("Do you want to change your weapon? (yes or no)");
            if (currentWeapon.isEmpty()) {
                System.out.println("Your recent weapon is a basic weapon.");
                currentWeapon.add("basic weapon");
            } else {
                System.out.println("Your recent weapon is a " + currentWeapon);
            }
            should = true;
        } else {
            System.out.println("You have found a weapon with + " + classes.getNewGameScore() + " DEX.");
            System.out.println("Do you want to change your weapon? (yes or no)");
            if (currentWeapon.isEmpty()) {
                System.out.println("Your recent weapon is a basic weapon.");
                currentWeapon.add("basic weapon");
            } else {
                System.out.println("Your recent weapon is a " + currentWeapon);
            }
            should = true;
        }
        while (should) {
            String answer = scanner.next();
            if (answer.equalsIgnoreCase("yes") && weaponType == 0) {
                deStat();
                currentWeapon.remove(0);
                currentWeapon.add("weapon with " + + classes.getNewGameScore() + " INT.");
                setWeaponINT(classes.getNewGameScore());
                should = false;;
                classes.setINT(classes.getINT() + getWeaponINT());
            }  else if (answer.equalsIgnoreCase("yes") && weaponType == 1) {
                deStat();
                currentWeapon.remove(0);
                currentWeapon.add("weapon with " + + classes.getNewGameScore() + " STR.");
                setWeaponSTR(classes.getNewGameScore());
                should = false;
                classes.setSTR(classes.getSTR() + getWeaponSTR());
            } else if (answer.equalsIgnoreCase("yes") && weaponType == 2) {
                deStat();
                currentWeapon.remove(0);
                currentWeapon.add("weapon with " + + classes.getNewGameScore() + " DEX.");
                setWeaponDEX(classes.getNewGameScore());
                should = false;
                classes.setDEX(classes.getDEX() + getWeaponDEX());
            } else if (answer.equalsIgnoreCase("no")) {
                should = false;
            } else {
                System.out.println("Wrong answer!");
            }
        }
    }

    public ArrayList<String> getCurrentWeapon() {
        return currentWeapon;
    }
    public int getWeaponINT() {
        return weaponINT;
    }

    public void setWeaponINT(int weaponINT) {
        this.weaponINT = weaponINT;
    }

    public int getWeaponSTR() {
        return weaponSTR;
    }

    public void setWeaponSTR(int weaponSTR) {
        this.weaponSTR = weaponSTR;
    }

    public int getWeaponDEX() {
        return weaponDEX;
    }

    public void setWeaponDEX(int weaponDEX) {
        this.weaponDEX = weaponDEX;
    }
    public void deStat() {
        classes.setINT(classes.getINT() - getWeaponINT());
        classes.setSTR(classes.getSTR() - getWeaponSTR());
        classes.setDEX(classes.getDEX() - getWeaponDEX());
        setWeaponINT(0);
        setWeaponSTR(0);
        setWeaponDEX(0);
    }
}
