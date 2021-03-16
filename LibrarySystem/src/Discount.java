public class Discount {
    private final double price;
    private final int booksIssued;

    Discount(double price, int booksIssued){
        this.price = price;
        this.booksIssued = booksIssued;
    }

    public double getDiscount(){
        return price * (0.2 * booksIssued);
    }

    public double getRentalDiscount(){
        return price / 4;
    }
}
