package com.java.pluralsight;

import static com.java.pluralsight.MenuHandler.menuHandler;

public class MainApp {
    public static void main(String[] args) {
        menuHandler();
        UserInterface ui = new UserInterface();
        ui.homeScreen();
    }
}