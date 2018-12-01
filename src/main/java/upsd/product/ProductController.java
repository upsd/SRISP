package upsd.product;

import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import spark.Request;
import spark.Response;
import upsd.reviews.ReviewDTO;

import java.util.Optional;

public class ProductController {

    private final ProductService productService;

    public ProductController(ProductServiceFactory productServiceFactory) {
        this.productService = productServiceFactory.build();
    }

    public String getById(Request request, Response response) {
        int id = Integer.parseInt(request.params(":id"));

        Optional<ProductDTO> productFound = productService.getBy(id);


        response.type("application/json");
        return productJsonFrom(productFound.get()).toString();
    }

    private static JsonObject productJsonFrom(ProductDTO product) {
        JsonArray reviews = new JsonArray();

        product.reviews().stream()
                .map(r -> reviewJsonFrom(r))
                .forEach(r -> reviews.add(r));

        return new JsonObject()
                .add("description", product.description())
                .add("number_of_units", product.numberOfUnits())
                .add("price", product.price())
                .add("reviews", reviews);
    }

    private static JsonObject reviewJsonFrom(ReviewDTO review) {
        return new JsonObject()
                .add("id", review.id())
                .add("text", review.text())
                .add("created_at", review.creationDate());
    }
}
