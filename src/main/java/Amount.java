/**
 * Model containing input values to be calculated which are filled by user with extra validation
 */
public class Amount {

    private final int pounds;
    private final int shillings;
    private final int pence;

    public Amount(String pounds, String shillings, String pence) {
        //validation for each number if contains "psd" as required format of entry
        if (!pounds.endsWith("p") || !shillings.endsWith("s") || !pence.endsWith("d")) {
            throw new IllegalArgumentException();
        }
        //converting to Integer to calculate
        this.pounds = Integer.parseInt(pounds.replace("p", ""));
        this.shillings = Integer.parseInt(shillings.replace("s", ""));
        this.pence = Integer.parseInt(pence.replace("d", ""));
    }

    public Amount(int pounds, int shillings, int pence) {
        this.pounds = pounds;
        this.shillings = shillings;
        this.pence = pence;
    }

    public int getPounds() {
        return pounds;
    }

    public int getShillings() {
        return shillings;
    }

    public int getPence() {
        return pence;
    }

    @Override
    public String toString() {
        return "Result: " +
                pounds + "p " +
                shillings + "s " +
                pence + "d";
    }
}