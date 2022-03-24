package com.javarush.cryptoanalyser;

import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.Scanner;

public class DialogueUser {
    public static void printMassage(String massage) {
        System.out.println(massage);
    }

    public static int checkCryptoOption(String chooseTypeCryptoMassage) {
        printMassage(chooseTypeCryptoMassage);
        Scanner console = new Scanner(System.in);
        int cryptoOption = console.nextInt();
        while (cryptoOption != 1 && cryptoOption != 2) {
            printMassage(chooseTypeCryptoMassage);
            cryptoOption = console.nextInt();
        }
        return cryptoOption;
    }

    public static String checkPathFile(String askForPath, String askForPathAgain) {
        printMassage(askForPath);
        String pathToFile = ScannerSingleton.getInstance().nextLine();
        try {
            Path path = Path.of(pathToFile);
            boolean isPass = Files.exists(path);
            while (!isPass) {
                printMassage(askForPathAgain);
                pathToFile = ScannerSingleton.getInstance().nextLine();
                path = Path.of(pathToFile);
                isPass = Files.exists(path);
            }
        } catch (InvalidPathException ex) {
            System.out.println("The file does not exist or it is corrupted.");
        }
        return pathToFile;
    }

    public static int checkKeyOfCrypto(String askForKey) {
        printMassage(askForKey + Main.ALPHABET.length);
        int cryptoKey = ScannerSingleton.getInstance().nextInt();
        while (cryptoKey < 1 || cryptoKey > Main.ALPHABET.length) {
            System.out.println(askForKey + Main.ALPHABET.length);
            cryptoKey = ScannerSingleton.getInstance().nextInt();
        }
        return cryptoKey;
    }
}

