import java.util.Scanner;

public class MainMenu {
    private Scanner input = new Scanner(System.in);

    public MainMenu() {
        System.out.println("Main menu initialized.");
    }

    public void showCredits() {
        System.out.println("Created by:");
        System.out.println("- ducky.rip");
        System.out.println("- waterslinky");
        System.out.println("Press any button to return to the main menu...");
        input.nextLine();
        input.nextLine();
    }

    public void handleMenuChoice(int choice) {
        switch (choice) {
            case 1:
                System.out.println("Starting game...");
                // Need game start logic here
                break;
            case 2:
                System.out.println("Opening options...");
                System.out.println("Options are not implemented yet.");
                System.out.println("Press any button to return to the main menu...");
                input.nextLine();
                input.nextLine();
                displayMenu();
                break;
            case 3:
                System.out.println("Showing credits...");
                showCredits();
                displayMenu();
                break;
            case 4:
                System.out.println("Exiting...");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                displayMenu();
                break;
        }
    }

    public void displayMenu() {
        System.out.println("1. Start Game");
        System.out.println("2. Options");
        System.out.println("3. Credits");
        System.out.println("4. Exit");
        System.out.print("Please select an option: ");
        int choice = input.nextInt();
        handleMenuChoice(choice);
    }
}