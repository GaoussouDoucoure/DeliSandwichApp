import java.util.Scanner;

interface Screens {
    static void homeScreen(){}
    static void orderScreen(){}
}
public class UserInterface implements Screens {
    public static Scanner sc = new Scanner(System.in);

    public static void homeScreen(){
        System.out.println("""
                ******************************************************
                ***** WELCOME TO YOUR BEST SANDWICH SHOP IN TOWN *****
                ******************************************************
                
                Please select an option to proceed
                [1] New Order
                [2] Exit
                """);
        System.out.print("Select an option: ");
        String choice = sc.nextLine().trim();

        switch (choice){
            case "1" -> orderScreen();
            case "2" -> System.out.println("\nThank you for visiting our shop. See you next time :)");
            default -> {
                System.out.printf("\nYou entered an invalid option: %s. Please try again!\n\n", choice);
                homeScreen();
            }
        }
    }

    public static void orderScreen(){
        System.out.println("""
                Please select an option to proceed:
                [1] Add Custom Sandwich
                [2] Add Signature Sandwich
                [3] Add Drink
                [4] Add Chips
                [5] Checkout
                [0] Cancel Order
                """);
        System.out.print("Enter an option to proceed: ");
        String choice = sc.nextLine().trim();

        switch (choice){
            case "1" -> System.out.println("addCustomSandwich method");//todo addSandwich()
            case "2" -> System.out.println("addSignatureSandwich method");//todo addSignatureSandwich()
            case "3" -> System.out.println("addDrink method");//todo addDrink()
            case "4" -> System.out.println("addChips method");//todo addChips()
            case "5" -> System.out.println("addCheckout method");//todo checkout()
            case "0" -> {
                System.out.println("\nclear the cart and go back to Home Screen\n");
                homeScreen();
            }//todo addSandwich()
            default -> {
                System.out.printf("\nYou entered an invalid option: %s. Please try again!\n\n", choice);
                orderScreen();
            }
        }
    }

    public static void addCustomSandwich(){
        Sandwich sandwich = new Sandwich();
        System.out.println("""
                Please choose your sandwich size:
                
                [1] Small/4 Inch — ($5.50)
                [2] Medium/8 Inch — ($5.50)
                [3] Large/12 Inch — ($5.50)
                """);
        System.out.print("Select your sandwich size (1, 2, or 3): ");
        String choice = sc.nextLine().trim();
        String size = "";

        switch (choice){
            case "1" -> size = "SMALL";
            case "2" -> size = "MEDIUM";
            case "3" -> size = "LARGE";
            default -> {
                System.out.printf("\nYou entered an invalid option: %s. Please try again!\n\n", choice);
                addCustomSandwich();
            }
        }
    }

    public static void addSignatureSandwich(){
        Sandwich signatureSandwich = new Sandwich();
        System.out.println("""
                We have some signature sandwich made right just for you :)
                Please choose one to proceed:
                
                [1] BLT Sandwich
                [2] Philly Cheese Steak
                """);
        System.out.print("Select a signature sandwich: ");
        String choice = sc.nextLine().trim();
        switch (choice){
            case "1" -> {
                System.out.println("signatureSandwich = bltSandwich;");
            }
            case "2" -> {
                System.out.println("signatureSandwich = pcsSandwich;");
            }
            default -> {
                System.out.printf("\nYou entered an invalid option: %s. Please try again!\n\n", choice);
                addSignatureSandwich();
            }
        }
        System.out.println("""
        Would you like your sandwich toasted?
        [1] Toasted
        [2] Not Toasted
        """);
        System.out.print("Please select an option: ");
        String toastedChoice = sc.nextLine().trim();
    }

}