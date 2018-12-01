package upsd.api;

import upsd.product.ProductController;
import upsd.product.ProductServiceFactory;

import static spark.Spark.*;

public class Routes {

    private ProductController productController;

    public Routes(ProductServiceFactory productServiceFactory) {
        productController = new ProductController(productServiceFactory);
    }

    public void wire() {
        get("/products/:id", (req, res) -> productController.getById(req, res));
        exception(Exception.class, (exception, request, response) -> {
            System.out.println(exception.getStackTrace());
        });
    }
}
