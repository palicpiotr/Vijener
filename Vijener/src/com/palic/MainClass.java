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
import java.util.Scanner;

/**
 *
 * @author Piotr
 */
public class MainClass {

    public static void main(String[] args) throws IOException {

        IEncriptor encriptor = new Encrypt();
        //Scanner sc = new Scanner(System.in);
        encriptor.CreateAlphabet();
        System.out.println(encriptor.EncryptTextString());
        System.out.println("");
        System.out.println(encriptor.DecriptTextString());
        /*BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, Charset.forName("windows-1251")));
        System.out.println("Choose the the mode: encrypt the encrypt/decript");
        String chooseString = reader.readLine().toLowerCase();
        switch (chooseString) {
            case "Enc": {
                System.out.println("");
                System.out.println(encriptor.EncryptTextString());
                break;
            }
            case "Dec": {
                System.out.println("");
                System.out.println(encriptor.DecriptTextString());
                break;
            }
        }*/
        // System.out.println(encriptor.EncryptTextString());
        System.out.println("");
        //System.out.println(encriptor.DecriptTextString());

    }
}
