package se.kth.iv1350.seminarium3.model;

/**
 * Contains immutable information for a particular item with a mutable <code>amount</code> field.
 */
public final class Item {
    private final int id;
    private final String name;
    private final int price;
    private final float rateVAT;
    private final String description;
    private int amount;

    /**
     * Creates an instance of an item with specific characteristics.
     *
     * @param id          The id-number of the item.
     * @param name        Name of the item.
     * @param price       Price of the item.
     * @param rateVAT     The VAT-rate of the item given by p/100, where p is the VAT-rate in percentage.
     * @param description Description and extra info of the item.
     */
    public Item(int id, String name, int price, float rateVAT, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.rateVAT = rateVAT;
        this.description = description;
        this.amount = 0;
    }

    /**
     * Creates an instance of  <code>Item</code> from an <code>ItemDTO</code> object with the
     * same values on all fields except <code>amount</code> field which is set to 0.
     *
     * @param item The item to create.
     */
    public Item(ItemDTO item) {
        this.id = item.getID();
        this.name = item.getName();
        this.price = item.getPrice();
        this.rateVAT = item.getRateVAT();
        this.description = item.getDescription();
        this.amount = 0;
    }

    /**
     * Compares an <code>Item</code> id to this <code>Item</code>.
     *
     * @param id <code>Item</code> id to compare this <code>Item</code> to.
     * @return True if <code>Item</code> id and id is the same.
     */
    boolean isItemId(int id) {
        return this.id == id;
    }

    /**
     * Change the amount of <code>Item</code> this instance represents by incrementing it by the argument amount.
     * @param amount The amount to increment with.
     */
    void changeAmountBy(int amount){
        this.amount += amount;
    }
    /**
     * Get the <code>Item</code> id.
     *
     * @return The <code>Item</code> id.
     */
    int getID() {
        return id;
    }

    /**
     * Get the name of the <code>Item</code>.
     *
     * @return The <code>Item</code> name.
     */
    String getName() {
        return name;
    }

    /**
     * Get the price of the<code>Item</code>.
     *
     * @return The price of the <code>Item</code>.
     */
    int getPrice() {
        return price;
    }

    /**
     * Get the tax rate of the <code>Item</code>.
     *
     * @return The tax rate as p/100 with p as the rate in percentage.
     */
    float getRateVAT() {
        return rateVAT;
    }

    /**
     * Get the description of the <code>Item</code>.
     *
     * @return The description of <code>Item</code>.
     */
    String getDescription() {
        return description;
    }

    /**
     * Get the number of items this instance represents.
     *
     * @return The number of items this instance represents.
     */
    int getAmount() {
        return amount;
    }

    /**
     * Turns an <code>Item</code> into a string representation.
     *
     * @return Object as String
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.amount + "x " + this.name + "\t" + (int) (this.amount * this.price *(1 + this.rateVAT)));
        return builder.toString();
    }
}
