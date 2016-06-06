/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.palic;

import java.io.IOException;

/**
 *
 * @author Piotr
 */
public interface IEncriptor {

    public void EnteringTheValues();
    
    public void CreateAlphabet() throws IOException;

    public String EncryptTextString() throws IOException;

    public String DecriptTextString() throws IOException;

    public String EncChar(String encString, int num);

    public String DecChar(String decString, int num);
}
