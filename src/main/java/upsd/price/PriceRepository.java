package upsd.price;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Optional;

class PriceRepository {

    private final HashMap<Integer, BigDecimal> prices;

    PriceRepository(HashMap<Integer, BigDecimal> prices) {
        this.prices = prices;
    }

    public PriceRepository() {
        this.prices = new HashMap<>();
    }

    Optional<BigDecimal> getPriceBy(int productId) {
        return Optional.of(prices.get(productId));
    }
}
