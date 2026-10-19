
## Student Information
- Module: Programming 1A (PROG5121)
- Project: QuickChat Messaging Application

## Project Description
QuickChat is a Java console application that allows users to register, login, and send messages. It validates usernames, passwords, cellphone numbers and message recipients according to business rules and stores messages in JSON format.

## Features Implemented

### Part 1 - Registration & Login
- `checkUserName()` - username must contain underscore and be <=5 chars
- `checkPasswordComplexity()` - min 8 chars, capital letter, number, special character
- `checkCellPhoneNumber()` - must start with +27 and be correct length
- `registerUser()` and `loginUser()` with return messages

### Part 2 - Messaging (100% Passing)
- `checkRecipientCell()` - validates recipient using regex `^\+\d{9,12}$` (only + and digits, 10-13 chars)
- `checkMessageID()` - generates 10-digit random ID
- `createMessageHash()` - creates hash from ID and message content
- `sendMessage()`, `printMessages()`, `storeMessage()` - full messaging logic
- `storedMessages.json` - JSON storage for sent messages
- JUnit tests - 26/26 tests passing

## How to Run
1. Open project in NetBeans / IntelliJ / VS Code
2. Run `QuickChat.java` or `Login.java`
3. Follow prompts: Register -> Login -> Send Message
4. Choose: Send, Show recent, Quit

## How to Run Unit Tests
Right-click `MessageTest.java` -> Run File
OR in NetBeans: Test -> Test Project

Expected: Tests run: 26, Failures: 0, Errors: 0

## Project Structure
