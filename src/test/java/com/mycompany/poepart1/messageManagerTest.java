package com.mycompany.poepart1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Student
 */


public class messageManagerTest {

    MessageManager mm = new MessageManager();

    @Test
    public void testSentMessagesArrayCorrectlyPopulated() {
        assertEquals("Did you get the cake?", MessageManager.sentMessages.get(0));
        assertEquals("It is dinner time!", MessageManager.sentMessages.get(1));
        assertEquals(2, MessageManager.sentMessages.size());
    }

    @Test
    public void testDisplayLongestMessage() {
        assertEquals("Where are you? You are late! I have asked you to be on time.", mm.getLongestMessage());
    }

    @Test
    public void testSearchForMessageID() {
        String result = mm.searchByMessageID("0838884567");
        assertTrue(result.contains("It is dinner time!"));
    }

    @Test
    public void testSearchForRecipient() {
        String result = mm.searchByRecipient("+27838884567");
        assertTrue(result.contains("Where are you? You are late! I have asked you to be on time."));
        assertTrue(result.contains("Ok, I am leaving without you."));
    }

    @Test
    public void testDeleteMessageUsingHash() {
        String hash = mm.messageHashes[1];
        String result = mm.deleteMessageByHash(hash);
        assertEquals("Message: \"Where are you? You are late! I have asked you to be on time.\" successfully deleted.", result);
    }

    @Test
    public void testDisplayReport() {
        String report = mm.displayReport();
        assertTrue(report.contains("Message Hash"));
        assertTrue(report.contains("Recipient"));
        assertTrue(report.contains("Message"));
    }

    @Test
    public void testStoredMessages() {
        assertEquals(2, MessageManager.storedMessages.size());
    }

    @Test
    public void testDisregardedMessages() {
        assertEquals(1, MessageManager.disregardedMessages.size());
        assertEquals("Yohoooo, I am at your gate.", MessageManager.disregardedMessages.get(0));
    }
}