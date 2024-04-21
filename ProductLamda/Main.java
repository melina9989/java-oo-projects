package gr.aueb.cf.myPractice.ProductLamda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main {
    private static final List<Product> products = Arrays.asList(
            new Product(123, "Oranges", 13.1,  3120),
            new Product(1234, "Apples", 18.4,  340),
            new Product(12345, "Honey", 16.9,  450),
            new Product(123456, "Bread", 43.8,  80)
    );

    public static void main(String[] args) {

        List<Product> filteredProducts = getFilteredProducts(products, product -> product.getQuantity() >= 340);

        for (Product product : filteredProducts) {
            product.printProductInfo();
            System.out.println();
        }

        checkAndPrintProducts(products, product -> product.getPrice() == 13.1, System.out::println);
        System.out.println();


        products.sort((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()));

        System.out.println("Product List from cheap to expensive: ");
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public static List<Product> getFilteredProducts(List<Product> products, Predicate<Product> filter) {
        List<Product> productsToReturn = new ArrayList<>();
        for(Product product : products) {
            if (filter.test(product)) {
                productsToReturn.add(product);
            }
        }
        return productsToReturn;
    }

    public static void checkAndPrintProducts(List<Product> products, Predicate<Product> filter, Consumer<Product> consumer) {
        List<Product> productsToReturn = new ArrayList<>();
        for(Product product : products) {
            if (filter.test(product)) {
                productsToReturn.add(product);
                consumer.accept(product);
            }

        }
    }
}
