package com.java.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    static ArrayList<Toppings> regularToppings = new ArrayList<>();
    static ArrayList<Toppings> premiumMeatToppings = new ArrayList<>();
    static ArrayList<Toppings> premiumCheeseToppings = new ArrayList<>();
    static ArrayList<Toppings> allToppings = new ArrayList<>();

    // Signature Sandwich BLT toppings
    static ArrayList<Toppings> bltToppings = new ArrayList<>(List.of(
            new Toppings("Bacon", true, false, false, false),
            new Toppings("Cheddar", false, true, false, false),
            new Toppings("Lettuce", false, false, false, false),
            new Toppings("Tomato", false, false, false, false),
            new Toppings("Ranch", false, false, false, false)
    ));

    // Signature Sandwich Philly Cheese Steak Toppings
    static ArrayList<Toppings> pcsToppings = new ArrayList<>(List.of(
            new Toppings("Steak", true, false, false, false),
            new Toppings("American Cheese", false, true, false, false),
            new Toppings("Peppers", false, false, false, false),
            new Toppings("Mayo", false, false, false, false)
    ));

    // Signature Sandwich Chicken Teriyaki Toppings
    static ArrayList<Toppings> chickenTeriyakiToppings = new ArrayList<>(List.of(
            new Toppings("Chicken Teriyaki", true, false, false, false),
            new Toppings("Swiss", false, true, false, false),
            new Toppings("Lettuce", false, false, false, false),
            new Toppings("Tomato", false, false, false, false),
            new Toppings("Mayo", false, false, false, false)
    ));

    // Signature Sandwiches
    static Sandwich bltSandwich = new Sandwich("White Bread", "MEDIUM", bltToppings, true, "BLT");
    static Sandwich pcsSandwich = new Sandwich("White Bread", "MEDIUM", pcsToppings, true, "Philly Cheese Steak");
    static Sandwich ctSandwich = new Sandwich("Wheat", "LARGE", chickenTeriyakiToppings, true, "Chicken Teriyaki");
}