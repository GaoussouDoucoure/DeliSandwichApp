package com.java.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;

public class MenuHandler {
    public static void menuhandler() {
        try {
            FileReader fr = new FileReader("Menu.csv");
            BufferedReader br = new BufferedReader(fr);
            String indexInfo;
            boolean isFirst;
            int index = 0;
            while ((indexInfo = br.readLine()) != null) {
                String[] splitLine = indexInfo.split("\\|");
                switch (index) {
                    case 0 -> {
                        isFirst = true;
                        for (String newTopping : splitLine) {
                            if (!isFirst) {
                                Toppings newRegularTopping = new Toppings(newTopping, false, false, false, false);
                                Menu.regularToppings.add(newRegularTopping);
                                Menu.allToppings.add(newRegularTopping);
                            } else
                                isFirst = false;
                        }
                        index++;
                    }
                    case 1 -> {
                        isFirst = true;
                        for (String newTopping : splitLine) {
                            if (!isFirst) {
                                Toppings newMeatTopping = new Toppings(newTopping, true, false, false, false);
                                Menu.premiumMeatToppings.add(newMeatTopping);
                                Menu.allToppings.add(newMeatTopping);
                            } else
                                isFirst = false;
                        }
                        index++;
                    }
                    case 2 -> {
                        isFirst = true;
                        for (String newTopping : splitLine) {
                            if (!isFirst) {
                                Toppings newCheeseTopping = new Toppings(newTopping, false, false, true, false);
                                Menu.premiumCheeseToppings.add(newCheeseTopping);
                                Menu.allToppings.add(newCheeseTopping);
                            } else
                                isFirst = false;
                        }
                        index++;
                    }
                    case 3 -> {
                        isFirst = true;
                        for (String drinkName : splitLine) {
                            if (!isFirst) {
                                Drink newDrink = new Drink(drinkName);
                                Drink.drinkFlavors.add(newDrink);
                            } else
                                isFirst = false;
                        }
                        index++;
                    }
                    case 4 -> {
                        isFirst = true;
                        for (String chipName : splitLine) {
                            if (!isFirst) {
                                Chips newChips = new Chips(chipName);
                                Chips.chipFlavors.add(newChips);
                            } else
                                isFirst = false;
                        }
                        index++;
                    }
                }
            }
            UserInterface.homeScreen();
        } catch (Exception fileError) {
            System.out.println("Oops something went wrong with the current file path. Please try again.");
            fileError.printStackTrace();
        }
    }
}
