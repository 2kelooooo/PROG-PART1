/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.poepart1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author DELL
 */
public class LoginTest {
    
 public LoginTest() {
     
    }

    // 1. Username  is good it has _ and <=5 chars
    @Test
    public void testCheckUserNameValid() {
        System.out.println("checkUserName - correctly formatted");
        String userName = "kyl_1";
        Login instance = new Login();
        boolean expResult = true;
        boolean result = instance.checkUserName(userName);
        assertEquals(true, result);
    }

    // 2. Username  is bad it has no underscore
    @Test
    public void testCheckUserNameInvalid() {
        System.out.println("checkUserName - incorrectly formatted");
        String userName = "kyle!!!!!!!";
        Login instance = new Login();
        boolean expResult = false;
        boolean result = instance.checkUserName(userName);
        assertEquals(false, result);
    }

    //  good - meets all rules
    @Test
    public void testCheckPasswordComplexityValid() {
        System.out.println("checkPasswordComplexity - correctly formatted");
        String password = "Ch&&sec@ke99!";
        Login instance = new Login();
        boolean expResult = true;
        boolean result = instance.checkPasswordComplexity(password);
        assertEquals(true, result);
    }

    // bad , does not meet rules
    @Test
    public void testCheckPasswordComplexityInvalid() {
        System.out.println("checkPasswordComplexity - incorrectly formatted");
        String password = "password";
        Login instance = new Login();
        boolean expResult = false;
        boolean result = instance.checkPasswordComplexity(password);
        assertEquals(false, result);
    }

    //  good - +27 and correct length
    @Test
    public void testCheckCellPhoneNumberValid() {
        System.out.println("checkCellPhoneNumber - correctly formatted");
        String cellNumber = "+27838968976";
        Login instance = new Login();
        boolean expResult = true;
        boolean result = instance.checkCellPhoneNumber(cellNumber);
        assertEquals(true, result);
    }

    // no international code
    @Test
    public void testCheckCellPhoneNumberInvalid() {
        System.out.println("checkCellPhoneNumber - incorrectly formatted");
        String cellNumber = "08966553";
        Login instance = new Login();
        boolean expResult = false;
        boolean result = instance.checkCellPhoneNumber(cellNumber);
        assertEquals(false, result);
    }

    // 7. Register - username correct message
    @Test
    public void testRegisterUserSuccess() {
        System.out.println("registerUser - successful");
        String userName = "kyl_1";
        String password = "Ch&&sec@ke99!";
        String cellNumber = "+27838968976";
        Login instance = new Login();
        String expResult = "Welcome kyl_1 it is great to see you.";
        String result = instance.registerUser(userName, password, cellNumber);
        assertEquals(true, result);
    }

    // 8. Login - correct username and password
    @Test
    public void testLoginUserSuccessful() {
        System.out.println("loginUser - successful login");
        Login instance = new Login();
        instance.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976");
        boolean expResult = true;
        boolean result = instance.loginUser("kyl_1", "Ch&&sec@ke99!");
        assertEquals(true, result);
    }

    // 9. Login - wrong password
    @Test
    public void testLoginUserFailed() {
        System.out.println("loginUser - failed login");
        Login instance = new Login();
        instance.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976");
        boolean expResult = false;
        boolean result = instance.loginUser("kyl_1", "wrongpass");
        assertEquals(false, result);
    }

    //  Return status - welcome back message
    @Test
    public void testReturnLoginStatusSuccessful() {
        System.out.println("returnLoginStatus - successful");
        Login instance = new Login();
        instance.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976");
        instance.loginUser("kyl_1", "Ch&&sec@ke99!");
        String expResult = "Welcome kyl_1 it is great to see you again.";
        String result = instance.returnLoginStatus("kyl_1" , "Ch&&sec@ke99!");
        assertEquals(true, result);
    }

    //  Return status - failed message
    @Test
    public void testReturnLoginStatusFailed() {
        System.out.println("returnLoginStatus - failed");
        Login instance = new Login();
        instance.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976");
        instance.loginUser("kyl_1", "wrongpass");
        String expResult = "Username or password incorrect, please try again.";
        String result = instance.returnLoginStatus("kyl_1", "wrong password");
        assertEquals(false, result);
    }
         //  Register - username incorrectly formatted
    @Test
    public void testRegisterUserUsernameIncorrect() {
        System.out.println("registerUser - username incorrectly formatted");
        String userName = "kyle!!!!!!!";
        String password = "Ch&&sec@ke99!";
        String cellNumber = "+27838968976";
        Login instance = new Login();
        String expResult = "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.";
        String result = instance.registerUser(userName, password, cellNumber);
        assertEquals(false, result);
    }

    //   password does not meet complexity
    @Test
    public void testRegisterUserPasswordIncorrect() {
        System.out.println("registerUser - password does not meet complexity");
        String userName = "kyl_1";
        String password = "password";
        String cellNumber = "+27838968976";
        Login instance = new Login();
        String expResult = "Password is not correctly formatted, please ensure that the password contains at least eight characters, a capital letter, a number and a special character.";
        String result = instance.registerUser(userName, password, cellNumber);
        assertEquals(false, result);
    }

    //   cell number incorrectly formatted
    @Test
    public void testRegisterUserCellIncorrect() {
        System.out.println("registerUser - cell number incorrectly formatted");
        String userName = "kyl_1";
        String password = "Ch&&sec@ke99!";
        String cellNumber = "08966555230";
        Login instance = new Login();
        String expResult = "Cell phone number is incorrectly formatted or does not contain an international code, please correct the number and try again.";
        String result = instance.registerUser(userName, password, cellNumber);
        assertEquals(false, result);
    }
}

        
   
    

