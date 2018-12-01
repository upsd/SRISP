package upsd.product;

import upsd.price.PriceService;
import upsd.reviews.ReviewDTO;
import upsd.reviews.ReviewsService;
import upsd.stock.StockService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

class ProductService {

    private final ProductRepository productRepository;
    private final PriceService priceService;
    private final ReviewsService reviewsService;
    private final StockService stockService;

    ProductService(ProductRepository productRepository, PriceService priceService, ReviewsService reviewsService, StockService stockService) {
        this.productRepository = productRepository;
        this.priceService = priceService;
        this.reviewsService = reviewsService;
        this.stockService = stockService;
    }

    Optional<ProductDTO> getBy(int id) {
        Product product = productRepository.getBy(id).get();
        Optional<BigDecimal> price = priceService.getPriceFor(id);
        List<ReviewDTO> reviews = reviewsService.getReviewsFor(id);
        int stock = stockService.getStockFor(id);


        return Optional.of(new ProductDTO(product.description(), stock, price.get().doubleValue(), reviews));
    }
}
