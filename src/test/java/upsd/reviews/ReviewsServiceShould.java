package upsd.reviews;

import org.junit.Before;
import org.junit.Test;
import upsd.reviews.Review;
import upsd.reviews.ReviewDTO;
import upsd.reviews.ReviewsRepository;
import upsd.reviews.ReviewsService;

import java.time.LocalDate;
import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class ReviewsServiceShould {

    private ReviewsRepository reviewsRepository;
    private ReviewsService reviewsService;

    @Before
    public void setUp() {
        reviewsRepository = mock(ReviewsRepository.class);
        reviewsService = new ReviewsService(reviewsRepository);
    }

    @Test
    public void get_reviews_for_given_product_id() {
        given(reviewsRepository.getFor(32)).willReturn(asList(new Review(123, "what a great product", LocalDate.of(2017, 02, 12))));


        List<ReviewDTO> reviews = reviewsService.getReviewsFor(32);


        assertThat(reviews, is(asList(new ReviewDTO(123, "what a great product", "12/02/2017"))));
    }
}
