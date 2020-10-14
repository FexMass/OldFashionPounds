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
     *
     * @param amount1 First filled amount model with values
     * @param amount2 Second filled amount model with values
     * @return formatted result
     */
    public static String sum(Amount amount1, Amount amount2) {
        if (!(amount1.getPounds() >= 0 && amount1.getShillings() >= 0 &&
                amount1.getPence() >= 0 && amount2.getPounds() >= 0 &&
                amount2.getShillings() >= 0 && amount2.getPence() >= 0)) {
            return "Number/s can't be negative";
        }
        return convertToAmount(convertToPence(amount1) + convertToPence(amount2)).toString();
    }

    /**
     * Method to calculate subtraction between two values in format (Xp Ys Zd  - Xp Ys Zd)
     *
     * @param amount1 First filled amount model with values
     * @param amount2 Second filled amount model with values
     */
    public static String subtract(Amount amount1, Amount amount2) {
        if (!(amount1.getPounds() >= 0 && amount1.getShillings() >= 0 &&
                amount1.getPence() >= 0 && amount2.getPounds() >= 0 &&
                amount2.getShillings() >= 0 && amount2.getPence() >= 0)) {
            return "Number/s can't be negative";
        }
        if (!(convertToPence(amount1) > convertToPence(amount2))) {
            return "Second amount can't be bigger than first amount";
        }
        return convertToAmount(convertToPence(amount1) - convertToPence(amount2)).toString();
    }

    /**
     * Method to calculate multiplication in format (Xp Ys Zd * M)
     *
     * @param amount     Filled amount model with values
     * @param multiplier fixed multiplier
     * @return formatted result
     */
    public static String multiply(Amount amount, int multiplier) {
        if (!(amount.getPounds() >= 0 && amount.getPence() >= 0 &&
                amount.getShillings() >= 0 && multiplier >= 0)) {
            return "Number/s can't be negative";
        }
        return convertToAmount(convertToPence(amount) * multiplier).toString();
    }

    /**
     * Method to calculate division in format (Xp Ys Zd / D)
     *
     * @param amount  Filled amount model with values
     * @param divider fixed divider
     * @return formatted result
     */
    public static String divide(Amount amount, int divider) {
        if (!(amount.getPounds() >= 0 && amount.getPence() >= 0 &&
                amount.getShillings() >= 0 && divider >= 0)) {
            return "Number/s can't be negative";
        }
        return convertToAmount(convertToPence(amount) / divider).toString() + divideFormatResult(convertToAmount(convertToPence(amount) % divider));
    }

    /**
     * Method for representing reminders in proper way
     *
     * @param amountReminder which holds information about reminders from calculation
     * @return Formatted string
     */
    public static StringBuilder divideFormatResult(Amount amountReminder) {
        //ex. (1s 1d) (reminders inside parenthesis)
        StringBuilder sb = new StringBuilder();
        sb.append(" (");
        if (!(amountReminder.getPounds() == 0)) {
            sb.append(amountReminder.getPounds()).append("p ");
        }
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
     *
     * @param amount Object to be converted
     * @return total amount of pennies
     */
    public static int convertToPence(Amount amount) {
        //1 pound = 240 pence, 1 shilling = 12 pence
        return (amount.getPounds() * 240) + (amount.getShillings() * 12) + amount.getPence();
    }

    /**
     * Method for keep check of reminders and converting everything to pennies
     *
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