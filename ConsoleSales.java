package consolesales;

// This is a Subclass of Console
public class ConsoleSales extends Console {

    // The constructor just sends the values up to the Console class.
    public ConsoleSales(String consoleType, String store, int totalSales) {
        super(consoleType, store, totalSales);
    }

    // This is to print the report for one console at one store.
    @Override
    public void printReport() {
        System.out.println();
        System.out.println("===== NUMBER 1 ELECTRONICS SALES REPORT =====");
        System.out.println("Console type: " + getConsoleType());
        System.out.println("Store name:   " + getStore());
        System.out.println("Total sales:  " + getTotalSales());
        System.out.println("=============================================");
        System.out.println();
    }
}
