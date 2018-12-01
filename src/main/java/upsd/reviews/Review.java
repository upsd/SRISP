package upsd.reviews;

import java.time.LocalDate;

class Review {

    private final int id;
    private final String description;
    private final LocalDate creationDate;

    Review(int id, String description, LocalDate creationDate) {
        this.id = id;
        this.description = description;
        this.creationDate = creationDate;
    }

    public int id() {
        return id;
    }

    String text() {
        return description;
    }

    LocalDate creationDate() {
        return creationDate;
    }
}
