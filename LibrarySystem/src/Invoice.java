public class Invoice {
    Library library;
    Customer customer;
    Discount discount;
    Book book;

    Invoice(Library library, Customer customer, Discount discount, Book book){
        this.library = library;
        this.customer = customer;
        this.discount = discount;
        this.book = book;
    }

    public void getRentInvoice(){
        if (customer.getAccount().getBalance() >= book.getPrice() - discount.getRentalDiscount()){
            customer.getAccount().setBalance(customer.getAccount().getBalance() + book.getPrice() - (book.getPrice()) - discount.getRentalDiscount());
            library.getAccount().setBalance(library.getAccount().getBalance() - (book.getPrice() - (book.getPrice()) - discount.getRentalDiscount()));
            library.rentBook(book);
            customer.rentBook(book);
            library.updateCostumer(customer);
        }else {
            System.out.println("Not enough money!");
        }
    }

    public void getSoldInvoice(){
        if (customer.getAccount().getBalance() >= book.getPrice()){
            customer.getAccount().setBalance(customer.getAccount().getBalance() - (book.getPrice() - (book.getPrice()) - discount.getDiscount()));
            library.getAccount().setBalance(library.getAccount().getBalance() + book.getPrice() - (book.getPrice()) - discount.getDiscount());
            library.sellBook(book);
            customer.buyBook(book);
            library.updateCostumer(customer);
        }else {
            System.out.println("Not enough money!");
        }
    }
}
