package upsd.price;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class PriceServiceShould {

    private static final BigDecimal PRICE = new BigDecimal(12.00);
    private PriceRepository priceRepository;
    private PriceService priceService;

    @Before
    public void setUp() {
        priceRepository = mock(PriceRepository.class);
        priceService = new PriceService(priceRepository);
    }

    @Test
    public void get_price_for_specified_product_id() {
        given(priceRepository.getPriceBy(1)).willReturn(Optional.of(PRICE));


        Optional<BigDecimal> price = priceService.getPriceFor(1);


        assertThat(price.get(), is(PRICE));
    }
}
