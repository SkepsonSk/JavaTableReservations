package pl.pollub.javatablereservations.wrongClass;

public class Utils {

    // Calculates the sum of lower elements till the number and doubling
    // the result if doubleResult is set to true
    public static int calculateResult(int number, boolean doubleResult) {
        int result = 0;
        for (int i = 0; i < number; i++) {
            result += i;
        }
        if (doubleResult) {
            result *= 2;
        }
        return result;
    }

}
