package ModulesJava.ATM;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OptionMenu extends Account {

    int selection;

    Scanner menuInput = new Scanner(System.in);
    //setting decimal format for bank money
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    //HashMap is used to store different types of data
    HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();

    /*
    Validate Login information, customer number and pin number
     */

    public void getLogin() throws IOException{
        int x = 1;

        do{
            try{
                //setting the key and value for the hashmap
                data.put(1039864, 1030);
                data.put(839789, 1228);

                System.out.println("---Welcome to the ATM Project!---");
                System.out.print("Enter your Account Number: ");
                setCustomerNumber(menuInput.nextInt());

                System.out.print("Enter your PIN: ");
                setPinNumber(menuInput.nextInt());
            }
            catch (Exception e){
                System.out.println("\n" + "Invalid Character(s). Only numbers are valid."+ "\n");
                x = 2;
            }

            for (Map.Entry<Integer, Integer> entry : data.entrySet()){
                if (entry.getKey() == getCustomerNumber() && entry.getValue() == getPinNumber()){
                    getAccountType();
                }
            }
            System.out.println("\n"+ "Wrong Customer Number or PIN."+ "\n");
        }   while (x == 1);
    }

    /*
    Display account type menu with selection
     */

    //Defining method for getAccountType
    public void getAccountType(){
        System.out.println("Select the Account you want to access: ");
        System.out.println("Enter 1 - Checking Account");
        System.out.println("Enter 2 - Saving Account");
        System.out.println("Enter 3 - Exit");
        System.out.println("Choice: ");

        selection = menuInput.nextInt();

        switch (selection){
            case 1:
                getChecking();
                break;
            case 2:
                getSaving();
                break;
            case 3:
                System.out.println("Thank you for using this ATM, goodbye!");
                break;
            default:
                System.out.println("\n"+ "Invalid Choice."+ "\n");
                getAccountType();
        }
    }

    /*
    Display Checking Account Menu with selections
     */

    //defining the method for getChecking
    public void getChecking(){
        System.out.println("Checking Account: ");
        System.out.println("Enter - 1 View Balance");
        System.out.println("Enter - 2 Withdraw Funds");
        System.out.println("Enter - 3 Deposit Funds");
        System.out.println("Enter - 4 Exit");
        System.out.println("Choice: ");

        selection = menuInput.nextInt();

        switch (selection){
            case 1:
                System.out.println("Checking Account Balance: " + moneyFormat.format(getCheckingBalance()));
                getAccountType();
                break;
            case 2:
                getCheckingWithdrawInput();
                getAccountType();
                break;
            case 3:
                getCheckingDepositInput();
                getAccountType();
                break;
            case 4:
                System.out.println("Thank you for using this ATM, goodbye!");
                break;

            default:
                System.out.println("\n"+ "Invalid Choice."+ "\n");
                getChecking();
        }
    }

    /*
    Displaying Saving Account Menu with selections
     */

    public void getSaving(){
        System.out.println("Savings Account: ");
        System.out.println("Enter - 1 View Balance");
        System.out.println("Enter - 2 Withdraw Funds");
        System.out.println("Enter - 3 Deposit Funds");
        System.out.println("Enter - 4 Exit");
        System.out.println("Choice: ");

        selection = menuInput.nextInt();

        switch (selection){
            case 1:
                System.out.println("Checking Account Balance: " + moneyFormat.format(getSavingBalance()));
                getAccountType();
                break;
            case 2:
                getSavingWithdrawInput();
                getAccountType();
                break;
            case 3:
                getSavingDepositInput();
                getAccountType();
                break;
            case 4:
                System.out.println("Thank you for using this ATM, goodbye!");
                break;

            default:
                System.out.println("\n"+ "Invalid Choice."+ "\n");
                getSaving();
        }
    }

}
