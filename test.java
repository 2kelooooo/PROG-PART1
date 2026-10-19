/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poepart1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Student
 */
public class test {


    // 1-6 RECIPIENT
    @Test
    public void testCheckRecipientValid() {
        System.out.println("Check Recipient - correctly formatted");
        String recipient = "+27821234567";
        Message instance = new Message();
        boolean expResult = true;
        boolean result = instance.checkRecipientCell(recipient);
        assertEquals(expResult, result);
    }

    @Test
    public void testCheckRecipientInvalidNoPlus() {
        System.out.println("Check Recipient - incorrectly formatted");
        String recipient = "0821234567";
        Message instance = new Message();
        boolean expResult = false;
        boolean result = instance.checkRecipientCell(recipient);
        assertEquals(expResult, result);
    }

    @Test
    public void testCheckRecipientInvalidTooLong() {
        System.out.println("Check Recipient - incorrectly formatted");
        String recipient = "+27821234567890";
        Message instance = new Message();
        boolean expResult = false;
        boolean result = instance.checkRecipientCell(recipient);
        assertEquals(expResult, result);
    }

    @Test
    public void testCheckRecipientValid2() {
        System.out.println("Check Recipient - correctly formatted");
        String recipient = "+27712345678";
        Message instance = new Message();
        boolean expResult = true;
        boolean result = instance.checkRecipientCell(recipient);
        assertEquals(expResult, result);
    }

    @Test
    public void testCheckRecipientInvalidNoCode() {
        System.out.println("Check Recipient - incorrectly formatted");
        String recipient = "27821234567";
        Message instance = new Message();
        boolean expResult = false;
        boolean result = instance.checkRecipientCell(recipient);
        assertEquals(expResult, result);
    }

    @Test
    public void testCheckRecipientInvalidLetters() {
        System.out.println("Check Recipient - incorrectly formatted");
        String recipient = "+27ABC45678";
        Message instance = new Message();
        boolean expResult = false;
        boolean result = instance.checkRecipientCell(recipient);
        assertEquals(expResult, result);
    }

    // 7-12 MESSAGE LENGTH
    @Test
    public void testMessageLengthValid() {
        System.out.println("Message length - correctly formatted");
        String message = "Hi Mike, can you join us for dinner tonight";
        Message instance = new Message();
        boolean expResult = true;
        boolean result = instance.checkMessageLength(message);
        assertEquals(expResult, result);
    }

    @Test
    public void testMessageLengthValid250() {
        System.out.println("Message length - correctly formatted");
        String message = "a".repeat(250);
        Message instance = new Message();
        boolean expResult = true;
        boolean result = instance.checkMessageLength(message);
        assertEquals(expResult, result);
    }

    @Test
    public void testMessageLengthValidShort() {
        System.out.println("Message length - correctly formatted");
        String message = "Hi";
        Message instance = new Message();
        boolean expResult = true;
        boolean result = instance.checkMessageLength(message);
        assertEquals(expResult, result);
    }

    @Test
    public void testMessageLengthInvalid251() {
        System.out.println("Message length - incorrectly formatted");
        String message = "a".repeat(251);
        Message instance = new Message();
        boolean expResult = false;
        boolean result = instance.checkMessageLength(message);
        assertEquals(expResult, result);
    }

    @Test
    public void testMessageLengthInvalid300() {
        System.out.println("Message length - incorrectly formatted");
        String message = "a".repeat(300);
        Message instance = new Message();
        boolean expResult = false;
        boolean result = instance.checkMessageLength(message);
        assertEquals(expResult, result);
    }

    @Test
    public void testMessageLengthInvalid500() {
        System.out.println("Message length - incorrectly formatted");
        String message = "a".repeat(500);
        Message instance = new Message();
        boolean expResult = false;
        boolean result = instance.checkMessageLength(message);
        assertEquals(expResult, result);
    }

    // 13-18 MESSAGE ID
    @Test
    public void testMessageIDLength() {
        System.out.println("Message ID - length check");
        Message instance = new Message();
        String result = instance.createMessageID();
        boolean expResult = true;
        assertEquals(expResult, result.length() == 10);
    }

    @Test
    public void testMessageIDNotNull() {
        System.out.println("Message ID - not null");
        Message instance = new Message();
        String result = instance.createMessageID();
        assertNotNull(result);
    }

    @Test
    public void testMessageIDNumeric() {
        System.out.println("Message ID - numeric");
        Message instance = new Message();
        String result = instance.createMessageID();
        boolean expResult = true;
        assertEquals(expResult, result.matches("\\d+"));
    }

    @Test
    public void testMessageIDUnique() {
        System.out.println("Message ID - unique");
        Message instance = new Message();
        String id1 = instance.createMessageID();
        String id2 = instance.createMessageID();
        boolean expResult = false;
        boolean result = id1.equals(id2);
        assertEquals(expResult, result);
    }

    @Test
    public void testMessageIDNot11() {
        System.out.println("Message ID - not 11");
        Message instance = new Message();
        String result = instance.createMessageID();
        assertNotEquals(11, result.length());
    }

    @Test
    public void testMessageIDNot9() {
        System.out.println("Message ID - not 9");
        Message instance = new Message();
        String result = instance.createMessageID();
        assertNotEquals(9, result.length());
    }

    
    @Test
    public void testMessageHashNotNull() {
        System.out.println("Message Hash - not null");
        Message instance = new Message();
        String id = instance.createMessageID();
        String result = instance.createMessageHash(id, 0, "Hi Mike");
        assertNotNull(result);
    }

    @Test
    public void testMessageHashContainsColon() {
        System.out.println("Message Hash - contains colon");
        Message instance = new Message();
        String id = instance.createMessageID();
        String result = instance.createMessageHash(id, 1, "Hello World");
        assertTrue(result.contains(":"));
    }

    @Test
    public void testMessageHashFormat() {
        System.out.println("Message Hash - format check");
        Message instance = new Message();
        String id = "0012345678";
        String result = instance.createMessageHash(id, 0, "Hi Mike");
        boolean expResult = true;
        assertEquals(expResult, result.contains("HI") && result.contains("MIKE"));
    }

    @Test
    public void testMessageHashUppercase() {
        System.out.println("Message Hash - uppercase");
        Message instance = new Message();
        String id = "0012345678";
        String result = instance.createMessageHash(id, 0, "Hi Mike");
        assertEquals(result.toUpperCase(), result);
    }

    // 23-26 SENT MESSAGE
    @Test
    public void testSentMessageSent() {
        System.out.println("Sent Message - sent");
        Message instance = new Message();
        String expResult = "Message successfully sent.";
        String result = instance.sentMessage(1);
        assertEquals(expResult, result);
    }

    @Test
    public void testSentMessageDisregard() {
        System.out.println("Sent Message - disregard");
        Message instance = new Message();
        String expResult = "Press 0 to delete message.";
        String result = instance.sentMessage(2);
        assertEquals(expResult, result);
    }

    @Test
    public void testSentMessageStored() {
        System.out.println("Sent Message - stored");
        Message instance = new Message();
        String expResult = "Message successfully stored.";
        String result = instance.sentMessage(3);
        assertEquals(expResult, result);
    }

    @Test
    public void testSentMessageInvalid() {
        System.out.println("Sent Message - invalid");
        Message instance = new Message();
        String expResult = "Invalid";
        String result = instance.sentMessage(99);
        assertEquals(expResult, result);
    }
}

