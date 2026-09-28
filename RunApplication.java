package consolesales;

import java.util.Scanner;

public class RunApplication {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // The console types that  the user can choose from.
        String[] consoleTypes = {"PS5", "XBOX", "Nintendo SWITCH"};

        //  This keeps the total of all the sales that get entered.
        int allSales = 0;
        String again;

        do {
            // Shows the menu using a loop.
            System.out.println("Select a console device type:");
            for (int i = 0; i < consoleTypes.length; i++) {
                System.out.println((i + 1) + ". " + consoleTypes[i]);
            }

            int choice = getChoice(input, consoleTypes.length);
            String storeName = getStoreName(input);
            int totalSales = getSales(input);

            // making the ConsoleSales object with what the user entered.
            ConsoleSales sale = new ConsoleSales(consoleTypes[choice - 1], storeName, totalSales);
            sale.printReport();

            allSales += sale.getTotalSales();

            System.out.print("Do you want to capture another sale? (y/n): ");
            again = input.nextLine().trim();

        } while (again.equalsIgnoreCase("y"));

        System.out.println("Total sales for everything captured: " + allSales);
        input.close();
    }

    // This is to keep asking until the user picks a number that is on the menu.
    private static int getChoice(Scanner input, int max) {
        int choice = 0;
        boolean valid = false;

        while (!valid) {
            System.out.print("Enter your choice: ");
            try {
                choice = Integer.parseInt(input.nextLine().trim());
                if (choice >= 1 && choice <= max) {
                    valid = true;
                } else {
                    System.out.println("Please pick a number between 1 and " + max);
                }
            } catch (NumberFormatException e) {
                System.out.println("That is not a number, try again.");
            }
        }
        return choice;
    }

    // Keeps asking until the store name is not empty,
    private static String getStoreName(Scanner input) {
        String name = "";

        while (name.isEmpty()) {
            System.out.print("Enter the store name: ");
            name = input.nextLine().trim();
            if (name.isEmpty()) {
                System.out.println("The store name cannot be empty.");
            }
        }
        return name;
    }

    // This is for asking until the sales amount is a number that is not negative.
    private static int getSales(Scanner input) {
        int sales = -1;

        while (sales < 0) {
            System.out.print("Enter the total amount of sales: ");
            try {
                sales = Integer.parseInt(input.nextLine().trim());
                if (sales < 0) {
                    System.out.println("Sales cannot be negative.");
                }
            } catch (NumberFormatException e) {
                System.out.println("That is not a valid number, try again.");
            }
        }
        return sales;
    }
}
