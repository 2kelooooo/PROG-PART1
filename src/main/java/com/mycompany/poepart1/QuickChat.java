/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poepart1;
import java.util.Scanner;
/**
 *
 * @author Student
 */
public class QuickChat {

    Scanner input = new Scanner(System.in);
    int count = 0;

    public void startChat(int limit) {
        for (int i = 0; i < limit; i++) {
            System.out.print("Enter recipient cell (+27...): ");
            String rec = input.nextLine();

            System.out.print("Enter your message (max 250): ");
            String msg = input.nextLine();

            Message m = new Message(i, rec, msg);

            //  Check recipient 
            boolean validCell = m.checkRecipientCell(rec);
            if (!validCell) {
                System.out.println("Cell phone number is incorrectly formatted or does not contain an international code, please correct the number and try again.");
                i = i - 1;
                continue;
            } else {
                System.out.println("Cell phone number successfully captured.");
            }

            // Check length 
            if (!m.checkMessageLength(msg)) {
                int extra = msg.length() - 250;
                System.out.println("Message exceeds 250 characters by " + extra + ", please reduce size.");
                i = i - 1;
                continue;
            }

            System.out.println("What do you want to do?");
            System.out.println("1) Send Message");
            System.out.println("2) Disregard Message");
            System.out.println("3) Store Message");
            int opt = Integer.parseInt(input.nextLine());

            //  uses message method
            String result = m.sentMessage(opt);
            System.out.println(result);

            if (opt == 1) {
                System.out.println("MessageID: " + m.getMessageID());
                System.out.println("Message Hash: " + m.getMessageHash());
                System.out.println("Recipient: " + m.getRecipient());
                System.out.println("Message: " + m.getMessage());
                count++;
            } else if (opt == 3) {
                m.storeMessage();
                System.out.println("Message successfully  stored.");
                count++;
            } else if (opt == 2) {
                System.out.println("Message disregarded.");
            }
        }
    }

    public String sentMessage(int choice) {
        if (choice==1){
            return"Message sucessfully sent.";
        }else 
            if(choice==2){
                return"Message disregarded.";
            }else{
                return "Message successfully stored";
            }
        
    }
}

