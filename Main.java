import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Bank bank = new Bank("WonderBank");

    public static void main(String[] args) {
        boolean quit = false;
        while (!quit) {
            System.out.println("Choose your menu option, or press 6 to view options");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
            case 1:
                addBranch();
                break;
            case 2:
                addCustomer();
                break;
            case 3:
                addTransaction();
                break;
            case 4:
                listBranches();
                break;
            case 5:
                listCustomers();
                break;
            case 6:
                showMenu();
                break;
            case 7:
                quit = true;
                break;
            default:
                showMenu();
                break;
            }
        }
        System.out.println("thank you!");
    }

    private static void addBranch() {
        System.out.println("Enter new branch name: ");
        String branchName = scanner.nextLine();
        bank.openNewBranch(branchName);
    }

    private static void addCustomer() {
        System.out.println("Branch name: ");
        String branchName = scanner.nextLine();
        System.out.println("Customer name: ");
        String customerName = scanner.nextLine();
        System.out.println("Initial transaction amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        bank.addBranchCustomer(branchName, customerName, amount);
    }

    private static void addTransaction() {
        System.out.println("Branch name: ");
        String branchName = scanner.nextLine();
        System.out.println("Customer name: ");
        String customerName = scanner.nextLine();
        System.out.println("Initial transaction amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        bank.addBranchTransaction(branchName, customerName, amount);
    }

    private static void listBranches() {
        bank.listBranches();
    }

    private static void listCustomers() {
        System.out.println("Please enter branch name: ");
        String branchName = scanner.nextLine();
        bank.listBranchCustomers(branchName);
    }

    private static void showMenu() {
        System.out.println("Menu options:");
        System.out.println("1 -- add branch\n" + "2 -- add customer to a branch with initial transaction\n"
                + "3 -- add transaction to existing branch customer\n" + "4 -- list branches\n"
                + "5 -- list customers of a branch\n" + "6 -- show menu\n" + "7 -- quit");
        System.out.println();
    }

}