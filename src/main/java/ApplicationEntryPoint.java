import java.util.Scanner;
/**
 * Library containing logic for calculation of basic mathematical operations ( + * - /) for
 * "Old money" which means pounds, shillings and pence.
 * This Class contains main method for input and handleInput method for input validation
 * @author Mass
 */
public class ApplicationEntryPoint {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //format Xp Ys Zd + Xp Ys Zd
        System.out.println("Enter numbers in following format 'Xp Ys Zd' and appropriate operator '+ - * /' !");
        System.out.print("Convert: ");
        while (in.hasNext()) {
            String input = in.nextLine().trim();

            if (input.equalsIgnoreCase("Exit")) {
                break;
            }
            System.out.println(handleInput(input));
            System.out.print("Convert: ");
        }
        //Closing Scanner before shut down
        in.close();
    }

    /**
     * Method for validation of input
     * @param input Input provide by user
     */
    public static String handleInput(String input) {
        try {
            String[] splitNumbers = input.split("\\s+");

            //Validate input
            if (!(splitNumbers.length == 5 || splitNumbers.length == 7)) {
                return ("Format is wrong");
            }
            if (!splitNumbers[3].matches("[+*-/]")) {
                return ("Unknown operator used");
            }

            //Input format 1 for (Xp Ys Zd +- Xp Ys Zd)
            if (splitNumbers.length == 7 && splitNumbers[3].matches("[+-]")) {
                Amount amount1 = new Amount(splitNumbers[0], splitNumbers[1], splitNumbers[2]);
                Amount amount2 = new Amount(splitNumbers[4], splitNumbers[5], splitNumbers[6]);

                return splitNumbers[3].equals("+") ? CurrencyConverter.sum(amount1, amount2) :
                        CurrencyConverter.subtract(amount1, amount2);
            }
            //Input format 2 for (Xp Ys Zd */ NUM)
            if (splitNumbers.length == 5 && splitNumbers[3].matches("[*/]")) {
                Amount amount1 = new Amount(splitNumbers[0], splitNumbers[1], splitNumbers[2]);
                return splitNumbers[3].equals("*") ? CurrencyConverter.multiply(amount1, Integer.parseInt(splitNumbers[4])) :
                        CurrencyConverter.divide(amount1, Integer.parseInt(splitNumbers[4]));
            }
        } catch (NumberFormatException ex) {
            return "Exception occurred: " + ex.getMessage();
        }
        return "Unknown input!";
    }
}
