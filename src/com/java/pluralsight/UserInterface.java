package com.java.pluralsight;

import java.util.Scanner;

import static com.java.pluralsight.Toppings.*;
import static com.java.pluralsight.Menu.*;
import static com.java.pluralsight.Sandwich.cart;
import static com.java.pluralsight.ReceiptHandler.displayOrderDetails;
import static com.java.pluralsight.Drink.drinkFlavors;
import static com.java.pluralsight.Drink.toStringDrinkFlavors;
import static com.java.pluralsight.Chips.chipFlavors;
import static com.java.pluralsight.Chips.toStringChipFlavors;

public class UserInterface implements Screens {
    public static Scanner sc = new Scanner(System.in);

    public static void homeScreen(){
        System.out.println("""
                
                ******************************************************
                ********  WELCOME TO DOUC DELI SANDWICH SHOP  ********
                ********  YOUR #1 BEST SANDWICH SHOP IN TOWN  ********
                ******************************************************
                
                Let's get started! Please select an option.
                [1] New Order
                [2] Exit
                """);
        System.out.print("Select an option: ");
        String choice = sc.nextLine().trim();

        switch (choice){
            case "1" -> orderScreen();
            case "2" -> System.out.println("\nThanks for stopping by! Hope to see you again soon :)");
            default -> {
                System.out.printf("\nYou entered an invalid option: %s. Please try again!\n\n", choice);
                homeScreen();
            }
        }
    }

    public static void orderScreen(){
        System.out.println("""
                
                >>>>> Select an Option <<<<<
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
            case "1" -> addCustomSandwich();
            case "2" -> addSignatureSandwich();
            case "3" -> addDrink();
            case "4" -> addChips();
            case "5" -> checkOut();
            case "0" -> {
                cancelOrder();
                System.out.println("\n*** Going back to the Home Screen.. ***\n");
                homeScreen();
            }
            default -> {
                System.out.printf("\nYou entered an invalid option: %s. Please try again!\n\n", choice);
                orderScreen();
            }
        }
    }

    public static void addCustomSandwich(){
        Sandwich sandwich = new Sandwich();
        System.out.println("""
                
                >>>>> Choose Sandwich Size <<<<<
                [1] Small/4 Inch — ($5.50)
                [2] Medium/8 Inch — ($7.00)
                [3] Large/12 Inch — ($8.50)
                [4] Go back to Order Screen
                """);
        System.out.print("Select your sandwich size (1, 2, or 3): ");
        String sizeChoice = sc.nextLine().trim();
        String size = "";

        switch (sizeChoice){
            case "1" -> size = "SMALL";
            case "2" -> size = "MEDIUM";
            case "3" -> size = "LARGE";
            case "4" -> {
                System.out.println("You chose to go back to the Order Screen..");
                orderScreen();
            }
            default -> {
                System.out.printf("\nYou entered an invalid option for Sandwich Size: %s. Please try again!\n\n", sizeChoice);
                addCustomSandwich();
            }
        }
        sandwich.setSandwichSize(size);

        System.out.println("""
        
        >>>>> Choose Bread Type <<<<<
        [1] White
        [2] Wheat
        [3] Rye
        [4] Wrap
        """);
        System.out.print("Select your bread type (1, 2, 3 or 4): ");
        String breadChoice = sc.nextLine().trim();
        String bread = "";

        switch (breadChoice) {
            case "1" -> bread = "WHITE";
            case "2" -> bread = "WHEAT";
            case "3" -> bread = "Rye";
            case "4" -> bread = "Wrap";
            default -> {
                System.out.printf("\nYou entered an invalid option for Bread Type: %s. Please try again!\n\n", sizeChoice);
                addCustomSandwich();
            }
        }
        sandwich.setBreadType(bread);

        System.out.println("""
                
                >>>>> Would you like your sandwich toasted? <<<<<
                [1] Toasted
                [2] Not Toasted
                """);
        System.out.print("Select an option for Toasting (1, or 2): ");
        String toastedChoice = sc.nextLine().trim();
        boolean isToasted = true;

        switch (toastedChoice) {
            case "1" -> {
            }
            case "2" -> isToasted = false;
            default -> {
                System.out.printf("\nYou entered an invalid option for Toasting: %s. Please try again!\n\n", sizeChoice);
                addCustomSandwich();
            }
        }
        sandwich.setToasted(isToasted);

        System.out.println("""
        
        >>>>> Would you like to add Toppings? <<<<<
        [1] Toppings
        [2] No Toppings
        """);
        System.out.print("Select an option for Toppings (1, or 2): ");
        String toppingChoice = sc.nextLine().trim();

        switch (toppingChoice) {
            case "1" -> toppingsMenu(sandwich);
            case "2" -> System.out.println("\nProceeding with No Toppings.");
            default -> {
                System.out.printf("\nYou entered an invalid option: %s. Please try again!\n\n", sizeChoice);
                addCustomSandwich();
            }
        }
        addToCart(sandwich);
        System.out.println("\n*** Sandwich successfully added! Now returning to the Order Screen.. ***");
        orderScreen();
    }

    public static void toppingsMenu(Sandwich sandwich) {
        try {
            System.out.println("\n>>>>> Which toppings would you like? <<<<<");
            System.out.println("[1] Regular Toppings (Included)");
            switch (sandwich.getSandwichSize()) {
                case "SMALL" -> {
                    if (!sandwich.hasAnyMeat())
                        System.out.println("[2] Meat Toppings ($1.00)");
                    else
                        System.out.println("[2] Meat Toppings ($0.50)");
                    if (!sandwich.hasAnyCheese())
                        System.out.println("[3] Cheese Toppings ($0.75)");
                    else
                        System.out.println("[3] Cheese Toppings ($0.30)");
                }
                case "MEDIUM" -> {
                    if (!sandwich.hasAnyMeat())
                        System.out.println("[2] Meat Toppings ($2.00)");
                    else
                        System.out.println("[2] Meat Toppings ($1.00)");
                    if (!sandwich.hasAnyCheese())
                        System.out.println("[3] Cheese Toppings ($1.50)");
                    else
                        System.out.println("[3] Cheese Toppings ($0.60)");
                }
                case "LARGE" -> {
                    if (!sandwich.hasAnyMeat())
                        System.out.println("[2] Meat Toppings ($3.00)");
                    else
                        System.out.println("[2] Meat Toppings ($1.50)");
                    if (!sandwich.hasAnyCheese())
                        System.out.println("[3] Cheese Toppings ($2.25)");
                    else
                        System.out.println("[3] Cheese Toppings ($0.90)");
                }
            }
            System.out.print("\nSelect your Toppings: ");
            String toppingsSelection = sc.nextLine().trim();
            //Topping menu
            switch (toppingsSelection) {
                case "1" -> {
                    toStringRegularToppings();
                    System.out.print("\nPlease select a number for your topping choice: ");
                    String regToppingChoice = sc.nextLine().trim();
                    sandwich.sandwichToppings.add(regularToppings.get(Integer.parseInt(regToppingChoice) - 1));
                    anotherTopping(sandwich);
                }
                case "2" -> {
                    toStringMeatToppings();
                    System.out.print("\nPlease select a number for your topping choice: ");
                    String meatToppingChoice = sc.nextLine().trim();
                    for (Toppings toppings : sandwich.sandwichToppings) {
                        if (toppings.isMeat) {
                            premiumMeatToppings.get(Integer.parseInt(meatToppingChoice)  - 1).setExtraMeat(true);
                            break;
                        }
                    }
                    sandwich.sandwichToppings.add((premiumMeatToppings.get(Integer.parseInt(meatToppingChoice) - 1)));
                    anotherTopping(sandwich);
                }
                case "3" -> {
                    toStringCheeseToppings();
                    System.out.print("\nPlease select a number for your topping choice: ");
                    String cheeseToppingChoice = sc.nextLine().trim();
                    for (Toppings toppings : sandwich.sandwichToppings) {
                        if (toppings.isCheese) {
                            premiumCheeseToppings.get(Integer.parseInt(cheeseToppingChoice) - 1).setExtraCheese(true);
                            break;
                        }
                    }
                    sandwich.sandwichToppings.add((premiumCheeseToppings.get(Integer.parseInt(cheeseToppingChoice) - 1)));
                    anotherTopping(sandwich);
                }
                case "4" -> System.out.println("\nExiting Toppings Selection..");
                default -> {
                    System.out.printf("\nYou entered an invalid option: %s. Please try again!\n\n", toppingsSelection);
                    toppingsMenu(sandwich);
                }
            }
        } catch (Exception inputError) {
            System.out.println("\nOops! Something went wrong, please try again.");
            inputError.printStackTrace();
            toppingsMenu(sandwich);
        }
    }

    public static void anotherTopping(Sandwich sandwich) {
        System.out.println("""
        
        Would you like to add another topping?
        [1] Yes
        [2] No
        """);
        System.out.print("Select an option for additional Topping: ");
        String additionalToppingChoice = sc.nextLine().trim();
        switch (additionalToppingChoice) {
            case "1" -> toppingsMenu(sandwich);
            case "2" -> {
            }
            default -> {
                System.out.printf("\nYou entered an invalid option: %s. Please try again!\n\n", additionalToppingChoice);
                anotherTopping(sandwich);
            }
        }
    }

    public static void addSignatureSandwich(){
        Sandwich signatureSandwich = new Sandwich();
        System.out.println("""
                
                We have some signature sandwich made right just for you!
                Please choose one to proceed :)
                
                [1] BLT Sandwich
                [2] Philly Cheese Steak
                [3] Chicken Teriyaki
                [4] Go back to Order Screen
                """);
        System.out.print("Select a signature sandwich: ");
        String choice = sc.nextLine().trim();
        switch (choice){
            case "1" -> {
                signatureSandwich = bltSandwich;
            }
            case "2" -> {
                signatureSandwich = pcsSandwich;
            }
            case "3" -> {
                signatureSandwich = ctSandwich;
            }
            case "4" -> {
                System.out.println("You chose to go back to the Order Screen..");
                orderScreen();
            }
            default -> {
                System.out.printf("\nYou entered an invalid option: %s. Please try again!\n\n", choice);
                addSignatureSandwich();
            }
        }

        addToCart(signatureSandwich);
        System.out.println("\n*** Sandwich successfully added! Now returning to the Order Screen.. ***");
        orderScreen();
    }

    public static void addDrink() {
        try {
            System.out.println("""
            
            >>>>> Size of Drink <<<<<
            [1] Small ($2.00)
            [2] Medium($2.50)
            [3] Large($3.00)
            [4] Go back to Order Screen
            """);
            System.out.print("\nPlease select a number for the size of your Drink (1, 2 or 3): ");
            String drinkSizeChoice = sc.nextLine().trim();
            String size = "";
            switch (drinkSizeChoice) {
                case "1" -> {
                    size = "SMALL";
                }
                case "2" -> {
                    size = "MEDIUM";
                }
                case "3" -> {
                    size = "LARGE";
                }
                case "4" -> {
                    System.out.println("You chose to go back to the Order Screen..");
                    orderScreen();
                }
                default -> {
                    System.out.printf("\nYou entered an invalid option: %s. Please try again!\n\n", drinkSizeChoice);
                    addDrink();
                }
            }
            toStringDrinkFlavors();
            System.out.print("\nPlease select a number for the size of your Drink: ");
            String flavourChoice = (drinkFlavors.get((Integer.parseInt(sc.nextLine().trim())) - 1)).getDrinkFlavor();
            System.out.print("""
            
            Would you like Ice in your Drink? (1 or 2)
            [1] Yes
            [2] No
            """);
            System.out.print("\nSelect an option for Ice: ");
            String iceChoice = sc.nextLine().trim();
            boolean hasIce = true;
            switch (iceChoice) {
                case "1" -> {
                }
                case "2" -> hasIce = false;
                default -> {
                    System.out.printf("\nYou entered an invalid option for Ice: %s. Please try again!\n\n", iceChoice);
                    addDrink();
                }
            }
            Drink newDrink = new Drink(size, flavourChoice, hasIce);
            addToCart(newDrink);
            System.out.println("\n*** Drink successfully added! Now returning to the Order Screen.. ***");
            orderScreen();
        } catch (Exception inputError) {
            System.out.println("\nPlease enter a valid option! Returning to Drink Menu..");
            addDrink();
        }
    }

    public static void addChips() {
        try {
            toStringChipFlavors();
            System.out.print("\nPlease select a number for your Chips choice: ");
            String chipsChoice = (chipFlavors.get((Integer.parseInt(sc.nextLine().trim())) - 1)).getChipType();
            Chips chips = new Chips(chipsChoice);
            addToCart(chips);
            System.out.println("\n*** Chips successfully added! Now returning to the Order Screen.. ***");
            orderScreen();
        } catch (Exception inputError) {
            System.out.println("\nPlease enter a valid option! Returning to Chips Menu..");
            addChips();
        }
    }

    public static void cancelOrder() {
        cart.clear();
        System.out.println("Your order has been canceled and the cart is now empty.");
    }


    public static void addToCart(Item newItem) {
        cart.add(newItem);
    }

    public static void checkOut() {
        displayOrderDetails(cart);
    }

}