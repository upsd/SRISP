package upsd.helpers;

import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import upsd.product.ProductDTO;
import upsd.reviews.ReviewDTO;

public class JsonCreator {

    public static JsonObject productJsonFrom(ProductDTO product) {
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
