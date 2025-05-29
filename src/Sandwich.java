import java.util.ArrayList;

public class Sandwich extends Item {
    String breadType;
    String sandwichSize;
    ArrayList<Toppings> sandwichToppings = new ArrayList<>();
    boolean isToasted;

    public Sandwich(String breadType, String sandwichSize, ArrayList<Toppings> sandwichToppings, boolean isToasted) {
        this.breadType = breadType;
        this.sandwichSize = sandwichSize;
        this.sandwichToppings = sandwichToppings;
        this.isToasted = isToasted;
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

    public boolean hasAnyMeat(){
        if(sandwichToppings.isEmpty()){
            return false;
        }
        else {
            int i = sandwichToppings.size();
            for (Toppings topping : sandwichToppings){
                if (topping.isMeat){
                    i--;
                }
            }
            return i != sandwichToppings.size();
        }
    }

    public boolean hasAnyCheese() {
        if (sandwichToppings.isEmpty())
            return false;
        else {
            int i = sandwichToppings.size();
            for (Toppings topping : sandwichToppings) {
                if (topping.isCheese)
                    i--;
            }
            return i != sandwichToppings.size();
        }
    }

    @Override
    public double getPrice(){
        double sandwichPrice = 0;
        switch (sandwichSize) {
            case "SMALL":
                sandwichPrice = 5.50;
                for (Toppings topping : sandwichToppings) {
                    if (topping.isMeat && !topping.isExtraMeat)
                        sandwichPrice += 1.00;
                    else if (topping.isExtraMeat)
                        sandwichPrice += 0.50;
                    else if (topping.isCheese && !topping.isExtraCheese)
                        sandwichPrice += 0.75;
                    else if (topping.isExtraCheese)
                        sandwichPrice += 0.30;
                }
            case "MEDIUM":
                sandwichPrice = 7.00;
                for (Toppings topping : sandwichToppings) {
                    if (topping.isMeat && !topping.isExtraMeat)
                        sandwichPrice += 2.00;
                    else if (topping.isExtraMeat)
                        sandwichPrice += 1.00;
                    else if (topping.isCheese && !topping.isExtraCheese)
                        sandwichPrice += 1.50;
                    else if (topping.isExtraCheese)
                        sandwichPrice += 0.60;
                }
            case "LARGE":
                sandwichPrice = 8.50;
                for (Toppings topping : sandwichToppings) {
                    if (topping.isMeat && !topping.isExtraMeat) {
                        sandwichPrice += 3.00;
                    }
                    else if (topping.isExtraMeat) {
                        sandwichPrice += 1.50;
                    }
                    else if (topping.isCheese && !topping.isExtraCheese) {
                        sandwichPrice += 2.25;
                    }
                    else if (topping.isExtraCheese) {
                        sandwichPrice += 0.90;
                    }
                }
        }
        return sandwichPrice;
    }

    @Override
    public String toString(){
        if (isToasted()) {
            if (sandwichToppings.isEmpty() && sandwichSize.equals("MEDIUM")) {
                return "Signature: BLT Sandwich" + "\n" +
                        "Size: MEDIUM 8\"\n" +
                        "Bread: " + (breadType.equals("White Bread")) + "\n" +
                        "Toppings: Bacon, Cheddar, Lettuce, Tomato, Ranch\n" +
                        "Toasted" + "\n";
            } else if (!sandwichToppings.isEmpty() && sandwichSize.equals("MEDIUM")) {
                return "Signature: Philly Cheese Steak" + "\n" +
                        "Size: MEDIUM 8\"\n" +
                        "Bread: " + (breadType.equals("White Bread")) + "\n" +
                        "Toppings: Steak, American Cheese, Peppers, Mayo\n" +
                        "Toasted" + "\n";
            } else {
                if (sandwichToppings.isEmpty()) {
                    return "Size: " + sandwichSize + "\n" +
                            "Bread: " + breadType + "\n" +
                            "No Toppings" + "\n" +
                            "Toasted\n";
                } else {
                    return "Size: " + sandwichSize + "\n" +
                            "Bread: " + breadType + "\n" +
                            "Toppings: " + sandwichToppings + "\n" +
                            "Toasted\n";
                }
            }
        }
        else {
            if (sandwichToppings.isEmpty() && sandwichSize.equals("MEDIUM")) {
                return "Signature: BLT Sandwich" + "\n" +
                        "Size: MEDIUM 8\"\n" +
                        "Bread: " + (breadType.equals("White Bread")) + "\n" +
                        "Toppings: Bacon, Cheddar, Lettuce, Tomato, Ranch\n" +
                        "Not Toasted" + "\n";
            } else if (!sandwichToppings.isEmpty() && sandwichSize.equals("MEDIUM")) {
                return "Signature: Philly Cheese Steak" + "\n" +
                        "Size: MEDIUM 8\"\n" +
                        "Bread: " + (breadType.equals("White Bread")) + "\n" +
                        "Toppings: Steak, American Cheese, Peppers, Mayo\n" +
                        "Not Toasted" + "\n";
            } else {
                if (sandwichToppings.isEmpty()) {
                    return "Size: " + sandwichSize + "\n" +
                            "Bread: " + breadType + "\n" +
                            "No Toppings" + "\n" +
                            "Not Toasted\n";
                } else {
                    return "Size: " + sandwichSize + "\n" +
                            "Bread: " + breadType + "\n" +
                            "Toppings: " + sandwichToppings + "\n" +
                            "Not Toasted\n";
                }
            }
        }
    }

}