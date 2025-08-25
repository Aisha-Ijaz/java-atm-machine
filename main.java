import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int pin = 1234;
        boolean isAuthenticated = false;
        int balance = 20000;
        int enteredpin, option, amountwithdraw, amountTransfer;
        int totalwithdraw =0, totalamountTransfer =0;
        int attempts = 1;

        do{
            System.out.print("Enter Your 4 Digit pin: ");
            enteredpin = sc.nextInt();
            if(enteredpin == pin){
                isAuthenticated = true;
                System.out.println("Login Successfully! Welcome to ATM Machine");
                break;
            }else {
                attempts++;
                System.out.println("Incorrect Pin!");
            }
        }while(attempts <= 3);

        if(!isAuthenticated){
            System.out.println("Account Blocked! Please visit to the nearest branch.");
            return;
        }

        do{
            System.out.println("1. Balance check");
            System.out.println("2. Withdraw");
            System.out.println("3. Transfer");
            System.out.println("4. Mini statement");
            System.out.println("5. Exit");
            System.out.println("Please select an option: ");
            option = sc.nextInt();

            switch(option){
                case 1:
                    System.out.println("Your Balance is: "+ balance);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw:");
                    amountwithdraw = sc.nextInt();
                    if(amountwithdraw <= balance){
                        balance -= amountwithdraw;
                        totalwithdraw += amountwithdraw;
                        System.out.println("Amount "+ amountwithdraw + " Withdraw Successfully from your account!");
                        System.out.println("Your current balance is: "+ balance);
                    }else {
                        System.out.println("Insufficient Balance");
                    }
                    break;
                case 3:
                    System.out.print("Enter your amount to transfer: ");
                    amountTransfer = sc.nextInt();
                    if(amountTransfer <= balance){
                        balance -= amountTransfer;
                        totalamountTransfer += amountTransfer;
                        System.out.println("Amount "+ amountTransfer + "Transfer Successfully!");
                        System.out.println("Your current balance is: "+ balance);
                    }else {
                        System.out.println("Insufficient Balance!");
                    }
                    break;
                case 4:
                    System.out.println("Mini statement: ");
                    System.out.println("Total Withdrawn: " + totalwithdraw);
                    System.out.println("Total Amount transferred : " + totalamountTransfer);
                    System.out.println("Remaining balance: "+ balance);
                  break;
                case 5:
                    System.out.println("Thank you for using ATM machine!");
                    break;
                default:
                    System.out.println("Invalid Option!");
            }
        }while(option != 5);


    }
}
