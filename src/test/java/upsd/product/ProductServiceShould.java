package upsd.product;

import org.junit.Before;
import org.junit.Test;
import upsd.price.PriceService;
import upsd.reviews.ReviewsService;
import upsd.stock.StockService;

import java.math.BigDecimal;
import java.util.Optional;

import static java.util.Collections.emptyList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class ProductServiceShould {

    private ProductService productService;
    private PriceService priceService;
    private ReviewsService reviewsService;
    private ProductRepository productRepository;
    private StockService stockService;

    @Before
    public void setUp() {
        priceService = mock(PriceService.class);
        reviewsService = mock(ReviewsService.class);
        productRepository = mock(ProductRepository.class);
        stockService = mock(StockService.class);

        productService = new ProductService(productRepository, priceService, reviewsService, stockService);
    }

    @Test
    public void return_product_details_for_given_product_id() {
        given(priceService.getPriceFor(1)).willReturn(Optional.of(new BigDecimal(10.)));
        given(reviewsService.getReviewsFor(1)).willReturn(emptyList());
        given(productRepository.getBy(1)).willReturn(Optional.of(new Product("some product")));
        given(stockService.getStockFor(1)).willReturn(2);


        Optional<ProductDTO> productFound = productService.getBy(1);


        ProductDTO expectedProduct = new ProductDTO("some product", 2, 10., emptyList());
        assertThat(productFound.get(), is(expectedProduct));
    }
}
