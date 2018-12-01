package upsd.stock;

import java.util.HashMap;

public class StockServiceFactory {

    private final HashMap<Integer, Integer> stockLevels;

    public StockServiceFactory(HashMap<Integer, Integer> stockLevels) {
        this.stockLevels = stockLevels;
    }

    public StockService build() {
        return new StockService(new StockRepository(stockLevels));
    }
}
