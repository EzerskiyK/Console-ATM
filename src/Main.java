
import services.AtmService;
import java.util.Scanner;


public class Main {
    public static void main(String[] args){
        try(Scanner scanner = new Scanner(System.in)) {

            AtmService atmService = new AtmService(scanner);

            System.out.println("============== ATM ==============");
            System.out.println("Hello, enter your card number");
            System.out.println("The card number must be of the form: XXXX-XXX-XXX-XXX\n");

            atmService.checkValidCardNumber();

            System.out.println("Enter the pin code");

            atmService.checkPin();

            int option;
            boolean exit = false;

            while (!exit) {
                printMenu();
                try {
                    option = scanner.nextInt();
                    switch (option) {
                        case 1:
                            atmService.checkBalanceOfCard();
                            break;
                        case 2:
                            atmService.withdrawFromCard();
                            break;
                        case 3:
                            atmService.topUpTheCard();
                            break;
                        case 4:
                            exit = true;
                            System.out.println("Exiting...");
                            break;
                        default:
                            System.out.println("Invalid option. Please try again.");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.next();
                }
            }
        }
    }
    private static void printMenu() {
        System.out.println("\n============== Menu ==============\n");
        System.out.println("Enter an option\n");
        System.out.println("1. Check Balance");
        System.out.println("2. Withdrawal");
        System.out.println("3. Top up");
        System.out.println("4. Exit\n");
    }
}