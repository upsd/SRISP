package upsd.reviews;

import java.util.HashMap;
import java.util.List;

class ReviewsRepository {

    private final HashMap<Integer, List<Review>> reviews;

    ReviewsRepository(HashMap<Integer, List<Review>> reviews) {
        this.reviews = reviews;
    }

    ReviewsRepository() {
        this.reviews = new HashMap<>();
    }

    List<Review> getFor(int id) {
        return reviews.get(id);
    }
}
