/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poepart1;
 import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


/**
 *
 * @author Student
 */

public class MessageManager {

    public String[] messageIDs = {"1234567890", "2345678901", "3456789012", "0838884567", "4567890123"};
    public String[] recipients = {"+27834557896", "+27838884567", "+27834484567", "0838884567", "+27838884567"};
    public String[] messages = {"Did you get the cake?", "Where are you? You are late! I have asked you to be on time.", "Yohoooo, I am at your gate.", "It is dinner time!", "Ok, I am leaving without you."};
    public String[] flags = {"Sent", "Stored", "Disregard", "Sent", "Stored"};
    public String[] messageHashes;

    public static ArrayList<String> sentMessages = new ArrayList<>();
    public static ArrayList<String> disregardedMessages = new ArrayList<>();
    public static ArrayList<String> storedMessages = new ArrayList<>();

    public MessageManager() {
        sentMessages.clear();
        disregardedMessages.clear();
        storedMessages.clear();
        messageHashes = new String[5];
        for (int i = 0; i < 5; i++) {
            messageHashes[i] = createMessageHash(i);
            if (flags[i].equals("Sent")) sentMessages.add(messages[i]);
            if (flags[i].equals("Disregard")) disregardedMessages.add(messages[i]);
            if (flags[i].equals("Stored")) storedMessages.add(messages[i]);
        }
    }

    public String createMessageHash(int i) {
        String[] words = messages[i].split(" ");
        String first = words[0].toUpperCase();
        String last = words[words.length - 1].toUpperCase().replaceAll("[^A-Z]", "");
        return messageIDs[i].substring(0, 2) + ":" + (i + 1) + ":" + first + last;
    }

    public String displayStoredSendersRecipients() {
        String out = "=== STORED MESSAGES ===\n";
        for (int i = 0; i < 5; i++) {
            if (flags[i].equals("Stored")) {
                out += "Sender: " + recipients[i] + " | Recipient: " + recipients[i] + " | Message: " + messages[i] + "\n";
            }
        }
        System.out.print(out);
        return out;
    }

    public String getLongestMessage() {
        int index = 0;
        for (int i = 1; i < messages.length; i++) {
            if (messages[i].length() > messages[index].length()) index = i;
        }
        return messages[index];
    }

    public void displayLongestMessage() {
        System.out.println("Longest Message: " + getLongestMessage());
    }

    public String searchByMessageID(String id) {
        for (int i = 0; i < 5; i++) {
            if (messageIDs[i].equals(id)) return "Recipient: " + recipients[i] + " | Message: " + messages[i];
        }
        return "Message ID not found.";
    }

    public String searchByRecipient(String recipient) {
        String out = "";
        for (int i = 0; i < 5; i++) {
            if (recipients[i].equals(recipient)) {
                out += messages[i] + "\n";
            }
        }
        if (out.isEmpty()) return "Recipient not found.";
        return out.trim();
    }

    public String deleteMessageByHash(String hash) {
        for (int i = 0; i < 5; i++) {
            if (messageHashes[i].equals(hash)) {
                String msg = messages[i];
                messages[i] = "";
                String result = "Message: \"" + msg + "\" successfully deleted.";
                System.out.println(result);
                return result;
            }
        }
        return "Message not found.";
    }

    public String displayReport() {
        String out = "=== REPORT - STORED MESSAGES ===\n";
        for (int i = 0; i < 5; i++) {
            if (flags[i].equals("Stored")) {
                out += "Message Hash: " + messageHashes[i] + " | Recipient: " + recipients[i] + " | Message: " + messages[i] + "\n";
            }
        }
        out += "=== REPORT - ALL SENT MESSAGES ===\n";
        for (int i = 0; i < 5; i++) {
            if (flags[i].equals("Sent")) {
                out += "Message Hash: " + messageHashes[i] + " | Recipient: " + recipients[i] + " | Message: " + messages[i] + "\n";
            }
        }
        System.out.print(out);
        return out;
    }

    public void displaySentMessages() {
        System.out.println("=== SENT MESSAGES ===");
        for (String m : sentMessages) System.out.println(m);
    }

    public void saveStoredMessagesToJson() {
        try {
            FileWriter writer = new FileWriter("storedMessages.json");
            writer.write("[\n");
            for (int i = 0; i < storedMessages.size(); i++) {
                writer.write("  \"" + storedMessages.get(i).replace("\"", "\\\"") + "\"");
                if (i < storedMessages.size() - 1) writer.write(",");
                writer.write("\n");
            }
            writer.write("]");
            writer.close();
            System.out.println("SAVED! TOTAL STORED: " + storedMessages.size());
        } catch (IOException e) {
            System.out.println("Save failed: " + e.getMessage());
        }
    }

    public void loadStoredMessagesFromJson() {
        try {
            File file = new File("storedMessages.json");
            if (!file.exists()) {
                System.out.println("No stored file found.");
                return;
            }
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            storedMessages.clear();
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.startsWith("\"")) {
                    line = line.replace(",", "").trim();
                    line = line.substring(1, line.length() - 1);
                    storedMessages.add(line);
                }
            }
            reader.close();
            System.out.println("LOADED! TOTAL STORED: " + storedMessages.size());
            for (String m : storedMessages) System.out.println(m);
        } catch (Exception e) {
            System.out.println("Load failed: " + e.getMessage());
        }
    }
}
 
