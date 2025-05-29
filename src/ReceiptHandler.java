import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ReceiptHandler {
    private static final String FILE_DIRECTORY = "Receipts/";
    static DecimalFormat df = new DecimalFormat("#.00");

    public static void displayOrderDetails(ArrayList<Item> cart) {
        cart.sort((Item i1, Item i2) -> {
            return i1.getClass().toString().compareToIgnoreCase(i2.getClass().toString());
        });
        int sandCount = 1;
        int drinkCount = 1;
        int chipsCount = 1;
        System.out.println("\nPlease Check Your Order Details. Enter CONFIRM to finalize or CANCEL to modify.");
        System.out.println("\nYour Order Details: ");
        for (Item item : cart) {
            switch (item.getClass().getSimpleName()) {
                case "Sandwich" -> {
                    System.out.println("\nSandwich (" + sandCount + ") \n\t" + item);
                    sandCount++;
                }
                case "Drink" -> {
                    System.out.println("\nDrink (" + drinkCount + ") \n\t" + item);
                    drinkCount++;
                }
                default -> {
                    System.out.println("\nChips (" + chipsCount + ") \n\t" + item);
                    chipsCount++;
                }
            }

        }
        System.out.print("Checkout Total: $" + df.format(Item.getTotal()) + "\nUser Input:");
        System.out.println("""
        Please select an option
        [1] Confirm
        [2] Cancel
        """);
        System.out.print("Please select an option: ");
        Scanner scanner = new Scanner(System.in);
        String checkoutChoice = scanner.nextLine().trim();
        switch (checkoutChoice) {
            case "1" -> {
                saveReceipt(cart);
            }
            case "2" -> {
                System.out.println("\nYou chose to cancel the checkout! Going back to the Order Screen..\n");
                UserInterface.orderScreen();
            }
            default -> {
                System.out.printf("\nYou entered an invalid option for Checkout: %s. Please try again!\n\n", checkoutChoice);
                displayOrderDetails(cart);
            }
        }
    }

    public static void saveReceipt(ArrayList<Item> cart) {
        String timeStamp = new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date());
        String fileName = FILE_DIRECTORY + timeStamp + ".txt";
        int sandCount = 1;
        int drinkCount = 1;
        int chipsCount = 1;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("Order Receipt");
            writer.newLine();
            writer.write("Date: " + timeStamp);
            writer.newLine();
            writer.newLine();
            writer.write("Your Order: ");
            writer.newLine();
            for (Item item : cart) {
                switch (item.getClass().getSimpleName()) {
                    case "Sandwich" -> {
                        writer.newLine();
                        writer.write("Sandwich (" + sandCount + ") \n\t" + item);
                        sandCount++;
                    }
                    case "Drink" -> {
                        writer.newLine();
                        writer.write("Drink (" + drinkCount + ") \n\t" + item);
                        drinkCount++;
                    }
                    default -> {
                        writer.newLine();
                        writer.write("Chips (" + chipsCount + ") \n\t" + item);
                        chipsCount++;
                    }
                }
            }
            writer.newLine();
            writer.write("Your Order Total is $" + df.format(Item.getTotal()));
            writer.newLine();
            writer.write("We appreciate your visit! Hope to serve you again soon!");
            System.out.println("\n\"Thank you for your purchase! \n\nYour receipt is located at: " + fileName);
        } catch (IOException e) {
            System.err.println("\nError generating receipt: " + e.getMessage());
        }
    }

}