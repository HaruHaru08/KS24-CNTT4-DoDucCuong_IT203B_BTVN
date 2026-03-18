package session09TH;

public class DigitalProduct extends Product{
    double size;

    public DigitalProduct() {
    }

    public DigitalProduct(double size) {
        this.size = size;
    }

    public DigitalProduct(String id, String name, double price, double size) {
        super(id, name, price);
        this.size = size;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }
    @Override
    public String dispayInfo() {
        return "DigitalProduct{" +
                "size=" + size +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
