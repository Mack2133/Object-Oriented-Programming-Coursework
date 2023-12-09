import java.util.Comparator;

class ProductIDComparator implements Comparator<Product> {
    @Override
    public int compare(Product product1, Product product2) {
        return product1.getProductID().compareTo(product2.getProductID());
    }
}
