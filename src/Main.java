import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        IceCreamShop shop = new IceCreamShop();

        System.out.println("Welcome to the Ice Cream Shop!");
        while (true) {
            System.out.println("\nChoose a flavor:");
            shop.printFlavors();
            int flavorChoice = scanner.nextInt();
            System.out.print("How many scoops? ");
            int scoops = scanner.nextInt();
            shop.addFlavor(flavorChoice, scoops);

            System.out.println("\nChoose a topping:");
            shop.printToppings();
            int toppingChoice = scanner.nextInt();
            System.out.print("How many times? ");
            int toppingTimes = scanner.nextInt();
            shop.addTopping(toppingChoice, toppingTimes);

            System.out.print("\nDo you want to add more items (yes/no)? ");
            String continueChoice = scanner.next();
            if (continueChoice.equalsIgnoreCase("no")) break;
        }

        System.out.println("\nChoose serving option: 1. Paper Cup (Free) 2. Waffle Cone ($5)");
        int servingChoice = scanner.nextInt();
        shop.setServing(servingChoice == 2);

        System.out.println("\nGenerating your invoice...");
        String invoice = InvoiceGenerator.generate(shop);
        System.out.println(invoice);

        scanner.close();
    }
}
