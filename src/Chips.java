import java.util.ArrayList;

public class Chips extends Item{
    protected String chipsType;
    static ArrayList<Chips> chipFlavors = new ArrayList<>();

    public Chips(String chipType) {
        this.chipsType = chipType;
    }

    public String getChipType() {
        return chipsType;
    }

    public void setChipType(String chipsType) {
        this.chipsType = chipsType;
    }

    public static void toStringChipFlavors() {
        int i = 1;
        System.out.println("List of Chip Flavors: ");
        for (Chips flavors : chipFlavors) {
            System.out.println(i + ".) " + flavors.getChipType() + " ($1.50)");
            i++;
        }
    }

    @Override
    public double getPrice() {
        if (chipsType != null && !chipsType.isEmpty()) {
            return 1.50;
        } else {
            return 0.0;
        }
    }

    @Override
    public String toString() {
        return chipsType;
    }

}