package com.javarush.cryptoanalyser;

public class CryptoOperations {
    public static char[] encryptionText(char[] encryptedText, int cryptoKey) {
        char[] resultOfEncryption = new char[encryptedText.length];
        for (int i = 0; i < encryptedText.length; i++) {
            encryptedText[i] = (encryptedText[i] + "").toLowerCase().charAt(0);
            for (int k = 0; k < Main.ALPHABET.length; k++) {
                if (encryptedText[i] == Main.ALPHABET[k]) {
                    int resultIndex = k + cryptoKey;
                    if (resultIndex > Main.ALPHABET.length - 1) {
                        resultOfEncryption[i] = Main.ALPHABET[resultIndex - Main.ALPHABET.length];
                    } else {
                        resultOfEncryption[i] = Main.ALPHABET[resultIndex];
                    }
                }
            }
        }
        return resultOfEncryption;
    }

    public static char[] decryptionText(char[] encryptedText, int cryptoKey) {
        char[] resultDecryption = new char[encryptedText.length];
        for (int i = 0; i < encryptedText.length; i++) {
            encryptedText[i] = (encryptedText[i] + "").toLowerCase().charAt(0);
            for (int k = 0; k < Main.ALPHABET.length; k++) {
                if (encryptedText[i] == Main.ALPHABET[k]) {
                    int resultIndex = k - cryptoKey;
                    if (resultIndex < 0) {
                        resultDecryption[i] = Main.ALPHABET[Main.ALPHABET.length + resultIndex];
                    } else {
                        resultDecryption[i] = Main.ALPHABET[resultIndex];
                    }
                }
            }
        }
        return resultDecryption;
    }
}

