package upsd.product;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ProductRepositoryShould {

    private static final Product PRODUCT = new Product("some description");
    private HashMap<Integer, Product> productsToAdd;
    private ProductRepository productRepository;

    @Before
    public void setUp() {
        productsToAdd = new HashMap<>();
        productsToAdd.put(4, PRODUCT);

        productRepository = new ProductRepository(productsToAdd);
    }

    @Test
    public void get_product_by_id() {
        Optional<Product> productFound = productRepository.getBy(4);


        assertThat(productFound.get(), is(PRODUCT));
    }
}
