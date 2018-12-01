package upsd.stock;

public class StockService {

    private final StockRepository stockRepository;

    StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public int getStockFor(int id) {
        return stockRepository.getStockFor(id);
    }
}
