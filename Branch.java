import java.util.ArrayList;

public class Branch {
    private String branchName;
    private ArrayList<Customer> customers;

    public Branch(String branchName) {
        this.branchName = branchName;
        this.customers = new ArrayList<Customer>();
    }

    public String getName() {
        return branchName;
    }

    public Customer addCustomer(String name, double initialTransactionAmount) {
        if (findCustomerIndex(name) >= 0) {
            System.out.println("Sorry, a customer by that name already exists.  Transaction Cancelled");
            return null;
        }
        Customer newCustomer = Customer.initCustomer(name, initialTransactionAmount);
        customers.add(newCustomer);
        return newCustomer;
    }

    public boolean addTransaction(String name, double transactionAmount) {
        int customerIndex = findCustomerIndex(name);
        if (customerIndex < 0) {
            System.out.println("Sorry, customer not found in our records.  Transaction cancelled");
            return false;
        }
        customers.get(customerIndex).transact(transactionAmount);
        System.out.println("Transaction successful");
        return true;
    }

    private int findCustomerIndex(String name) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public void showCustomers() {
        System.out.println("Customers: ");
        for (Customer customer : customers) {
            customer.showCustomer();
        }
    }
}