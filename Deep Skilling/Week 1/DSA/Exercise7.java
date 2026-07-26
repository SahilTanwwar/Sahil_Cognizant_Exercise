1. What is Recursion?

Recursion is a programming technique where a method calls itself until it reaches a stopping condition (called the base case).

General Structure
return function(smallerProblem);

A recursive method has two parts:

Base Case → Stops recursion.
Recursive Case → Calls itself with a smaller problem.

  /////////////////////////////////////////////////

  2. Financial Forecast Formula

Suppose

Present Value = 10000
Growth Rate = 10% (0.10)
Years = 5

Formula

FV=PV×(1+r)
n

Instead of using Math.pow(), we'll calculate recursively.

  ////////////////////////////////////////////////////////////////////////////////////

  import java.util.Scanner;

public class FinancialForecast {

    // Recursive method
    public static double futureValue(double amount, double rate, int years) {

        // Base Case
        if (years == 0) {
            return amount;
        }

        // Recursive Case
        return futureValue(amount * (1 + rate), rate, years - 1);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Present Amount: ");
        double amount = sc.nextDouble();

        System.out.print("Enter Growth Rate (%): ");
        double rate = sc.nextDouble() / 100;

        System.out.print("Enter Number of Years: ");
        int years = sc.nextInt();

        double result = futureValue(amount, rate, years);

        System.out.printf("Future Value after %d years = %.2f%n", years, result);

        sc.close();
    }
}
