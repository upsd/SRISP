package upsd.acceptance;

import org.junit.BeforeClass;
import org.junit.Test;
import upsd.api.ProductAPI;
import upsd.price.PriceServiceFactory;
import upsd.product.ProductDTO;
import upsd.product.ProductServiceFactory;
import upsd.reviews.ReviewDTO;
import upsd.reviews.ReviewsServiceFactory;
import upsd.stock.StockServiceFactory;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.get;
import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static upsd.helpers.JsonCreator.productJsonFrom;

public class AT_GetProduct {

    private static List<ReviewDTO> REVIEWS = asList(new ReviewDTO(1234, "I loved this product", "12/01/2018"));
    private static ProductDTO PRODUCT = new ProductDTO("Some product", 1002, 12.32, REVIEWS);

    @BeforeClass
    public static void setUp() {
        HashMap<Integer, BigDecimal> prices;
        prices = new HashMap<>();
        prices.put(1001, new BigDecimal(12.32));

        HashMap<Integer, List<ReviewDTO>> reviews = new HashMap<>();
        reviews.put(1001, REVIEWS);

        HashMap<Integer, String> products = new HashMap<>();
        products.put(1001, "Some product");

        HashMap<Integer, Integer> stockLevels = new HashMap<>();
        stockLevels.put(1001, 1002);


        ProductAPI productAPI = new ProductAPI(new ProductServiceFactory(products, new PriceServiceFactory(prices), new ReviewsServiceFactory(reviews), new StockServiceFactory(stockLevels)));
        productAPI.startOn(8080);
    }

    @Test
    public void return_200_and_specified_product() {
        get("/products/1001").then()
                .statusCode(200)
                .body(is(productJsonFrom(PRODUCT).toString()));
    }
}
