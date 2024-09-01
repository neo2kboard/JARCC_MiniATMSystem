package Olandria_ChristianOOP;

public class ATM {
    String type;
    double balance, rate;
    //create methods
    
    public void welcome(String n, int p){
        System.out.println("\nWelcome to JARCC!\nAccount Name: " + n);
        System.out.println("PIN Number: " + p);
        }
    
    public void TermsAndConditions(){
       System.out.print("Terms and Condtions!\n1. The system accepts two account types: "
               + "Savings and Checking Account.\n2. The system offers 5 transactions: "
               + "deposit, withdraw, transfer funds, change pin, and balance inquiry.\n3. The"
               + " system requires minimum deposit amount: 100 pesos for the savings or "
               + "checking account.\n4. The system requires minimum withdraw amount: 500"
               + " pesos for savings or checking account.\n" + "5. The system requires "
               + "minimum transfer amount: 1000 pesos for both savings and checking account.\n" 
               + "6. The system has annual interest rate: 0.03 for checking account and "
               + "2.00 for savings account.");
    }
    
    public void deposit(double depo){
         balance += depo;
    }
    
     public void withdraw(double with){
         balance -= with;
    }
    
    //getters 
     String getType(){ 
       return type;
     }
     
     double getBalance(){
       return balance;
     }
     
     double getRate(){
       return rate;
     }
     
     //setters
     public void setType(String theType){
        type = theType;
     }
     
     public void setBalance(double theBalance){
         balance = theBalance;
     }
     
     public void setRate(double theRate){
         rate = theRate;
     }   
}
