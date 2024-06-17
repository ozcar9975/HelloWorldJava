import java.text.NumberFormat;
import java.util.Scanner;

public class mortgage_calc {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        NumberFormat money = NumberFormat.getCurrencyInstance();
        double mortgage;

        // gets all inputs
        System.out.print("Principle: ");
        double principle = scanner.nextDouble();
        System.out.print("Annual Interest Rate: ");
        double rate = scanner.nextDouble() / 1200;
        System.out.print("Period (Years): ");
        int months = 12 * scanner.nextInt();

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
