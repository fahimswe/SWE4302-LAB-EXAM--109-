import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IceCreamShopTest {
    @Test
    public void testSubtotal() {
        IceCreamShop shop = new IceCreamShop();
        shop.addFlavor(1, 2); // Mint Chocolate Chip
        shop.addTopping(1, 1); // Sprinkles
        assertEquals(6.3, shop.calculateSubtotal(), 0.01);
    }

    @Test
    public void testTaxCalculation() {
        IceCreamShop shop = new IceCreamShop();
        shop.addFlavor(2, 1); // Chocolate Fudge
        assertEquals(0.24, shop.calculateTax(), 0.01);
    }

    @Test
    public void testWaffleConeCharge() {
        IceCreamShop shop = new IceCreamShop();
        shop.setServing(true); // Waffle Cone
        assertEquals(5.00, shop.calculateSubtotal(), 0.01);
    }

    @Test
    public void testTotalAmount() {
        IceCreamShop shop = new IceCreamShop();
        shop.addFlavor(4, 1); // Pistachio Delight
        shop.setServing(true); // Waffle Cone
        assertEquals(8.91, shop.calculateTotal(), 0.01);
    }

    @Test
    public void testInvoiceGeneration() {
        IceCreamShop shop = new IceCreamShop();
        shop.addFlavor(3, 1); // Strawberry Swirl
        String invoice = InvoiceGenerator.generate(shop);
        assertTrue(invoice.contains("Strawberry Swirl"));
    }
}
