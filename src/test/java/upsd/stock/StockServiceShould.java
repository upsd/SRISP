package upsd.stock;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class StockServiceShould {

    private StockRepository stockRepository;
    private StockService stockService;

    @Before
    public void setUp() {
        stockRepository = mock(StockRepository.class);
        stockService = new StockService(stockRepository);
    }

    @Test
    public void get_stock_for_given_product_id() {
        given(stockRepository.getStockFor(1)).willReturn(60);


        int stock = stockService.getStockFor(1);


        assertThat(stock, is(60));
    }
}
