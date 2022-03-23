package com.javarush.cryptoanalyser;

import java.io.IOException;

public class Main {
    public static char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к', 'л',
            'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ',
            'ы', 'ь', 'э', 'ю', 'я', '.', ',', '"', ':', '-', '!', '?', ' '};

    public static void main(String[] args) {
        String askSourcePath = "Hello, User, please, insert the path to source file:";
        String askForPathAgain = "It is not the path to the file. Please insert the pass to the file:";
        String pathSourceFile = DialogueUser.checkPathToFile(askSourcePath, askForPathAgain);
        String askDestinationPath = "Please, insert the path to destination file:";
        String pathDestinationFile = DialogueUser.checkPathToFile(askDestinationPath, askForPathAgain);
        String askForKey = "Please, type the key number for encoding from 1 to ";
        int cryptoKey = DialogueUser.checkKeyOfCrypto(askForKey);
        String chooseTypeCryptoMassage = "Please choose: \n- to encrypt, type 1, \n- to decrypt, type 2";
        int cryptoOption = DialogueUser.checkCryptoOption(chooseTypeCryptoMassage);
        try {
            char[] encryptedText = FileOperations.readFile(pathSourceFile);
            if (cryptoOption == 1) {
                char[] resultOfEncryption = CryptoOperations.encryptionText(encryptedText, cryptoKey);
                String destinationFilePath = FileOperations.writeFile
                        (resultOfEncryption, pathDestinationFile);
                DialogueUser.printMassage(destinationFilePath);
            } else if (cryptoOption == 2) {
                char[] resultDecryption = CryptoOperations.decryptionText
                        (encryptedText, cryptoKey);
                String destinationFilePath = FileOperations.writeFile
                        (resultDecryption, pathDestinationFile);
                DialogueUser.printMassage(destinationFilePath);
            }
        } catch (IOException e) {
            System.out.println("The file was not found or the file is corrupted.");
        }
    }
}

