package upsd.product;

import upsd.reviews.ReviewDTO;

import java.util.List;
import java.util.Objects;

public class ProductDTO {

    private final String description;
    private final int numberOfUnits;
    private final double price;
    private final List<ReviewDTO> reviews;

    public ProductDTO(String description, int numberOfUnits, double price, List<ReviewDTO> reviews) {
        this.description = description;
        this.numberOfUnits = numberOfUnits;
        this.price = price;
        this.reviews = reviews;
    }

    public String description() {
        return description;
    }

    public int numberOfUnits() {
        return numberOfUnits;
    }

    public double price() {
        return price;
    }

    public List<ReviewDTO> reviews() {
        return reviews;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDTO that = (ProductDTO) o;
        return numberOfUnits == that.numberOfUnits &&
                Double.compare(that.price, price) == 0 &&
                Objects.equals(description, that.description) &&
                Objects.equals(reviews, that.reviews);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, numberOfUnits, price, reviews);
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "description='" + description + '\'' +
                ", numberOfUnits=" + numberOfUnits +
                ", price=" + price +
                ", reviews=" + reviews +
                '}';
    }
}
