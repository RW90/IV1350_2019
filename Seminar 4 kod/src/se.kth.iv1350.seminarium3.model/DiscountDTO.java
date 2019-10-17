package se.kth.iv1350.seminarium3.model;
/**
 * Contains immutable information on a particular <code>Discount</code> without the time period information.
 */
public final class DiscountDTO {
	private final float discountAmount;
	private final String id;

	/**
	 * Creates a DTO for a <code>Discount</code> from raw data.
	 * @param discountAmount The discount rate given as 1 - p/100 where p is discount in percent.
	 * @param id Id or name of the discount.
	 */
	public DiscountDTO(float discountAmount, String id){
		this.discountAmount = discountAmount;
		this.id = id;
	}
	/**
	 * Creates an immutable instance of <code>DiscountDTO</code> with data from a <code>Discount</code> instance.
	 *
	 * @param discount <code>Discount</code> instance to turn immutable.
	 */
	public DiscountDTO(Discount discount) {
		this.discountAmount = discount.getDiscountAmount();
		this.id = discount.getId();
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
	 * Gets the id of the discount.
	 *
	 * @return Id of discount.
	 */
	public String getId() {
		return id;
	}
}
