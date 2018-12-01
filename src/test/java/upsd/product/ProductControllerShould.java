package upsd.product;

import org.junit.Before;
import org.junit.Test;
import spark.Request;
import spark.Response;

import java.util.Optional;

import static java.util.Collections.emptyList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static upsd.helpers.JsonCreator.productJsonFrom;

public class ProductControllerShould {

    private ProductController productController;
    private Request request;
    private Response response;
    private ProductService service;

    @Before
    public void setUp() {
        service = mock(ProductService.class);
        ProductServiceFactory productServiceFactory = mock(ProductServiceFactory.class);
        given(productServiceFactory.build()).willReturn(service);

        productController = new ProductController(productServiceFactory);
        request = mock(Request.class);
        response = mock(Response.class);
    }

    @Test
    public void return_product_and_set_content_type() {
        ProductDTO product = new ProductDTO("some product", 12, 12.34, emptyList());

        given(service.getBy(1)).willReturn(Optional.of(product));
        given(request.params(":id")).willReturn("1");


        String body = productController.getById(request, response);


        verify(response).type("application/json");
        assertThat(body, is(productJsonFrom(product).toString()));
    }
}
