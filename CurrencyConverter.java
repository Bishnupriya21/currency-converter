import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Hardcoded exchange rates (example: 1 USD = 82 INR, 1 EUR = 89 INR)
        double usdToInr = 82.0;
        double eurToInr = 89.0;
        double usdToEur = 0.92;
        double eurToUsd = 1.08;

        System.out.println("------ Currency Converter ------");
        System.out.println("Supported currencies: INR, USD, EUR");

        while (true) {
            System.out.print("\nEnter source currency (INR/USD/EUR): ");
            String source = scanner.next().toUpperCase();

            System.out.print("Enter target currency (INR/USD/EUR): ");
            String target = scanner.next().toUpperCase();

            System.out.print("Enter amount: ");
            double amount = scanner.nextDouble();

            double result = 0.0;
            boolean valid = true;

            if (source.equals(target)) {
                result = amount;
            } 
            // USD conversions
            else if (source.equals("USD") && target.equals("INR")) {
                result = amount * usdToInr;
            } else if (source.equals("INR") && target.equals("USD")) {
                result = amount / usdToInr;
            } else if (source.equals("USD") && target.equals("EUR")) {
                result = amount * usdToEur;
            } else if (source.equals("EUR") && target.equals("USD")) {
                result = amount * eurToUsd;
            }
            // EUR conversions
            else if (source.equals("INR") && target.equals("EUR")) {
                result = amount / eurToInr;
            } else if (source.equals("EUR") && target.equals("INR")) {
                result = amount * eurToInr;
            }
            else {
                valid = false;
                System.out.println("Invalid currency combination.");
            }

            if (valid) {
                System.out.printf("%.2f %s = %.2f %s\n", amount, source, result, target);
            }

            System.out.print("Do you want to convert more? (yes/no): ");
            String again = scanner.next().toLowerCase();
            if (!again.equals("yes")) {
                break;
            }
        }

        System.out.println("Thank you for using the Currency Converter!");
        scanner.close();
    }
}
