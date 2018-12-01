package upsd;

import upsd.api.ProductAPI;
import upsd.price.PriceServiceFactory;
import upsd.product.ProductServiceFactory;
import upsd.reviews.ReviewDTO;
import upsd.reviews.ReviewsServiceFactory;
import upsd.stock.StockServiceFactory;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

import static java.util.Arrays.asList;

public class App {

    public static void main(String[] args) {
        HashMap<Integer, BigDecimal> prices;
        prices = new HashMap<>();
        prices.put(1001, new BigDecimal(12.32));

        HashMap<Integer, List<ReviewDTO>> reviews = new HashMap<>();
        reviews.put(1001, asList(new ReviewDTO(1234, "I loved this product", "12/01/2018")));

        HashMap<Integer, String> products = new HashMap<>();
        products.put(1001, "Some product");

        HashMap<Integer, Integer> stockLevels = new HashMap<>();
        stockLevels.put(1001, 1002);


        ProductAPI productAPI = new ProductAPI(new ProductServiceFactory(products, new PriceServiceFactory(prices), new ReviewsServiceFactory(reviews), new StockServiceFactory(stockLevels)));
        productAPI.startOn(8080);
    }
}
