import java.util.List;
import java.util.Random;

public class Customer {
    private final String name;
    private List<Book> books;
    private final int age;
    private final Bank account;
    private final int id;
    private int booksIssued = 0;

    Customer(String name, List<Book> books, int age, Bank account){
        this.name = name;
        this.books = books;
        this.age = age;
        this.account = account;
        Random random = new Random(1000000000);
        this.id = random.nextInt();
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public Bank getAccount() {
        return account;
    }

    public int getBooksIssued() {
        return booksIssued;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void incrementBooksIssued(){
        this.booksIssued += 1;
    }

    public void rentBook(Book book) {
        this.books.add(book);
        incrementBooksIssued();
    }

    public void returnBook(Book book, Library library){
        books.remove(book);
        library.addBook(book);
    }

    public void buyBook(Book book) {
        this.books.add(book);
        incrementBooksIssued();
    }

    public boolean isSuchBook(String bookName){
        for ( Book b : books) {
            if (b.getName().equals(bookName)){
                return true;
            }
        }
        return false;
    }

    public Object getBook(String bookName){
        for (Book b : books) {
            if (b.getName().equals(bookName)){
                return b;
            }
        }
        return "No such book is to return!";
    }

    @Override
    public String toString() {
        return String.format("Name: %s%n" +
                "   Age: %d%n" +
                "   ID: %d%n" +
                "   Books issued: %d%n", getName(), getAge(), getId(), getBooksIssued());
    }
}
