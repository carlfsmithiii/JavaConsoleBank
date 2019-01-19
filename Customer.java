import java.util.ArrayList;

public class Customer {
    private String name;
    ArrayList<Double> transactions;

    public Customer(String name) {
        this.name = name;
        transactions = new ArrayList<Double>();
    }

    public String getName() {
        return this.name;
    }

    public void transact(double amount) {
        transactions.add(amount);
    }

    public static Customer initCustomer(String name, double amount) {
        Customer newCustomer = new Customer(name);
        newCustomer.transact(amount);
        return newCustomer;
    }

    public Double[] getTransactions() {
        // return (ArrayList<Double>)transactions.clone();
        return transactions.toArray(new Double[transactions.size()]);
    }

    public void showCustomer() {
        System.out.println("Name: " + this.name);
        for (double transaction : this.transactions) {
            System.out.println("\t" + transaction);
        }
    }
}