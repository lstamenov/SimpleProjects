import java.util.List;

public class Library {
    private List<Book> availableBooks;
    private List<Customer> customers;
    private Bank account;
    private UnavailableBooks unavailableBooks;

    Library(List<Book> availableBooks, List<Customer> customers, Bank account, UnavailableBooks unavailableBooks){
        this.availableBooks = availableBooks;
        this.customers = customers;
        this.account = account;
        this.unavailableBooks = unavailableBooks;
    }

    public Bank getAccount() {
        return account;
    }

    public List<Book> getAvailableBooks() {
        return availableBooks;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public UnavailableBooks getUnavailableBooks() {
        return unavailableBooks;
    }

    public void addBook(Book book){
        this.availableBooks.add(book);
    }

    public void rentBook(Book book){
        this.availableBooks.remove(book);
        this.unavailableBooks.rentBook(book);
    }

    public void sellBook(Book book){
        this.availableBooks.remove(book);
        this.unavailableBooks.sellBook(book);
    }

    public Object getBook(String title){
        for (Book book : availableBooks) {
            if (book.getName().equals(title)){
                return book;
            }
        }
        return "No such book exists";
    }

    public Object getCostumer(String name){
        for (Customer c : customers) {
            if (c.getName().equals(name)){
                return c;
            }
        }
        return "No such costumer exists";
    }

    public void updateCostumer(Customer customer){
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getName().equals(customer.getName())){
                customers.set(i, customer);
            }
        }
    }

}
