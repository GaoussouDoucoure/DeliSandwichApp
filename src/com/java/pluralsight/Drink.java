package com.java.pluralsight;

import java.util.ArrayList;

public class Drink extends Item {
    protected String drinkSize;
    protected String drinkFlavor;
    protected boolean hasIce;
    
    static ArrayList<Drink> drinkFlavors = new ArrayList<>();

    public Drink(String drinkSize, String drinkFlavor, boolean hasIce) {
        this.drinkSize = drinkSize;
        this.drinkFlavor = drinkFlavor;
        this.hasIce = hasIce;
    }
    
    public Drink(String drinkFlavor){
        this.drinkFlavor = drinkFlavor;
    }

    public String getDrinkSize() {
        return drinkSize;
    }

    public void setDrinkSize(String drinkSize) {
        this.drinkSize = drinkSize;
    }

    public String getDrinkFlavor() {
        return drinkFlavor;
    }

    public void setDrinkFlavor(String drinkFlavor) {
        this.drinkFlavor = drinkFlavor;
    }

    public boolean isHasIce() {
        return hasIce;
    }

    public void setHasIce(boolean hasIce) {
        this.hasIce = hasIce;
    }

    public static void toStringDrinkFlavors() {
        int index = 1;
        System.out.println("\nList of Drink Flavors: ");
        for (Drink flavors : drinkFlavors) {
            System.out.println(index + ".) " + flavors.getDrinkFlavor());
            index++;
        }
    }

    @Override
    public double getPrice() {
        switch (drinkSize) {
            case "SMALL" -> {
                return 2.00;
            }
            case "MEDIUM" -> {
                return 2.50;
            }
            case "LARGE" -> {
                return 3.00;
            }
            default -> {
                return 0.0; //default value when user decides not to get a drink
            }
        }
    }

    @Override
    public String toString() {
        if (hasIce) {
            return drinkSize + ", " +
                    drinkFlavor + ", " +
                    "Ice";
        } else {
            return drinkSize + ", " +
                    drinkFlavor + ", " +
                    "No Ice";
        }
    }

}