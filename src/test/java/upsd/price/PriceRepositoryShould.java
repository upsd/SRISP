package upsd.price;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PriceRepositoryShould {

    private static final BigDecimal PRICE = new BigDecimal(20.);
    private HashMap<Integer, BigDecimal> prices;
    private PriceRepository priceRepository;

    @Before
    public void setUp() {
        prices = new HashMap<>();
        prices.put(2, PRICE);

        priceRepository = new PriceRepository(prices);
    }

    @Test
    public void get_price_for_given_id() {
        Optional<BigDecimal> priceFound = priceRepository.getPriceBy(2);


        assertThat(priceFound.get(), is(PRICE));
    }
}
