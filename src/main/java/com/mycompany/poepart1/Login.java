/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poepart1;

/**
 *
 * @author DELL
 */
public class Login {
  //these attributes are going to be used to store details
    String userName;
    String password;
    String cellPhoneNumber;
    String Name;
    String Surname;
    private String storedUserName;
    private String storedPassword;
    private boolean isLoggedIn=false;

   public Login(){

   }
    
    // this constructor sets first  and last name when object is created
    public Login(String Name ,String Surname){
        this.Name=Name;
        this.Surname=Surname;
    }
    //checks if username has underscore and is less or equals to 5 characters
    public boolean checkUserName(String username){
        return username.contains("_")&& username.length() <=5;
         
    }
    //this checks if the password has a capital letter, special character etc
    public boolean checkPasswordComplexity(String password){
        // checks length
if(password.length() < 8){
            return  false;
        }
        boolean HasCapitalLetter=false;
        boolean HasNumber=false;
        boolean hasSpecial=false;
        
        // loop through each character in password to check type
        for(int i=0; i<password.length(); i++){
            char c=password.charAt (i);
            if (Character.isUpperCase(c)){
                HasCapitalLetter=true;
            }
            if(Character.isDigit(c)){
                HasNumber=true;
  }
            // checks if character is special
            if (!Character.isLetterOrDigit(c)){
                hasSpecial=true;
        }
      }
        // return true only if all 3 conditions are met
        if(HasCapitalLetter && HasNumber && hasSpecial &&password.length()>=8){
            return true;
        }else{
               return false;
}
    }
    //checks cellphone number format using Regex - must be an South African number with international code
       public boolean checkCellPhoneNumber(String PhoneNumber){
               return PhoneNumber.startsWith("+27")&&PhoneNumber.length()<=13;
}

           
       //method used to register user and check all validations
       
        public String registerUser(String Username ,String password,String PhoneNumber){
            
            if (!checkUserName(Username) ){
                return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.";
            }
            // check password
            if(!checkPasswordComplexity(password)){
                return "Password is not correctly formatted, please ensure that the password contains at least eight characters, a capital letter, a number and a special character.";
            }
            if (!checkCellPhoneNumber(PhoneNumber)){
                return "Cell phone number is incorrectly formatted or does not contain an international code, please correct the number and try again.";
            }
                   this.userName=Username ;
                   this.password=password;
                   this.cellPhoneNumber=PhoneNumber;
                       String displayName = (Name != null && Surname != null) ? Name + " " + Surname : Username;
                                 return "Welcome " + displayName + " it is great to see you.";               
            }
//method used to check login and used to compare with saved
                public boolean loginUser(String username, String password){
        if(this.userName == null) return false;
        // must check BOTH with &&
        return this.userName.equals(username) && this.password.equals(password);
    }

    public String returnLoginStatus(String username, String password){
       
        if(loginUser(username, password)){
            String displayName = (Name != null && Surname != null) ? Name + " " + Surname : username;
            return "Welcome " + displayName + " it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
            }
            
                    
   

