import java.util.Map;

public class InvoiceGenerator {
    public static String generate(IceCreamShop shop) {
        StringBuilder invoice = new StringBuilder("Ice Cream Shop Invoice\n");
        for (Map.Entry<String, Integer> entry : shop.getOrderFlavors().entrySet()) {
            invoice.append(String.format("%s - %d scoop(s): $%.2f%n",
                    entry.getKey(), entry.getValue(), entry.getValue() * shop.flavors.get(entry.getKey())));
        }
        for (Map.Entry<String, Integer> entry : shop.getOrderToppings().entrySet()) {
            invoice.append(String.format("%s - %d time(s): $%.2f%n",
                    entry.getKey(), entry.getValue(), entry.getValue() * shop.toppings.get(entry.getKey())));
        }
        if (shop.isWaffleCone()) {
            invoice.append("Waffle Cone: $5.00\n");
        }

        double subtotal = shop.calculateSubtotal();
        double tax = shop.calculateTax();
        double total = shop.calculateTotal();

        invoice.append(String.format("Subtotal: $%.2f%n", subtotal));
        invoice.append(String.format("Tax: $%.2f%n", tax));
        invoice.append(String.format("Total Amount Due: $%.2f%n", total));

        return invoice.toString();
    }
}
