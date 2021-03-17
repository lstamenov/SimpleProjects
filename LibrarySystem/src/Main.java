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

        System.out.println("Enter book in the format: Title, pages, price, Author");
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

        System.out.println("Enter command");
        String command = scanner.nextLine();
        while (!command.equals("close library")){
            String[] commandData = command.split(", ");
            String action = commandData[0];

            switch (action){
                case "Show customers with rented books":
                    library.getCustomers().stream()
                            .filter(customer -> customer.getBooks().size() > 0)
                            .forEach(customer -> {
                                System.out.println("Name: " + customer.getName());
                                customer.getBooks()
                                        .forEach(book1 -> System.out.println("-- " + book1.getName()));
                            });
                    break;
                case "Buy book":
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
                        invoice.getSoldInvoice();
                        library.updateCostumer(costumer);
                    }
                    break;
                case "Rent book":
                    String bookToRent = commandData[1];
                    String customerToRent = commandData[2];

                    if (isSuchBook(bookToRent, library.getAvailableBooks())){
                        if (!isSuchCostumer(customerToRent, library)){
                            System.out.println("No such costumer!");
                            System.out.println("Enter costumer details in the following format: age, balance");
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
                    }
                    break;
                case "Return book":
                    String bookToReturn = commandData[1];
                    String customerToReturn = commandData[2];
                    Customer customer = (Customer) library.getCostumer(customerToReturn);
                    if (isSuchBook(bookToReturn, library.getUnavailableBooks().getRentedBooks()) && isSuchCostumer(customerToReturn, library)){
                        if (customer.isSuchBook(bookToReturn)){
                            Book book1 = (Book) customer.getBook(bookToReturn);
                            customer.returnBook(book1, library);
                            library.updateCostumer(customer);
                        }
                    }else {
                        System.out.println("False book or customer");
                    }
                    break;
                case "Library statistics":
                    System.out.println("Library System");
                    String inputCommand = scanner.nextLine();
                    if (inputCommand.equals("List Available books")) {
                        System.out.println("     -Available books:");
                        library.getAvailableBooks().
                                forEach(book1 -> System.out.println("       -" + book1.getName() + "-" + book1.getAuthor() + " " + book1.getPrice()));
                    }else if (inputCommand.equals("List Unavailable books")) {
                        System.out.println("     -Unavailable books:");
                        library.getUnavailableBooks().getSoldBooks().
                                forEach(book1 -> System.out.println("       -" + book1.getName() + "-" + book1.getAuthor() + " " + book1.getPrice()));
                    }else if (inputCommand.equals("List customers")){
                        System.out.println("    -Customers:");
                        library.getCustomers()
                                .forEach(customer1 -> System.out.println(customer1.toString()));
                    }else if (inputCommand.equals("List Library Data")){
                        System.out.println("     -Library Data:");
                        System.out.printf("         Balance: %.2f, %n" +
                                "       Available books: %d, %n" +
                                "       Unavailable books: %d, %n", library.getAccount().getBalance(),
                                library.getAvailableBooks().size(), library.getUnavailableBooks().getRentedBooks().size());
                    }
            }
            System.out.println("Enter command");
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
