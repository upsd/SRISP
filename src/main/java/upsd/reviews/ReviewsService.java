package upsd.reviews;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class ReviewsService {

    private final ReviewsRepository reviewsRepository;

    ReviewsService(ReviewsRepository reviewsRepository) {
        this.reviewsRepository = reviewsRepository;
    }

    public List<ReviewDTO> getReviewsFor(int productId) {
        List<Review> reviews = reviewsRepository.getFor(productId);

        return reviews.stream()
                .map(r -> new ReviewDTO(r.id(), r.text(), dateAsString(r.creationDate())))
                .collect(Collectors.toList());
    }

    private String dateAsString(LocalDate creationDate) {
        return creationDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}
