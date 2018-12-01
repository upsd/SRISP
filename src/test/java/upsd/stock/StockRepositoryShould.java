package upsd.stock;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class StockRepositoryShould {

    private StockRepository stockRepository;

    @Before
    public void setUp() {
        HashMap<Integer, Integer> stockLevels = new HashMap<>();
        stockLevels.put(34, 2);

        stockRepository = new StockRepository(stockLevels);
    }

    @Test
    public void get_stock_for_given_product_id() {
        int stock = stockRepository.getStockFor(34);


        assertThat(stock, is(2));
    }
}
