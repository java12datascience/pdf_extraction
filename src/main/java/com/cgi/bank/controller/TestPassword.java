package com.cgi.bank.controller;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestPassword {
	public static void main(String[] args){
       //PBEWithMDAndDES
        Scanner sc= new Scanner(System.in);    
        System.out.println("Please enter the password that needs to be encrypted :");
        String input = sc.next();

        try {
            String encryptedPassword=PasswordEnycripted.encryptPassword(input);
            System.out.println("Encrypted password generated is :"+encryptedPassword);
        } catch (Exception ex) {
            Logger.getLogger(TestPassword.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
