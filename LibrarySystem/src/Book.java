import java.util.Random;

public class Book {
    private final String name;
    private final int pagesSize;
    private final double price;
    int id;
    int timesIssued = 0;
    private final String author;

    Book(String name, int pagesSize, double price, String author){
        this.name = name;
        this.pagesSize = pagesSize;
        this.price = price;
        this.author = author;
        Random random = new Random(1000000000);
        this.id = random.nextInt();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public int getPagesSize() {
        return pagesSize;
    }

    public int getTimesIssued() {
        return timesIssued;
    }

    public void incrementIssues(){
        this.timesIssued += 1;
    }

    @Override
    public String toString() {
        return String.format("Title: %s%n" +
                "   Author: %s%n" +
                "   Price: %.2f%n" +
                "   ID: %d%n",getName(), getAuthor(), getPrice(), getId());
    }
}
