/**
 * Class containing logic for basic mathematical operations for pounds, shillings and pence calculations
 */
public class CurrencyConverter {

    //12 pence == 1 shilling
    //20 shillings == 1 pound
    //1 shilling == 12 pence
    //"5p 15s 8d" is 12 Pounds, 6 Shillings and 10 Pence.

    /**
     * Method for representing reminders in proper way
     * @param amountReminder Object which holds information about reminders from calculation
     * @return Formatted string
     */
    public static StringBuilder divideFormatResult(Amount amountReminder) {
        //ex. (1p 1s 1d) (reminders inside parenthesis)
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
     * Method for keep check of reminders and converting everything to pennies
     * @param pence Amount of pennies
     * @return Object filled with values to be printed
     */
    public static Amount convertToAmount(int pence) {
        int pounds = pence / 240;
        int poundRemainderInPence = pence % 240;
        int shillings = poundRemainderInPence / 12;
        int shillingRemainderInPence = poundRemainderInPence % 12;

        return new Amount(pounds, shillings, shillingRemainderInPence);

    }
}
