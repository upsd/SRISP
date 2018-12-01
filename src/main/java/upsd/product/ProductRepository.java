package upsd.product;

import java.util.HashMap;
import java.util.Optional;

class ProductRepository {

    private final HashMap<Integer, Product> products;

    ProductRepository(HashMap<Integer, Product> productsToAdd) {
        this.products = productsToAdd;
    }

    ProductRepository() {
        this.products = new HashMap<>();
    }

    Optional<Product> getBy(int id) {
        return Optional.of(this.products.get(id));
    }
}
