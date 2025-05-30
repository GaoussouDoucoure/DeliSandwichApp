package com.java.plurasight;

import java.util.ArrayList;

public class Menu {
    static ArrayList<Toppings> regularToppings = new ArrayList<>();
    static ArrayList<Toppings> premiumMeatToppings = new ArrayList<>();
    static ArrayList<Toppings> premiumCheeseToppings = new ArrayList<>();
    static ArrayList<Toppings> allToppings = new ArrayList<>();
    static ArrayList<Toppings> bltToppings = new ArrayList<>();
    static ArrayList<Toppings> pcsToppings = new ArrayList<>();
    static Sandwich bltSandwich = new Sandwich("White Bread", "MEDIUM", bltToppings,true);
    static Sandwich pcsSandwich = new Sandwich("White Bread", "MEDIUM", pcsToppings,true);
}