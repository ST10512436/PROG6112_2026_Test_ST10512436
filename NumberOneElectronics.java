package numberoneelectronics;

public class NumberOneElectronics {

    public static void main(String[] args) {

        // This is for the single dimensional arrays for city names as well as the console names.
        String[] cities = {"Cape Town", "Port Elizabeth", "Pretoria"};
        String[] consoles = {"PS5", "XBOX", "Nintendo SWITCH"};

        // These are two dimensional array, each row is a city and each column is a console.
        
        
        int[][] sales = {
            {1000, 2000, 3000},
            {2000, 3000, 4000},
            {1500, 1100, 1200}
        };

        // This array will keep the total sales for the cities.
        int[] cityTotals = new int[cities.length];

        // The code below is the working out the total for each city.
        for (int i = 0; i < cities.length; i++) {
            for (int j = 0; j < consoles.length; j++) {
                cityTotals[i] += sales[i][j];
            }
        }

        // Finds out which city sold the most.
        int topCity = 0;
        for (int i = 1; i < cities.length; i++) {
            if (cityTotals[i] > cityTotals[topCity]) {
                topCity = i;
            }
        }

        // This is for printing the the report.
        System.out.println("===== NUMBER 1 ELECTRONICS YEARLY SALES REPORT =====");
        System.out.println();

        for (int i = 0; i < cities.length; i++) {
            System.out.println("City: " + cities[i]);

            for (int j = 0; j < consoles.length; j++) {
                System.out.printf("   %-16s %d%n", consoles[j], sales[i][j]);
            }

            System.out.println("   Total sales:     " + cityTotals[i]);
            System.out.println();
        }

        System.out.println("City with the most gaming console sales: " + cities[topCity]);
        System.out.println("Total sales for " + cities[topCity] + ": " + cityTotals[topCity]);
    }
}
