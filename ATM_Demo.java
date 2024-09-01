package Olandria_ChristianOOP;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;



public class ATM_Demo {
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        
        String name;
        int pin;
        double deposit, withdraw;
        double balance = 0;
        
        ATM obj1 = new ATM();
        Welcome_Figures obj2 = new Welcome_Figures();

        System.out.println("\t\t\t\t\t  WELCOME TO\n");
        
        obj2.JARCC();
        System.out.print("\n");
        //asks user for name and pin
        System.out.print("\nEnter your name: ");
        name = sc.nextLine();
        
        System.out.print("Enter your pin number(4-digits only!): ");
        pin = sc.nextInt();
        
        System.out.println("Would you like to read the terms and conditions?"
                + "\nPress 1 to continue and Press 0 to disregard the conditions");
        int read = sc.nextInt();
           
            if(read==1){
              obj1.TermsAndConditions(); //terms and conditions method
            }
            else if(read==0){
            }
       
        System.out.println("");
        obj1.welcome(name, pin); //welcome method

        //object creation and instantiation for checking account
        ATM checking = new ATM();
        checking.setType("Checking");
        checking.setBalance(0.00);
        checking.setRate(0.03);
        
        //object creation and instantiation for savings account
        ATM savings = new ATM();
        savings.setType("Savings");
        savings.setBalance(0.00);
        savings.setRate(2.00);
        
        boolean transaction = true;
        
        while(transaction){
        
        
        System.out.print("\nWelcome Mr/Ms. " + name + "!\nPlease Choose a Transaction: \n"
                + "1. Deposit\n"
                + "2. Withdraw\n"
                + "3. Transfer Funds\n"
                + "4. Change Pin\n"
                + "5. Balance Inquiry\n"
                + "6. Exit\n\n"
                + "Enter an option: ");
        
        int option = sc.nextInt();
        
            switch(option){
              
                case 1:
                  System.out.print("[1]-Savings\n[2]-Checking\nChoose an account: ");
                  int chooseDeposit = sc.nextInt();
                  
                  if(chooseDeposit == 1){
                    System.out.println("Savings Balance: " + (savings.getBalance()) + "\n");
                    System.out.print("Enter Deposit Amount(Minimum is 100): ");
                     deposit = sc.nextDouble();
                     
                     if(deposit>=100){
                      System.out.println("Deposit Successful!");
                      savings.deposit(deposit);
                      System.out.println("Current Savings Balance: " + (savings.getBalance()) + "\n");
                     }
                     else{
                      System.out.println("Deposit Unsuccessful!\nMinimum Deposit Amount is 100!");
                    }  
                  }
                  
                  else if(chooseDeposit == 2){
                   System.out.println("Checking Balance: " + (checking.getBalance()) + "\n");
                   System.out.print("Enter Deposit Amount(Minimum is 100): ");
                    deposit = sc.nextDouble();
                    
                    if(deposit>=100){
                      System.out.println("Deposit Successful!");
                      checking.deposit(deposit);
                      System.out.println("Current Checking Balance: " + (checking.getBalance()) + "\n");
                     }
                     else{
                      System.out.println("Deposit Unsuccessful!\nMinimum Deposit Amount is 100!");
                    }   
                  }
                  
                  break;
                  
                case 2: 
                    System.out.print("[1]-Savings\n[2]-Checking\nChoose an account: ");
                    int chooseWithdraw = sc.nextInt();
                    
                    if(chooseWithdraw == 1){
                     System.out.println("Savings Balance: " + (savings.getBalance()) + "\n");
                     System.out.print("Enter Withdraw Amount(Minimum is 500): ");
                     withdraw = sc.nextDouble();
                     balance = savings.getBalance();
                       
                        if(withdraw>=500 && withdraw<=balance){
                          System.out.println("Withdraw Successful!");
                          savings.withdraw(withdraw);
                          System.out.println("Current Savings Balance: " + (savings.getBalance()) + "\n");
                        }
                        else if(withdraw<500){
                          System.out.println("Withdraw Unsuccessful!\nMinimum Withdrawal is 500!"); 
                        }
                        else if(withdraw>balance){
                          System.out.println("Withdraw Unsuccessful!\nInsufficient Balance!");
                        }
                    }
                    
                    else if(chooseWithdraw == 2){
                     System.out.println("Checking Balance: " + (checking.getBalance()) + "\n");
                     System.out.print("Enter Withdraw Amount(Minimum is 500): ");
                     withdraw = sc.nextDouble();
                     balance = checking.getBalance();
                     
                        if(withdraw>=500 && withdraw<=balance){
                          System.out.println("Withdraw Successful!");
                          checking.withdraw(withdraw);
                          System.out.println("Current Checking Balance: " + (checking.getBalance()) + "\n");
                        }
                        else if(withdraw<500){
                          System.out.println("Withdraw Unsuccessful!\nMinimum Withdrawal is 500!"); 
                        }
                        else if(withdraw>balance){
                          System.out.println("Withdraw Unsuccessful!\nInsufficient Balance!");
                        }
                    }
                    
                    break;
                
                case 3:
                    System.out.print("[1]-Savings\n[2]-Checking\nChoose an account to transfer "
                            + "money from to another account: ");
                    int chooseTransfer = sc.nextInt();
                    
                    if(chooseTransfer == 1){
                      System.out.println("Savings Balance: " + (savings.getBalance()) + "\n");
                      System.out.print("Enter amount to transfer from Savings to Checking"
                              + " (Minimum is 1000): ");
                      double transferAmount = sc.nextDouble();
                      balance = savings.getBalance();
                      
                      if(transferAmount>balance){
                         System.out.println("Unsuccessfully Transferred!\nInsufficient Balance!"); 
                      }
                      else if(transferAmount<1000){
                         System.out.println("Unsuccessfully Transferred!\nMinimum Transfer Amount"
                                 + " is 1000!");
                      }
                      else {
                      savings.withdraw(transferAmount);
                      checking.deposit(transferAmount);
                      
                      System.out.println("Successfully Transferred " + transferAmount +
                              " from Savings to Checking!");
                      System.out.println("Savings Balance: " + savings.getBalance());
                      System.out.println("Checking Balance: " + checking.getBalance());
                      } 
                  } 
                    else if(chooseTransfer == 2){
                      System.out.println("Checking Balance: " + (checking.getBalance()) + "\n");
                      System.out.print("Enter amount to transfer from Checking to Savings"
                              + " (Minimum is 1000): ");
                      double transferAmount = sc.nextDouble();
                      balance = checking.getBalance();
                      
                      if(transferAmount>balance){
                         System.out.println("Unsuccessfully Transferred!\nInsufficient Balance!"); 
                      }
                      else if(transferAmount<1000){
                         System.out.println("Unsuccessfully Transferred!\nMinimum Transfer Amount"
                                 + " is 1000!");
                      } 
                      else {
                      checking.withdraw(transferAmount);
                      savings.deposit(transferAmount);
                      
                      System.out.println("Successfully Transferred " + transferAmount +
                              " from Checking to Savings!");
                      System.out.println("Savings Balance: " + savings.getBalance());
                      System.out.println("Checking Balance: " + checking.getBalance());
                      }
                    }
                    
                    break;
                    
                case 4:
                    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                    int newpin=0;
                    int checkpin;
                    
                    System.out.println("Enter previous Pin to change new pin!");
                    //check the recent pin
                    System.out.print("Enter Previous Pin: ");
                    checkpin = sc.nextInt();
                    
                    while(pin!=checkpin){
                    try{
                      System.out.print("Wrong Previous Pin! Try Again: ");
                      checkpin = sc.nextInt(); 
                    }
                    catch(Exception e){
                     System.out.println("\n");
                    }
                  }
                    System.out.println("\nConfirmation of Previous Pin Successful!");
                    
                    //enter new pin
                    boolean validate = false;
       
                    while(!validate){
                    try{
                     System.out.print("Enter New Pin(4-digits only!): ");
                     newpin = Integer.parseInt(reader.readLine());
                     validate = true;
                     
                    }
                    catch(Exception e){
                     System.out.println("Please input a valid pin number!");
                    }
                  }
                    System.out.println("\nNew Pin: " + newpin);
                    break;
  
                case 5:

                    System.out.println(savings.getType() + " Balance: " 
                            + savings.getBalance());
                    System.out.println(checking.getType() + " Balance: " 
                            + checking.getBalance());
                    System.out.println(savings.getType() + " Annual Interest Rate: " 
                            + savings.getRate());
                    System.out.println(checking.getType() + " Annual Interest Rate: " 
                            + checking.getRate());
                    break;
                
                case 6:
                    transaction = false;
                    break;
            }
        }
            System.out.println("\nThank you for banking to JARCC. "
                    + "Till next time!");
  }
}