package upsd.price;

import java.math.BigDecimal;
import java.util.HashMap;

public class PriceServiceFactory {

    private final HashMap<Integer, BigDecimal> prices;

    public PriceServiceFactory(HashMap<Integer, BigDecimal> prices) {
        this.prices = prices;
    }

    public PriceService build() {
        return new PriceService(new PriceRepository(prices));
    }
}
