package gr.aueb.cf.myPractice.ProductLamda;

public class Product {
    private long id;
    private String title;
    private double price;
    private long quantity;

    public Product() {

    }

    public Product(long id, String title, double price, long quantity) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.quantity = quantity;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }

    public void printProductInfo() {
        System.out.println("id: " + getId() +
                " title : " + getTitle() +
                " price: " + getPrice() +
                " quantity: " + getQuantity());
    }
}
