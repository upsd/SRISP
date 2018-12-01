package upsd.price;

import java.math.BigDecimal;
import java.util.Optional;

public class PriceService {

    private final PriceRepository priceRepository;

    PriceService(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    public Optional<BigDecimal> getPriceFor(int productId) {
        return priceRepository.getPriceBy(productId);
    }
}
