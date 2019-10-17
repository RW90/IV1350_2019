package se.kth.iv1350.seminarium3.model;

/**
 * Meant to represent a payment for a <code>Sale</code> made by a customer.
 * Includes information about amount payed and amount owed back in change.
 */
public class Payment {
    private final int payAmount;
    private int changeAmount;

    /**
     * Creates a <code>Payment</code> instance for when a customer has payed.
     * @param payAmount The amount the customer payed.
     */
    public Payment(int payAmount){
        this.payAmount = payAmount;
    }

    /**
     * Calculates and returns the change of the purchase of a <code>Sale</code>.
     * @param price Price of the <code>Sale</code>.
     * @return The amount of change owed to the customer.
     */
    public int calculateChange(PriceDTO price){
        this.changeAmount = payAmount - price.getTotalPrice();
        return changeAmount;
    }

    /**
     * Returns the amount of change owed to the customer.
     * @return The amount of change owed.
     */
    public int getChangeAmount() {
        return changeAmount;
    }

    /**
     * Returns how much the customer payed for the <code>Sale</code>.
     * @return Amount payed by customer.
     */
    public int getPayAmount() {
        return payAmount;
    }

    /**
     * Returns a <code>String</code> representation of this instance.
     * @return <code>String</code> representation.
     */
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("Payment amount: " + payAmount + "\n");
        builder.append("Change        : " + changeAmount + "\n");
        return builder.toString();
    }
}
