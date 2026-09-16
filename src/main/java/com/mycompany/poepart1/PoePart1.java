/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poepart1;

import java.util. Scanner;
/**
 *
 * @author DELL
 */
public class PoePart1 {

    public static void main(String[] args) {
      
        Scanner input=new Scanner(System.in);

        Login login=null;//holds registered user
        boolean running=true;
        
        while(running){
            System.out.println("===================");
            System.out.println("Welcome to chat app what would you like to do?");
            System.out.println("===================");

            System.out.println("1.Register");
            System.out.println("2.Login");
            System.out.println("3.Exit");

            System.out.println("Please choose an option:");

            String choice=input.nextLine();
            if(choice.equals("1")){

                System.out.println("Enter first name ");
                String name=input.nextLine();//read first name

                System.out.println("Enter last name");
                String surname=input.nextLine();

                login = new Login(name ,surname);//creating new login object

                System.out.println(" Enter username");
                String username=input.nextLine();// read username
                while(!login.checkUserName(username)){
                    System.out.println("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.");
                    System.out.println(" Enter username");
                    username=input.nextLine();
                }

                System.out.println("Enter password");
                String password=input.nextLine();
                while(!login.checkPasswordComplexity(password)){
                    System.out.println("Password is not correctly formatted, please ensure that the password contains at least eight characters, a capital letter, a number and a special character.");
                    System.out.println("Enter password");
                    password=input.nextLine();
                }

                System.out.println(" Enter cell phone number");
                String cell=input.nextLine();
                while(!login.checkCellPhoneNumber(cell)){
                    System.out.println("Cell phone number is incorrectly formatted or does not contain an international code, please correct the number and try again.");
                    System.out.println(" Enter cell phone number");
                    cell=input.nextLine();
                }

                String result=login.registerUser(username, password, cell);
                System.out.println(result);

            } else if (choice.equals("2")) {// if user chooses to login
                if (login == null) {
                    System.out.println("No user registered yet.Please register first");
                } else { // ask for login details
                    System.out.println("Enter username to login");
                    String loginU = input.nextLine();
                    System.out.println("Enter password to login");
                    String loginP = input.nextLine();
                    System.out.println(login.returnLoginStatus(loginU, loginP));
                }

            } else if (choice.equals("3")) {
                System.out.println("Exiting..");
                running = false;// stop loop

            } else {
                System.out.println("Invalid option");
            }
        }
        input.close();// close scanner
    
    }
}