package se.kth.iv1350.seminarium3.model;

/**
 * Class representing a discount with an amount, id and a time period when it's available.
 */
public class Discount {
    private float discountAmount;
    private String id;
    private TimePeriod timePeriod;
    /**
     * Creates an instance of <code>Discount</code>.
     *
     * @param discountAmount The discount amount given as 1 - p/100 where p is discount in percent.
     * @param id Name or id of the discount.
     * @param timePeriod Period of time this sale is available.
     */
    public Discount(float discountAmount, String id, TimePeriod timePeriod) {
        this.discountAmount = discountAmount;
        this.id = id;
        this.timePeriod = timePeriod;
    }
    /**
     * Gets discount rate.
     *
     * @return The discount rate given as 1 - p/100 where p is discount in percent.
     */
    public float getDiscountAmount() {
        return discountAmount;
    }

    /**
     * Gets the id of the <code>Discount</code>.
     * @return Id of <code>Discount</code>.
     */
    public String getId() {
        return id;
    }

    /**
     * Checks if <code>Discount</code> is available at current date.
     * @return <code>true</code> if it is available.
     */
    public boolean isAvailable(){
        return timePeriod.isCurrent();
    }

    /**
     * Checks if the <code>Discount</code> have expired.
     * @return <code>true</code> if discount is expired.
     */
    public boolean isExpired(){
        return timePeriod.isExpired();
    }
}
