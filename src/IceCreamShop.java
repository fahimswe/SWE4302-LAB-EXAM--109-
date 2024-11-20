import java.util.HashMap;
import java.util.Map;

public class IceCreamShop {
    public final Map<String, Double> flavors = Map.of(
            "Mint Chocolate Chip", 2.80,
            "Chocolate Fudge", 3.00,
            "Strawberry Swirl", 2.75,
            "Pistachio Delight", 3.25
    );

    public final Map<String, Double> toppings = Map.of(
            "Sprinkles", 0.30,
            "Marshmallow", 0.70,
            "Crushed Oreo", 0.85,
            "Fresh Strawberries", 1.00,
            "Chocolate Chips", 0.50
    );

    private final Map<String, Integer> orderFlavors = new HashMap<>();
    private final Map<String, Integer> orderToppings = new HashMap<>();
    private boolean waffleCone = false;

    public void addFlavor(int choice, int scoops) {
        String flavor = (String) flavors.keySet().toArray()[choice - 1];
        orderFlavors.put(flavor, orderFlavors.getOrDefault(flavor, 0) + scoops);
    }

    public void addTopping(int choice, int times) {
        String topping = (String) toppings.keySet().toArray()[choice - 1];
        orderToppings.put(topping, orderToppings.getOrDefault(topping, 0) + times);
    }

    public void setServing(boolean waffleCone) {
        this.waffleCone = waffleCone;
    }

    public double calculateSubtotal() {
        double subtotal = 0;
        for (Map.Entry<String, Integer> entry : orderFlavors.entrySet()) {
            subtotal += flavors.get(entry.getKey()) * entry.getValue();
        }
        for (Map.Entry<String, Integer> entry : orderToppings.entrySet()) {
            subtotal += toppings.get(entry.getKey()) * entry.getValue();
        }
        if (waffleCone) subtotal += 5.00;
        return subtotal;
    }

    public double calculateTax() {
        return calculateSubtotal() * 0.08;
    }

    public double calculateTotal() {
        return calculateSubtotal() + calculateTax();
    }

    public Map<String, Integer> getOrderFlavors() {
        return orderFlavors;
    }

    public Map<String, Integer> getOrderToppings() {
        return orderToppings;
    }

    public boolean isWaffleCone() {
        return waffleCone;
    }

    public void printFlavors() {
        int i = 1;
        for (String flavor : flavors.keySet()) {
            System.out.printf("%d. %s - $%.2f%n", i++, flavor, flavors.get(flavor));
        }
    }

    public void printToppings() {
        int i = 1;
        for (String topping : toppings.keySet()) {
            System.out.printf("%d. %s - $%.2f%n", i++, topping, toppings.get(topping));
        }
    }
}
