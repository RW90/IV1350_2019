package se.kth.iv1350.seminarium3.model;

/**
 * A class representing the price of a <code>Sale</code>> that needs to be payed for the items in the <code>Sale</code>.
 * Keeps information on untaxed price, tax price and total price.
 */
public class Price {
    private int taxAmount;
    private int priceWithoutTax;
    private int totalPrice;

    /**
     * Creates a <code>Price</code> instance starting at 0.
     */
    public Price(){
        taxAmount = 0;
        priceWithoutTax = 0;
        totalPrice = 0;
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

    /**
     * Updates the <code>Price</code> with another <code>Item</code> amount number of times.
     * @param item Item to add to the <code>Price</code>.
     * @param amount Amount of <code>Item</code> to add to <code>Price</code>.
     */
    void updatePrice(Item item, int amount){
        int itemPrice = item.getPrice()*amount;
        priceWithoutTax += itemPrice;
        taxAmount += Math.floor(itemPrice*item.getRateVAT());
        updateTotalPrice();
    }

    /**
     * Updates the price with a discount.
     * @param discount Discount to apply to the price.
     */
    void updatePrice(DiscountDTO discount){
        priceWithoutTax *= discount.getDiscountAmount();
        taxAmount *= discount.getDiscountAmount();
        updateTotalPrice();
    }

    private void updateTotalPrice(){
        totalPrice = priceWithoutTax + taxAmount;
    }
}
