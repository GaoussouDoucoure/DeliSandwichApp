package com.java.plurasight;

import java.util.ArrayList;

public class Sandwich extends Item {
    String breadType;
    String sandwichSize;
    ArrayList<Toppings> sandwichToppings = new ArrayList<>();
    boolean isToasted;
    String signatureName = null;

    public Sandwich(String breadType, String sandwichSize, ArrayList<Toppings> sandwichToppings, boolean isToasted) {
        this.breadType = breadType;
        this.sandwichSize = sandwichSize;
        this.sandwichToppings = sandwichToppings;
        this.isToasted = isToasted;
    }

    public Sandwich(String breadType, String sandwichSize, ArrayList<Toppings> sandwichToppings, boolean isToasted, String signatureName) {
        this.breadType = breadType;
        this.sandwichSize = sandwichSize;
        this.sandwichToppings = sandwichToppings;
        this.isToasted = isToasted;
        this.signatureName = signatureName;
    }

    public Sandwich(){

    }

    public String getBreadType() {
        return breadType;
    }

    public void setBreadType(String breadType) {
        this.breadType = breadType;
    }

    public String getSandwichSize() {
        return sandwichSize;
    }

    public void setSandwichSize(String sandwichSize) {
        this.sandwichSize = sandwichSize;
    }

    public boolean isToasted() {
        return isToasted;
    }

    public void setToasted(boolean toasted) {
        isToasted = toasted;
    }

    public String getSignatureName() {
        return signatureName;
    }

    public void setSignatureName(String signatureName) {
        this.signatureName = signatureName;
    }

    public ArrayList<Toppings> getSandwichToppings() {
        return sandwichToppings;
    }

    public void setSandwichToppings(ArrayList<Toppings> sandwichToppings) {
        this.sandwichToppings = sandwichToppings;
    }

    public boolean hasAnyMeat() {
        for (Toppings topping : sandwichToppings) {
            if (topping.isMeat) {
                return true;
            }
        }
        return false;
    }

    public boolean hasAnyCheese() {
        for (Toppings topping : sandwichToppings) {
            if (topping.isCheese) {
                return true;
            }
        }
        return false;
    }

    @Override
    public double getPrice() {
        double sandwichPrice = switch (sandwichSize) {
            case "SMALL" -> 5.50;
            case "MEDIUM" -> 7.00;
            case "LARGE" -> 8.50;
            default -> 0.0;
        };

        for (Toppings topping : sandwichToppings) {
            if (sandwichSize.equals("SMALL")) {
                if (topping.isMeat) sandwichPrice += topping.isExtraMeat ? 0.50 : 1.00;
                else if (topping.isCheese) sandwichPrice += topping.isExtraCheese ? 0.30 : 0.75;
            } else if (sandwichSize.equals("MEDIUM")) {
                if (topping.isMeat) sandwichPrice += topping.isExtraMeat ? 1.00 : 2.00;
                else if (topping.isCheese) sandwichPrice += topping.isExtraCheese ? 0.60 : 1.50;
            } else if (sandwichSize.equals("LARGE")) {
                if (topping.isMeat) sandwichPrice += topping.isExtraMeat ? 1.50 : 3.00;
                else if (topping.isCheese) sandwichPrice += topping.isExtraCheese ? 0.90 : 2.25;
            }
        }

        return sandwichPrice;
    }


    @Override
    public String toString() {
        String result = "";

        if (signatureName != null) {
            result += "Signature: " + signatureName + " Sandwich\n";
        }

        result += "Size: " + sandwichSize + " 8\"\n";
        result += "Bread: " + breadType + "\n";

        if (sandwichToppings.isEmpty()) {
            result += "No Toppings\n";
        } else {
            result += "Toppings: ";
            for (int i = 0; i < sandwichToppings.size(); i++) {
                result += sandwichToppings.get(i).toppingName;
                if (i < sandwichToppings.size() - 1) {
                    result += ", ";
                }
            }
            result += "\n";
        }

        result += isToasted ? "Toasted\n" : "Not Toasted\n";

        return result;
    }

}