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
            String input = in.nextLine();
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

        return "Unknown input!";
    }
}
