/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poepart1;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.util.ArrayList;
/**
 *
 * @author Student
 */



public class QuickChat {
    public static void main(String[] args) {
        MessageManager mm = new MessageManager();
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        while (choice != 5) {
            System.out.println("\n=== QUICKCHAT ===");
            System.out.println("1. Send Messages");
            System.out.println("2. Show Recently Sent Messages");
            System.out.println("3. Quit");
            System.out.println("4. Stored Messages");
            System.out.print("Choose: ");
            choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) System.out.println("Messages already populated for Part 3 - see Stored Messages menu.");
            if (choice == 2) mm.displaySentMessages();
            if (choice == 4) {
                int sub = 0;
                while (sub != 7) {
                    System.out.println("\n--- STORED MESSAGES ---");
                    System.out.println("1. Display sender & recipient of stored");
                    System.out.println("2. Display longest stored message");
                    System.out.println("3. Search by Message ID");
                    System.out.println("4. Search by Recipient");
                    System.out.println("5. Delete by Hash");
                    System.out.println("6. Display Report");
                    System.out.println("7. Back / Save & Load JSON");
                    System.out.print("Choose: ");
                    sub = sc.nextInt();
                    sc.nextLine();
                    if (sub == 1) mm.displayStoredSendersRecipients();
                    if (sub == 2) mm.displayLongestMessage();
                    if (sub == 3) {
                        System.out.print("Enter Message ID: ");
                        System.out.println(mm.searchByMessageID(sc.nextLine()));
                    }
                    if (sub == 4) {
                        System.out.print("Enter Recipient: ");
                        System.out.println(mm.searchByRecipient(sc.nextLine()));
                    }
                    if (sub == 5) {
                        System.out.print("Enter Hash: ");
                        System.out.println(mm.deleteMessageByHash(sc.nextLine()));
                    }
                    if (sub == 6) mm.displayReport();
                    if (sub == 7) {
                        mm.saveStoredMessagesToJson();
                        mm.loadStoredMessagesFromJson();
                    }
                }
            }
        }
        System.out.println("Goodbye!");
        sc.close();
    }

    void startChat(int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}