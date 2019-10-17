package se.kth.iv1350.seminarium3.integration;

import java.util.ArrayList;
import java.util.List;

import se.kth.iv1350.seminarium3.model.Item;
import se.kth.iv1350.seminarium3.model.ItemDTO;
import se.kth.iv1350.seminarium3.model.Receipt;

/**
 * Meant to represent communication with a database of items.
 */
public class InventoryRegistry {
	private List<ItemData> itemsInDatabase  = new ArrayList<>();
	private List<Receipt> receiptsDatabase  = new ArrayList<>();

	private class ItemData{
		private final int id;
		private final String name;
		private final int price;
		private final float rateVAT;
		private final String description;
		private final int amount;

		public ItemData(int id, String name, int price, float rateVAT, String description, int amount) {
			this.id = id;
			this.name = name;
			this.price = price;
			this.rateVAT = rateVAT;
			this.description = description;
			this.amount = amount;
		}
	}
	/**
	 * Creates a new instance of InventoryRegistry.
	 */
	InventoryRegistry(){
		addListOfItems(); 
	}
	/**
	 * Meant for demo purposes to add items to fake database.
	 */
	private void addListOfItems() {
		itemsInDatabase.add(new ItemData(1, "Apple", 5, 0.25f, "A delicious apple.", 0));
		itemsInDatabase.add(new ItemData(2, "Juice", 15, 0.3f, "Sugar filled beverage.", 0));
		itemsInDatabase.add(new ItemData(3, "Pasta", 20, 0.15f, "1 kg of quality pasta.", 0));
		itemsInDatabase.add(new ItemData(4, "Frozen salmon", 70, 0.25f, "500 grams of frozen norwegian salmon.", 0));
	}
	/**
	 * Gets an item from the database/calls the database for an item.
	 * 
	 * @param itemID ID of the item to be fetched.
	 * 
	 * @return ItemDTO with ID of itemID. null if not found.
	 * @throws ItemNotFoundException If no <code>Item</code> with itemID was found.
	 * @throws DatabaseFailureException If for some reason the database fails.
	 */
	public ItemDTO fetchItem(int itemID) throws ItemNotFoundException{
		int databaseFailureTesting = -1;
		if(itemID == databaseFailureTesting){
			throw new DatabaseFailureException("Item Database failed when retrieving item:" + itemID);
		}
		for(ItemData item : itemsInDatabase) {
			if(itemID == item.id) {
				return new ItemDTO(item.id, item.name, item.price, item.rateVAT, item.description, 0);
			}
		}
		throw new ItemNotFoundException(itemID);
	}

	/**
	 * Dummy function that updates the database with the data from a <code>Sale</code> that has finished.
	 * @param receipt Log of the <code>Sale</code>.
	 */
	public void updateInventor(Receipt receipt){
		receiptsDatabase.add(receipt);
	}
}
