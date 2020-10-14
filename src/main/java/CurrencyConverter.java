/**
 * Class containing logic for basic mathematical operations for pounds, shillings and pence calculations
 */
public class CurrencyConverter {

    //12 pence == 1 shilling
    //20 shillings == 1 pound
    //1 pound == 240 pence
    //"5p 15s 8d" is 12 Pounds, 6 Shillings and 10 Pence.

    /**
     * Method to calculate multiplication in format (Xp Ys Zd + Xp Ys Zd)
     * @param amount1 First filled amount model with values
     * @param amount2 Second filled amount model with values
     * @return formatted result
     */
    public static String sum(Amount amount1, Amount amount2) {
        //5p 17s 8d + 3p 4s 10d = 9p 2s 6d
        return convertToAmount(convertToPence(amount1) + convertToPence(amount2)).toString();
    }

    /**
     * Method to calculate subtraction between two values in format (Xp Ys Zd  - Xp Ys Zd)
     * @param amount1 First filled amount model with values
     * @param amount2 Second filled amount model with values
     * @return formatted result
     */
    public static String subtract(Amount amount1, Amount amount2) {
        //5p 17s 8d - 3p 4s 10d = 2p 12s 10d
        return convertToAmount(convertToPence(amount1) - convertToPence(amount2)).toString();
    }

    /**
     * Method to calculate multiplication in format (Xp Ys Zd * M)
     * @param amount Filled amount model with values
     * @param multiplier fixed multiplier
     * @return formatted result
     */
    public static String multiply(Amount amount, int multiplier) {
        //5p 17s 8d * 2 = 11p 15s 4d
        return convertToAmount(convertToPence(amount) * multiplier).toString();
    }

    /**
     * Method to calculate division in format (Xp Ys Zd / D)
     * @param amount Filled amount model with values
     * @param divider fixed divider
     * @return formatted result
     */
    public static String divide(Amount amount, int divider) {
        //5p 17s 8d / 3 = 1p 19s 2d (2d) (2 pence as remainder)
        //18p 16s 1d / 15 = 1p 5s 0d   (1s 1d) (1 Shillings and 1 pence as remainder)
        //5p 8s 11d / 3 = 1p 16s 4d
        //the remainder should be represented between parenthesis)
        return convertToAmount(convertToPence(amount) / divider).toString() + divideFormatResult(convertToAmount(convertToPence(amount) % divider));
    }

    /**
     * Method for representing reminders in proper way
     * @param amountReminder Object which holds information about reminders from calculation
     * @return Formatted string
     */
    public static StringBuilder divideFormatResult(Amount amountReminder) {
        //ex. (1s 1d) (reminders inside parenthesis)
        StringBuilder sb = new StringBuilder();
        sb.append(" (");
        if (!(amountReminder.getShillings() == 0)) {
            sb.append(amountReminder.getShillings()).append("s ");
        }
        if (!(amountReminder.getPence() == 0)) {
            sb.append(amountReminder.getPence()).append("d");
        }
        sb.append(")");

        return sb;
    }

    /**
     * Method for converting everything to pennies
     * @param amount Object to be converted
     * @return total amount of pennies
     */
    public static int convertToPence(Amount amount) {
        //1 pound = 240 pence, 1 shilling = 12 pence
        return (amount.getPounds() * 240) + (amount.getShillings() * 12) + amount.getPence();
    }

    /**
     * Method for keep check of reminders and converting everything to pennies
     * @param pence Amount of pennies
     * @return Object filled with values to be printed
     */
    public static Amount convertToAmount(int pence) {
        //1 pound = 240 pence
        int pounds = pence / 240;
        //get reminder for pound
        int poundRemainderInPence = pence % 240;
        //1 shilling = 12 pence
        int shillings = poundRemainderInPence / 12;
        //get reminder for shilling
        int shillingRemainderInPence = poundRemainderInPence % 12;

        return new Amount(pounds, shillings, shillingRemainderInPence);

    }
}
