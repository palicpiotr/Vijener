/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.palic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Piotr
 */
public class Encrypt implements IEncriptor {

    String alphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    ArrayList<String> decription = new ArrayList<>();
    public int key;
    public String keyString;
    int temporaryValriable = 0;
    int temporaryValriable1 = 0;
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, Charset.forName("windows-1251")));

    @Override
    public void EnteringTheValues() {

    }

    @Override
    public void CreateAlphabet() throws IOException {
        try {
            //System.out.println("Please,enter the key word");
            //  Scanner sc = new Scanner(System.in);
            //  String keyString = sc.nextLine();
            System.out.println("Enter the Key String");
            keyString = reader.readLine();
            for (int j = 0; j < 10; j++) {
                if (keyString.contains(String.valueOf(j))) {
                    System.out.println("Key string may not contain numbers");

                }
            }
            System.out.println("");
            System.out.println("Enter the key");
            Scanner sc = new Scanner(System.in);
            try {
                key = sc.nextInt();
            } catch (Exception exception) {
                System.out.println("Key number may not contain words or other symbols" + exception);
            }
            System.out.println("");

            for (int i = 0; i < keyString.length(); i++) {
                String part1 = alphabet.split(String.valueOf(keyString.charAt(i)))[1];
                String part2 = alphabet.split(String.valueOf(keyString.charAt(i)))[0];
                decription.add(keyString.charAt(i) + part1 + part2);
            }
            decription.stream().forEach((s) -> {
                // for (String s : decription) {
                System.out.println(s);
            });
        } catch (Exception exception) {
            System.err.println(exception);
        }
    }

    @Override
    public String EncryptTextString() throws IOException {
        System.out.println("The the text which will be encrypted");
        String parameterString = reader.readLine();
        StringBuilder sb = new StringBuilder();
        try {
            for (int i = 0; i < parameterString.length(); i++) {
                sb.append(EncChar(String.valueOf(parameterString.charAt(i)), i)); 
            }
        } catch (Exception exception) {
            System.err.println(exception);
        }
        return sb.toString();
    }

    @Override
    public String DecriptTextString() throws IOException {
        System.out.println("The the text which will be decrypted");
        String parameterString = reader.readLine();
        StringBuilder sb = new StringBuilder();
        try {
            for (int i = 0; i < parameterString.length(); i++) {
                sb.append(DecChar(String.valueOf(parameterString.charAt(i)), i));
            }
        } catch (Exception exception) {
            System.err.println(exception);
        }
        return sb.toString();
    }

    @Override
    public String EncChar(String encString, int num) {
        try {
            if (!alphabet.contains(encString)) {
                temporaryValriable -= 1;
                return encString;
            } else {
                String tmp1 = decription.get((num + temporaryValriable) % key);
                return (String.valueOf(tmp1.charAt(alphabet.indexOf(encString))));
            }
        } catch (Exception exception) {
            System.err.println(exception);
        }
        return "";
    }

    @Override
    public String DecChar(String decString, int num) {
        try {
            String temporaryValriable2 = decription.get((num + temporaryValriable1) % key);
            if (!temporaryValriable2.contains(decString)) {
                temporaryValriable1 -= 1;
                return decString;
            } else {
                return (String.valueOf(alphabet.charAt(temporaryValriable2.indexOf(decString))));
            }
        } catch (Exception exception) {
            System.err.println(exception);
        }
        return "";

    }

}
