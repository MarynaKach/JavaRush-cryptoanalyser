package com.javarush.cryptoanalyser;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileOperations {
    public static char[] readFile(String passToFile) throws IOException {
        FileInputStream in = new FileInputStream(passToFile);
        FileReader input = new FileReader(passToFile);
        char[] encryptedText = new char[in.readAllBytes().length];
        input.read(encryptedText);

        return encryptedText;
    }

    public static String writeFile(char[] encryptedText, String pathDestinationFile) throws IOException {
        FileWriter out = new FileWriter(pathDestinationFile);
        out.write(encryptedText);
        out.flush();

        return pathDestinationFile;
    }
}

