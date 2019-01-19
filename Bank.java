import java.util.ArrayList;

public class Bank {
    private String bankName;
    private ArrayList<Branch> branches;

    public Bank(String bankName) {
        this.bankName = bankName;
        this.branches = new ArrayList<Branch>();
    }

    public boolean openNewBranch(String branchName) {
        if (findBranchIndex(branchName) >= 0) {
            System.out.println("Sorry, a branch by that name already exists");
            return false;
        }
        Branch newBranch = new Branch(branchName);
        branches.add(newBranch);
        return true;
    }

    private boolean addBranchCustomer(Branch branch, String name, double initialTransaction) {
        Customer newCustomer = branch.addCustomer(name, initialTransaction);
        if (newCustomer == null) {
            System.out.println("Customer " + name + " not added to branch");
            return false;
        } else {
            System.out.println("Customer " + name + " added to branch");
            return true;
        }
    }

    public boolean addBranchCustomer(String branchName, String customerName, double initialTransaction) {
        int branchIndex = findBranchIndex(branchName);
        if (branchIndex < 0) {
            System.out.println("Branch not located.  Transaction cancelled");
            return false;
        }
        return this.addBranchCustomer(branches.get(branchIndex), customerName, initialTransaction);
    }

    public boolean addBranchTransaction(String branchName, String customerName, double transaction) {
        int branchIndex = findBranchIndex(branchName);
        if (branchIndex < 0) {
            System.out.println("Branch Not located.  Transaction cancelled");
            return false;
        } else {
            return branches.get(branchIndex).addTransaction(customerName, transaction);
        }
    }

    private int findBranchIndex(String branchName) {
        for (int i = 0; i < branches.size(); i++) {
            if (branches.get(i).getName().equals(branchName)) {
                return i;
            }
        }
        return -1;
    }

    public void listBranches() {
        for (Branch branch : branches) {
            System.out.println("Branch Name: " + branch.getName());
        }
        System.out.println();
    }

    public void listBranchCustomers(String branchName) {
        int branchIndex = findBranchIndex(branchName);
        if (branchIndex < 0) {
            System.out.println("Sorry, no branch matching " + branchName);
        } else {
            branches.get(branchIndex).showCustomers();
        }
    }
}