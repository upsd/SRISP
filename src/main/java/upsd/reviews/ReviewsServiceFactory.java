package upsd.reviews;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class ReviewsServiceFactory {

    private final HashMap<Integer, List<ReviewDTO>> reviewsToAdd;

    public ReviewsServiceFactory(HashMap<Integer, List<ReviewDTO>> reviewsToAdd) {
        this.reviewsToAdd = reviewsToAdd;
    }

    public ReviewsService build() {
        HashMap<Integer, List<Review>> reviews = new HashMap<>();

        this.reviewsToAdd.entrySet().stream().forEach(e -> reviews.put(e.getKey(), reviewFrom(e.getValue())));

        return new ReviewsService(new ReviewsRepository(reviews));
    }

    private List<Review> reviewFrom(List<ReviewDTO> reviews) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return reviews.stream()
                .map(r -> new Review(r.id(), r.text(), LocalDate.parse(r.creationDate(), formatter)))
                .collect(Collectors.toList());
    }
}
