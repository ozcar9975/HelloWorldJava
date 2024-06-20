import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalc {

    public static void main(String[] args) {

        // initialize
        final int yearToMonth = 12;
        final int percentToDecimal = 100;

        int principle = 0;
        float rate = 0;
        int year = 0;
        int months = 0;
        double mortgage = 0;

        Scanner scanner = new Scanner(System.in);
        NumberFormat money = NumberFormat.getCurrencyInstance();

        // gets all inputs + input validations
        do {
            System.out.print("Principle ($1K - $1M): ");
            principle = scanner.nextInt();
            if ((principle >= 1_000) && (principle <= 1_000_000)) {
                break;
            }
            System.out.println("Enter a number between 1,000 and 1,000,000.");
        } while ((principle < 1_000) || (principle > 1_000_000));

        do {
            System.out.print("Annual Interest Rate: ");
            rate = scanner.nextFloat();
            if ((rate > 0) && (rate <= 30)) {
                rate = (float) (rate / percentToDecimal / yearToMonth);
                break;
            }
            System.out.println("Enter a value greater than 0 and less than or equal to 30.");
        } while ((rate <= 0) || (rate > 30));

        do {
            System.out.print("Period (Years): ");
            year = scanner.nextInt();
            if ((year > 0) && (year <= 30)) {
                months = year * yearToMonth;
                break;
            }
            System.out.println("Enter a value between 1 and 30.");
        } while ((year <= 0) || (year > 30));


        // calculations
        mortgage = rate * Math.pow((1 + rate), months);
        mortgage *= principle;
        mortgage /= (Math.pow((1 + rate), months) - 1);

        // print
        System.out.println("Mortgage: " + money.format(mortgage));

        // Summary:
        // This works however, don't have magic numbers
        // Use final values instead

    }

}
