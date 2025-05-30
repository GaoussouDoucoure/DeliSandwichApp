package com.java.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import static com.java.pluralsight.Item.getTotal;
import static com.java.pluralsight.UserInterface.orderScreen;

public class ReceiptHandler {
    private static final String FILE_DIRECTORY = "Files/Receipts/";
    static DecimalFormat df = new DecimalFormat("#.00");

    public static void displayOrderDetails(ArrayList<Item> cart) {
        cart.sort((Item i1, Item i2) -> {
            return i1.getClass().toString().compareToIgnoreCase(i2.getClass().toString());
        });
        int sandCount = 1;
        int drinkCount = 1;
        int chipsCount = 1;
        System.out.println("\n*** Please Check Your Order Details. Enter CONFIRM to finalize or CANCEL to go back to the previous screen. ***");
        System.out.println("\nYour Order Details: ");
        for (Item item : cart) {
            String[] lines = item.toString().split("\n");

            switch (item.getClass().getSimpleName()) {
                case "Sandwich" -> {
                    System.out.println("\nSandwich (" + sandCount + ")");
                    for (String line : lines) {
                        System.out.println("\t" + line);
                    }
                    sandCount++;
                }
                case "Drink" -> {
                    System.out.println("\nDrink (" + drinkCount + ")");
                    for (String line : lines) {
                        System.out.println("\t" + line);
                    }
                    drinkCount++;
                }
                default -> {
                    System.out.println("\nChips (" + chipsCount + ")");
                    for (String line : lines) {
                        System.out.println("\t" + line);
                    }
                    chipsCount++;
                }
            }
        }
        System.out.print("\nCheckout Total: $" + df.format(getTotal()));
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
                System.out.println("\nGoing back to the Order Screen..\n");
                orderScreen();
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
            writer.write("Your Order:");
            writer.newLine();

            for (Item item : cart) {
                writer.newLine(); // extra spacing between items
                String[] lines = item.toString().split("\n");

                switch (item.getClass().getSimpleName()) {
                    case "Sandwich" -> {
                        writer.write("Sandwich (" + sandCount + ")");
                        writer.newLine();
                        sandCount++;
                    }
                    case "Drink" -> {
                        writer.write("Drink (" + drinkCount + ")");
                        writer.newLine();
                        drinkCount++;
                    }
                    default -> {
                        writer.write("Chips (" + chipsCount + ")");
                        writer.newLine();
                        chipsCount++;
                    }
                }

                for (String line : lines) {
                    writer.write("\t" + line);
                    writer.newLine();
                }
            }

            writer.newLine();
            writer.write("Your Order Total is $" + df.format(getTotal()));
            writer.newLine();
            writer.write("We appreciate your visit! Hope to serve you again soon!");

            System.out.println("\n***** Thank you for your purchase! *****");
            System.out.println("\n=> Your receipt is located at: " + fileName + " <=");

        } catch (IOException e) {
            System.err.println("\nError generating receipt: " + e.getMessage());
        }
    }


}