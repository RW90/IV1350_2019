package se.kth.iv1350.seminarium3.model;
/**
 * Contains immutable information for a particular item.
 */
public final class ItemDTO {
	private final int id;
	private final String name;
	private final int price;
	private final float rateVAT;
	private final String description;
	private final int amount;
	/**
	 * Creates an instance of <code>ItemDTO</code>.
	 * 
	 * @param id The id of the item.
	 * @param name Name of the item.
	 * @param price Price of the item.
	 * @param rateVAT The VAT-rate of the item given by p/100, where p is the VAT-rate in percentage.
	 * @param description Description and extra info of the item.
	 */
	public ItemDTO(int id, String name, int price, float rateVAT, String description, int amount) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.rateVAT = rateVAT;
		this.description = description;
		this.amount = amount;
	}
	
	/**
	 * Creates an instance of  <code>ItemDTO</code> from an  <code>Item</code> object with the
	 * same values on all fields.
	 * 
	 * @param item The item to create.
	 */
	public ItemDTO(Item item) {
		this.id = item.getID();
		this.name = item.getName();
		this.price = item.getPrice();
		this.rateVAT = item.getRateVAT();
		this.description = item.getDescription();
		this.amount = item.getAmount();
	}
	/**
	 * Get the value of id
	 * 
	 * @return The value of id
	 */
	public int getID() {
		return id;
	}
	/**
	 * Get the value of name.
	 * 
	 * @return The value of name
	 */
	public String getName() {
		return name;
	}
	/**
	 * Get the value of price.
	 * 
	 * @return The value of price.
	 */
	public int getPrice() {
		return price;
	}
	/**
	 * Get the value of rateVAT.
	 * 
	 * @return The value of rateVAT.
	 */
	public float getRateVAT() {
		return rateVAT;
	}
	/**
	 * Get the value of description.
	 * 
	 * @return The value of description.
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * Get the value of amount.
	 * 
	 * @return The value of amount.
	 */
	public int getAmount() {
		return amount;
	}
	/**
	 * Turns an ItemDTO into a string representation.
	 * 
	 * @return Object as String
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(this.amount + "x " + this.name + "\t" + (int)(this.amount*this.price*(1+this.rateVAT)));
		return builder.toString();
	}
}
