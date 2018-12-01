package upsd.reviews;

import java.util.Objects;

public class ReviewDTO {

    private final int id;
    private final String text;
    private final String creationDate;

    public ReviewDTO(int id, String text, String creationDate) {
        this.id = id;
        this.text = text;
        this.creationDate = creationDate;
    }

    public int id() {
        return id;
    }

    public String text() {
        return text;
    }

    public String creationDate() {
        return creationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReviewDTO reviewDTO = (ReviewDTO) o;
        return id == reviewDTO.id &&
                Objects.equals(text, reviewDTO.text) &&
                Objects.equals(creationDate, reviewDTO.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, text, creationDate);
    }

    @Override
    public String toString() {
        return "ReviewDTO{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", creationDate='" + creationDate + '\'' +
                '}';
    }
}
