package com.java.plurasight;

public class Toppings extends Item {
    protected String toppingName;
    protected boolean isMeat;
    protected boolean isExtraMeat;
    protected boolean isCheese;
    protected boolean isExtraCheese;

    public Toppings(String toppingName, boolean isMeat, boolean isExtraMeat, boolean isCheese, boolean isExtraCheese) {
        this.toppingName = toppingName;
        this.isMeat = isMeat;
        this.isExtraMeat = isExtraMeat;
        this.isCheese = isCheese;
        this.isExtraCheese = isExtraCheese;
    }

    public String getToppingName() {
        return toppingName;
    }

    public void setToppingName(String toppingName) {
        this.toppingName = toppingName;
    }

    public boolean isMeat() {
        return isMeat;
    }

    public void setMeat(boolean meat) {
        isMeat = meat;
    }

    public boolean isExtraMeat() {
        return isExtraMeat;
    }

    public void setExtraMeat(boolean extraMeat) {
        isExtraMeat = extraMeat;
    }

    public boolean isCheese() {
        return isCheese;
    }

    public void setCheese(boolean cheese) {
        isCheese = cheese;
    }

    public boolean isExtraCheese() {
        return isExtraCheese;
    }

    public void setExtraCheese(boolean extraCheese) {
        isExtraCheese = extraCheese;
    }
    
    public static void toStringRegularToppings(){
        int i = 1;
        System.out.println("List of Regular Toppings: ");
        for(Toppings topping : Menu.regularToppings){
            System.out.println(i + ".) " + topping.getToppingName());
            i++;
        }
    }

    public static void toStringMeatToppings() {
        int i = 1;
        System.out.println("List of Premium Meat Toppings: ");
        for (Toppings topping : Menu.premiumMeatToppings) {
            System.out.println(i + ".) " + topping.getToppingName());
            i++;

        }
    }

    public static void toStringCheeseToppings() {
        int i = 1;
        System.out.println("List of Premium Cheese Toppings: ");
        for (Toppings topping : Menu.premiumCheeseToppings) {
            System.out.println(i + ".) " + topping.getToppingName());
            i++;

        }
    }
    
    @Override
    public double getPrice(){
        return 0;
    }
    
    @Override
    public String toString(){
        return toppingName;
    }
    
}