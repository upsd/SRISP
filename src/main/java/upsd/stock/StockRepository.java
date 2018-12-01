package upsd.stock;

import java.util.HashMap;

class StockRepository {

    private final HashMap<Integer, Integer> stockLevels;

    StockRepository(HashMap<Integer, Integer> stockLevels) {
        this.stockLevels = stockLevels;
    }

    int getStockFor(int id) {
        return stockLevels.get(id);
    }
}
