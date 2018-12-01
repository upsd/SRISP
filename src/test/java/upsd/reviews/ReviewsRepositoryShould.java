package upsd.reviews;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertThat;

public class ReviewsRepositoryShould {

    private static final Review REVIEW = new Review(123, "terrible product", LocalDate.of(2017, 03, 12));
    private ReviewsRepository reviewsRepository;

    @Before
    public void setUp() {
        HashMap<Integer, List<Review>> reviews = new HashMap<>();
        reviews.put(3, asList(REVIEW));
        reviewsRepository = new ReviewsRepository(reviews);
    }

    @Test
    public void get_reviews_for_given_product_id() {
        List<Review> reviews = reviewsRepository.getFor(3);


        assertThat(reviews, CoreMatchers.is(asList(REVIEW)));
    }
}
