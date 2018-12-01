package upsd.product;

import upsd.price.PriceServiceFactory;
import upsd.reviews.ReviewsServiceFactory;
import upsd.stock.StockServiceFactory;

import java.util.HashMap;

public class ProductServiceFactory {

    private HashMap<Integer, String> products;
    private final PriceServiceFactory priceServiceFactory;
    private final ReviewsServiceFactory reviewsServiceFactory;
    private final StockServiceFactory stockServiceFactory;

    public ProductServiceFactory(HashMap<Integer, String> products, PriceServiceFactory priceServiceFactory, ReviewsServiceFactory reviewsServiceFactory, StockServiceFactory stockServiceFactory) {
        this.products = products;
        this.priceServiceFactory = priceServiceFactory;
        this.reviewsServiceFactory = reviewsServiceFactory;
        this.stockServiceFactory = stockServiceFactory;
    }

    ProductService build() {
        HashMap<Integer, Product> products = new HashMap<>();

        this.products.entrySet().stream()
                .forEach(entry -> products.put(entry.getKey(), new Product(entry.getValue())));

        return new ProductService(new ProductRepository(products), priceServiceFactory.build(), reviewsServiceFactory.build(), stockServiceFactory.build());
    }
}
