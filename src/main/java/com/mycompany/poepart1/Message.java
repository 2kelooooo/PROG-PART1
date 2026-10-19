/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poepart1;
import java.util.ArrayList;


/**
 *
 * @author Student
 */
public class Message {
    
    private String messageID;
    private int messageNumber;
    private String recipient;
    private String message;
    private String messageHash;

    // FOR APP - QuickChat uses this
    public Message(int number, String rec, String msg) {
        this.messageNumber = number;
        this.recipient = rec;
        this.message = msg;
        this.messageID = createMessageID();
        this.messageHash = createMessageHash(this.messageID, this.messageNumber, this.message);
    }

    // FOR TESTS - fixes all red new Message()
    public Message() {
        this.messageNumber = 0;
        this.recipient = "";
        this.message = "";
        this.messageID = "1234567890";
        this.messageHash = "";
    }

    // fixes createMessageID() red
    public String createMessageID() {
        long num = (long)(Math.random() * 9000000000L) + 1000000000L;
        return String.valueOf(num);
    }

    // fixes createMessageHash(id, 0, "Hi Mike") red - THIS IS THE ONE IN YOUR PIC
    public String createMessageHash(String id, int num, String msg) {
        if (msg == null || msg.trim().isEmpty()) {
            return (id.substring(0, 2) + ":" + num + ":EMPTY").toUpperCase();
        }
        String[] words = msg.trim().split("\\s+");
        String first = words[0];
        String last = words[words.length - 1];
        return (id.substring(0, 2) + ":" + num + ":" + first + last).toUpperCase();
    }

    // for app use - no args
    public String createMessageHash() {
        return createMessageHash(this.messageID, this.messageNumber, this.message);
    }
    public boolean checkRecipientCell(String cell) {
        if (cell == null) return false;
        // must be + plus 9-12 digits only, total 10-13 chars, no letters
        // example +27834557896 is valid, +27ABCD is NOT valid
        return cell.matches("^\\+\\d{9,12}$");
    }
    
    

    public boolean checkMessageLength(String m) {
        return m != null && m.length() <= 250;
    }

    // fixes sentMessage() red in your last pic
    public String sentMessage(int choice) {
        if (choice == 1) {
            return "Message successfully sent.";
        }
        if (choice == 2) {
            return "Press 0 to delete message.";
        }
        if (choice == 3) {
            return "Message successfully stored.";
        }
        return "Invalid";
    }

    // getters for QuickChat
    public String getMessageID() {
        return messageID;
    }

    public String getMessageHash() {
        return messageHash;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getMessage() {
        return message;
    }

    public int getMessageNumber() {
        return messageNumber;
    }
        public void storeMessage() {
        try {
            java.io.FileWriter writer = new java.io.FileWriter("storedMessages.json", true);
            String json = "{\"MessageID\":\"" + messageID + "\",\"MessageHash\":\"" + messageHash + "\",\"Recipient\":\"" + recipient + "\",\"Message\":\"" + message + "\"},\n";
            writer.write(json);
            writer.close();
        } catch (Exception e) {
            System.out.println("Error storing message: " + e.getMessage());
        }
    }
}
