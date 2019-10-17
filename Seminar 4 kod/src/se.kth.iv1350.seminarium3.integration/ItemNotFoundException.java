package se.kth.iv1350.seminarium3.integration;

/**
 * <code>Exception</code> for when an <code>Item</code> isn't found in the database.
 */
public class ItemNotFoundException extends Exception {
    private String msg;

    /**
     * Creates an <code>Exception</code> for when the itemRegistry fials to find an item in the database.
     * @param itemId The id that has no corresponding <code>Item</code>.
     */
    public ItemNotFoundException(int itemId){
        super("No item with id " + itemId + " found.");
    }
}
