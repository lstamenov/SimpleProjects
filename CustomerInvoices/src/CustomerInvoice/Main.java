package CustomerInvoice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random randomID = new Random(1000000000);
        List<Invoice> invoices = new ArrayList<>();
        List<Customer> customers = new ArrayList<>();

        String customerData = scanner.nextLine();
        while (!customerData.equals("end")){
            String[] data = customerData.split("\\s+");

            String name = data[0];
            int id = randomID.nextInt();
            int accountID = randomID.nextInt();
            double balance = Double.parseDouble(data[1]);
            CustomerAccount customerAccount = new CustomerAccount(accountID, balance);
            Customer customer = new Customer(id, name, customerAccount);
            customers.add(customer);

            customerData = scanner.nextLine();
        }

        String input = scanner.nextLine();
        while (!input.equals("end")){
            String[] commandData = input.split("\\s+");

            String command = commandData[0];

            if (command.equals("Show")){
                String customerName = commandData[1];
                if (isSuchCustomer(customerName, customers) != -1){
                    Customer customer = customers.get(isSuchCustomer(customerName, customers));
                    System.out.printf("Customer: %s%n" +
                            "   ID: %d%n" +
                            "       Balance: %.2f$%n",customer.getName(), customer.getId(), customer.getCustomerAccount().getBalance());
                }else {
                    System.out.printf("%s is not a valid user.%n",customerName);
                }
            }else if (command.equals("Invoice")){
                String customerName = commandData[1];
                if (isSuchCustomer(customerName, customers) != -1){
                    Customer customer = customers.get(isSuchCustomer(customerName, customers));
                    Invoice invoice = new Invoice(randomID.nextInt(), customer, Double.parseDouble(commandData[2]));
                    invoices.add(invoice);
                    customers.set(isSuchCustomer(customerName, customers), customer);
                }else {
                    System.out.printf("%s is not a valid user.%n",customerName);
                }
            }


            input = scanner.nextLine();
        }
        customers.forEach(customer -> {
                    System.out.printf("Customer: %s%n" +
                            "   ID: %d%n" +
                            "       Balance: %.2f$%n",customer.getName(), customer.getId(), customer.getCustomerAccount().getBalance());
                });
        invoices.forEach(invoice -> {
            System.out.printf("Customer: %s%n" +
                    "   ID: %d%n" +
                    "       Balance: %.2f$%n",invoice.getCustomer().getName(), invoice.getId(), invoice.getAmount());
        });
    }

    private static int isSuchCustomer(String customerName, List<Customer> customers) {
        for (Customer c : customers) {
            if (c.getName().equals(customerName)){
                return customers.indexOf(c);
            }
        }
        return -1;
    }
}
