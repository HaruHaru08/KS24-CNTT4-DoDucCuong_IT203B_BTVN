package session09TH;

public class ProductFactory {
    public static Product createProduct(int type, String id, String name, double price, double additionalAttribute) {
        if (type == 1) {
            return new PhysicalProduct(id, name, price, additionalAttribute);
        } else if (type == 2) {
            return new DigitalProduct(id, name, price, additionalAttribute);
        }
        return null;
    }
}
