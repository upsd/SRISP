package upsd.api;

import spark.Spark;
import upsd.product.ProductServiceFactory;

public class ProductAPI {

    private final ProductServiceFactory productServiceFactory;

    public ProductAPI(ProductServiceFactory productServiceFactory) {
        this.productServiceFactory = productServiceFactory;
    }

    public void startOn(int port) {
        Spark.port(port);
        new Routes(productServiceFactory).wire();
    }
}
