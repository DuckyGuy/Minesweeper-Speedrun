import java.util.Scanner;
public class Main {


    public static void main(String[] args) {
        // System.out.println("Entering main menu...");
        // MainMenu menu = new MainMenu();
        // menu.displayMenu();
        Scanner in=new Scanner(System.in);

        int X=in.nextInt();
        int Y=in.nextInt();
        in.nextLine();

        Game g=new Game(10, 20, X, Y);
    }
}