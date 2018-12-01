package upsd.product;

class Product {

    private final String description;

    Product(String description) {
        this.description = description;
    }

    String description() {
        return description;
    }
}
