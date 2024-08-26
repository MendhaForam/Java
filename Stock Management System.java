import java.util.*;
class StockPortfolioManager {
    static int MAX_CUSTOMERS = 5;
    static int MAX_STOCKS = 3;
    
    static class Stock {
        String name;
        double price;
        int quantity;
        
        Stock(String name, double price, int quantity) {
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }
        
        String getName() {
            return name;
        }
        
        double getPrice() {
            return price;
        }
        
        int getQuantity() {
            return quantity;
        }
        
        double getValue() {
            return price * quantity;
        }
    }
    
    static class Customer {
        String name;
        Stock[] stocks;
        
        Customer(String name) {
            this.name = name;
            this.stocks = new Stock[MAX_STOCKS];
        }
        
        String getName() {
            return name;
        }
        
        boolean addStock(Stock stock) {
            for (int i = 0; i < stocks.length; i++) {
                if (stocks[i] == null) {
                    stocks[i] = stock;
                    return true;
                }
            }
            return false;
        }
        
        boolean removeStock(String name) {
            for (int i = 0; i < stocks.length; i++) {
                if (stocks[i] != null && stocks[i].getName().equals(name)) {
                    stocks[i] = null;
                    return true;
                }
            }
            return false;
        }
        
        double getPortfolioValue() {
            double value = 0.0;
            for (int i = 0; i < stocks.length; i++) {
                if (stocks[i] != null) {
                    value += stocks[i].getValue();
                }
            }
            return value;
        }
    }
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Customer[] customers = new Customer[MAX_CUSTOMERS];
        
        while (true) {
            System.out.println("\n");
            System.out.println("Welcome to Stock Portfolio Manager:");
            System.out.println("Choose from the given option to continue further operations:");
            System.out.println("1: Add customer");
            System.out.println("2: Add stock for customer");
            System.out.println("3: Remove stock for customer");
            System.out.println("4: Get portfolio value for customer");
            System.out.println("5: Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            
            if (choice == 1) {
                System.out.print("Enter customer name: ");
                String name = sc.nextLine();
                boolean added = false;
                for (int i = 0; i < customers.length; i++) {
                    if (customers[i] == null) {
                        customers[i] = new Customer(name);
                        added = true;
                        break;
                    }
                }
                if (!added) {
                    System.out.println("Maximum number of customers reached.");
                }
            }       
            else if (choice == 2) 
            {
                    System.out.print("Enter customer name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter stock name: ");
                    String stockName = sc.nextLine();
                    System.out.print("Enter stock price: ");
                    double price = sc.nextDouble();
                    System.out.print("Enter stock quantity: ");
                    int quantity = sc.nextInt();
                    sc.nextLine();
				    boolean found = false;
				    for (int i = 0; i < customers.length; i++) {
				    if (customers[i] != null && customers[i].getName().equals(name)) {
				    found = customers[i].addStock(new Stock(stockName, price, quantity));
				    break;
			    }
		    }
		    if (!found) {
		    System.out.println("Customer not found.");
		    }
		    else if (!found) {
		    System.out.println("Maximum number of stocks reached.");
		    }
	    }
		    else if (choice == 3) {
		    System.out.print("Enter customer name: ");
		    String name = sc.nextLine();
		    System.out.print("Enter stock name: ");
		    String stockName = sc.nextLine();
		    boolean found = false;
		    for (int i = 0; i < customers.length; i++) {
		    if (customers[i] != null && customers[i].getName().equals(name)) {
		    found = customers[i].removeStock(stockName);
		    break;
		    }
	    }
		    if (!found) {
		    System.out.println("Customer or stock not found.");
		    }
	    }
		    else if (choice == 4) {
		    System.out.print("Enter customer name: ");
		    String name = sc.nextLine();
		    boolean found = false;
		    for (int i = 0; i < customers.length; i++) {
		    if (customers[i] != null && customers[i].getName().equals(name)) {
		    System.out.println("Portfolio value: " + customers[i].getPortfolioValue());
		    found = true;
		    break;
		    }
	    }
		    if (!found) {
		    System.out.println("Customer not found.");
		    }
	    }
		    else if (choice == 5) {
		    break;
	    }
	    	else {
	    	System.out.println("Invalid choice.");
	    }
	    	System.out.println();
	    }
	}
}