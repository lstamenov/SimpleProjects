import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Book> books = new ArrayList<>();
        List<Customer> customers = new ArrayList<>();
        Bank libraryBank = new Bank(0.0);
        List<Book> rentedBooks = new ArrayList<>();
        List<Book> soldBooks = new ArrayList<>();
        UnavailableBooks unavailableBooks = new UnavailableBooks(rentedBooks, soldBooks);
        Library library = new Library(books, customers, libraryBank, unavailableBooks);

        Book book = new Book("Tale", 300, 10.50, "DoraGabe");
        library.addBook(book);

        String input = scanner.nextLine();
        while (!input.equals("stop")){
            String[] bookDetails = input.split(", ");

            String title = bookDetails[0];
            int pagesSize = Integer.parseInt(bookDetails[1]);
            double price = Double.parseDouble(bookDetails[2]);
            String author = bookDetails[3];

            Book newBook = new Book(title, pagesSize, price, author);
            library.addBook(newBook);

            input = scanner.nextLine();
        }

        String command = scanner.nextLine();
        while (!command.equals("close library")){
            String[] commandData = command.split(", ");
            String action = commandData[0];

            switch (action){
                case "Show":
                    library.getCustomers().stream()
                            .filter(customer -> customer.getBooks().size() > 0)
                            .forEach(customer -> {
                                System.out.println("Name: " + customer.getName());
                                customer.getBooks()
                                        .forEach(book1 -> System.out.println("-- " + book1.getName()));
                            });
                    break;
                case "Buy":
                    String bookToBuy = commandData[1];
                    String customerToBuy = commandData[2];

                    if (isSuchBook(bookToBuy, library.getAvailableBooks())){
                        if (!isSuchCostumer(customerToBuy, library)){
                            System.out.println("No such costumer!");
                            System.out.println("Enter costumer details!");
                            String[] costumerDetails = scanner.nextLine().split(", ");
                            int age = Integer.parseInt(costumerDetails[0]);
                            double balance = Double.parseDouble(costumerDetails[1]);

                            List<Book> bookList = new ArrayList<>();
                            Bank account = new Bank(balance);
                            Customer customer = new Customer(customerToBuy,bookList,age,account);
                            library.getCustomers().add(customer);
                        }
                        Customer costumer = (Customer) library.getCostumer(customerToBuy);
                        Book book1 = (Book) library.getBook(bookToBuy);
                        Discount discount = new Discount(book1.getPrice(), costumer.getBooksIssued());
                        Invoice invoice = new Invoice(library, costumer, discount, book1);
                        invoice.getSoldInvoice(costumer,library, book1, discount);
                        library.updateCostumer(costumer);
                    }
                    break;
                case "Rent":
                    String bookToRent = commandData[1];
                    String customerToRent = commandData[2];

                    if (isSuchBook(bookToRent, library.getAvailableBooks())){
                        if (!isSuchCostumer(customerToRent, library)){
                            System.out.println("No such costumer!");
                            System.out.println("Enter costumer details!");
                            String[] costumerDetails = scanner.nextLine().split(", ");
                            int age = Integer.parseInt(costumerDetails[0]);
                            double balance = Double.parseDouble(costumerDetails[1]);

                            List<Book> bookList = new ArrayList<>();
                            Bank account = new Bank(balance);
                            Customer customer = new Customer(customerToRent,bookList,age,account);
                            library.getCustomers().add(customer);
                        }
                        Customer costumer = (Customer) library.getCostumer(customerToRent);
                        Book book1 = (Book) library.getBook(bookToRent);
                        Discount discount = new Discount(book1.getPrice(), costumer.getBooksIssued());
                        Invoice invoice = new Invoice(library, costumer, discount, book1);
                        invoice.getRentInvoice();
                        library.updateCostumer(costumer);
                    }
                    break;
                case "Return":

            }
            command = scanner.nextLine();
        }
    }

    private static boolean isSuchCostumer(String customerToBuy, Library library) {
        for (Customer c : library.getCustomers()) {
            if (c.getName().equals(customerToBuy)){
                return true;
            }
        }
        return false;
    }

    private static boolean isSuchBook(String bookToBuy, List<Book> availableBooks) {
        for (Book book : availableBooks) {
            if (book.getName().equals(bookToBuy)){
                return true;
            }
        }
        return false;
    }
}
