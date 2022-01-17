package com.bence;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Classes classes = new Classes();
        Arts arts = new Arts();
        Game game = new Game(classes, arts);
        Monsters monsters = new Monsters();

        Scanner scanner = new Scanner(System.in);
        UserInterface userInterface = new UserInterface(game, classes, monsters, scanner, arts);

        userInterface.startGame();


    }
}

