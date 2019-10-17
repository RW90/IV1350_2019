package se.kth.iv1350.seminarium3.model;

/**
 * A immutable version of <code>Price</code> representing price information for a <code>Sale</code>
 * including price of tax and price without tax.
 */
public class PriceDTO {
    private final int taxAmount;
    private final int priceWithoutTax;
    private final int totalPrice;

    /**
     * Creates an instance of <code>PriceDTO</code> from raw data.
     * @param taxAmount Price of tax.
     * @param priceWithoutTax Price of wares.
     * @param totalPrice Price of tax+wares.
     */
    PriceDTO(int taxAmount, int priceWithoutTax, int totalPrice){
        this.taxAmount = taxAmount;
        this.priceWithoutTax = priceWithoutTax;
        this.totalPrice = totalPrice;
    }

    /**
     * Creates an instance of <code>PriceDTO</code> from an instance of <code>Price</code>.
     * @param price <code>Price</code> instance to turn immutable.
     */
    PriceDTO(Price price){
        this.taxAmount = price.getTaxAmount();
        this.priceWithoutTax = price.getPriceWithoutTax();
        this.totalPrice = price.getTotalPrice();
    }

    /**
     * Get the price amount without the tax added.
     * @return The price without the tax.
     */
    public int getPriceWithoutTax() {
        return priceWithoutTax;
    }

    /**
     * Get the amount of tax to pay.
     * @return The amount of tax.
     */
    public int getTaxAmount() {
        return taxAmount;
    }

    /**
     *Get the total price amount.
     *
     * @return The total price amount.
     */
    public int getTotalPrice() {
        return totalPrice;
    }

    public String toString(){
        String returnString = new String
                ("Price without tax: " + priceWithoutTax + "\n"
                + "Price of tax:      " + taxAmount + "\n"
                + "Total:             " + totalPrice);
        return returnString;
    }
}
