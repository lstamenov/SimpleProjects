import java.util.List;

public class UnavailableBooks {
    private final List<Book> rentedBooks;
    private final List<Book> soldBooks;

    UnavailableBooks(List<Book> rentedBooks, List<Book> soldBooks){
        this.rentedBooks = rentedBooks;
        this.soldBooks = soldBooks;
    }

    public List<Book> getRentedBooks() {
        return rentedBooks;
    }

    public List<Book> getSoldBooks() {
        return soldBooks;
    }

    public void sellBook(Book book){
        this.soldBooks.add(book);
    }

    public void rentBook(Book book){
        this.rentedBooks.add(book);
    }
}
