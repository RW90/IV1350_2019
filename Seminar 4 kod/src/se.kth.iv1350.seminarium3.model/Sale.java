package se.kth.iv1350.seminarium3.model;
import java.time.LocalDate;
import java.util.List;

import java.util.ArrayList;

import se.kth.iv1350.seminarium3.integration.CustomerRegistry;
import se.kth.iv1350.seminarium3.integration.InventoryRegistry;
import se.kth.iv1350.seminarium3.integration.ItemNotFoundException;

/**
 * Mutable class representing an ongoing sale.
 */
public class Sale {
	InventoryRegistry itemRegistry;
	private Price price;
	private List<Item> itemList;
	private List<DiscountDTO> discounts;


	/**
	 * Creates an empty <code>Sale</code> object.
	 * @param itemRegistry The database handler for items.
	 */
	public Sale(InventoryRegistry itemRegistry) {
		this.itemRegistry = itemRegistry;
		this.price = new Price();
		this.itemList = new ArrayList<>();
	}

	/**
	 * Adds a certain amount of an <code>Item</code> with <code>id</code> itemID to the list of <code>Item</code> in the sale
	 * if the item is already in the <code>Sale</code> to begin with. Else it fetches the item from database and adds it.
	 * Also checks if items id is valid.
	 * 
	 * @param itemID ID-number of item to be added to the list.
	 * @param amount number of item to be added to list.
	 *
	 * @return <code>true</code> if <code>Item</code> with the id-number exists in the inventory.
	 *
	 * @throws ItemNotFoundException If item is not found it propagate the <code>Exception</code>.
	 */
	public void addItem(int itemID, int amount) throws ItemNotFoundException {
		if(isItemInSale(itemID)) {
			for (Item item : itemList) {
				if (item.isItemId(itemID)) {
					updatePriceAndItemAmount(item, amount);
				}
			}
		} else{
			ItemDTO fetchedItem = itemRegistry.fetchItem(itemID);
			if(fetchedItem != null){
				Item item = new Item(fetchedItem);
				updatePriceAndItemAmount(item, amount);
				itemList.add(item);
			}
		}
	}

	private void updatePriceAndItemAmount(Item item, int amount){
		item.changeAmountBy(amount);
		price.updatePrice(item, amount);
	}

	private boolean isItemInSale(int id){
		for(Item item : itemList){
			if(item.isItemId(id)){
				return true;
			}
		}
		return false;
	}

	/**
	 * Adds a customers discounts to the <code>Sale</code> and applies them to
	 * the <code>Price</code> multiplicatively.
	 * @param discounts <code>List</code> of <code>DiscountDTO</code> to add.
	 */
	public void addDiscount(List<DiscountDTO> discounts) {
		this.discounts = discounts;
		applySaleDiscounts();
	}

	private void applySaleDiscounts(){
		for(DiscountDTO discount : discounts){
			price.updatePrice(discount);
		}
	}

	/**
	 * Creates a <code>SaleDTO</code> object from this instance of <code>Sale</code>.
	 *
	 * @return Immutable <code>SaleDTO</code> of this <code>Sale</code>.
	 */
	public SaleDTO getSaleInfo() {
		return new SaleDTO(this);
	}

	/**
	 * Get the <code>Price</code> as an immutable <code>PriceDTO</code>.
	 *
	 * @return An immutable instance of <code>Price</code>.
	 */
	public PriceDTO getPrice() {
		return new PriceDTO(price);
	}


	/**
	 * Get a list of all the <code>Sale</code> <code>Item</code> as a <code>List</code> of immutable <code>ItemDTO</code>.
	 *
	 * @return <code>List</code> of immutable items currently in <code>Sale</code>.
	 */
	public List<ItemDTO> getItems() {
		List<ItemDTO> returnItemList = new ArrayList<>();
		for(Item item : itemList){
			returnItemList.add(new ItemDTO(item));
		}
		return returnItemList;
	}

	/**
	 * Get the <code>List</code> of discounts of this <code>Sale</code>.
	 *
	 * @return <code>List</code> of discounts.
	 */
	public List<DiscountDTO> getDiscount() {
		List<DiscountDTO> returnDiscountList = new ArrayList<>();
		for(DiscountDTO discount : discounts){
			returnDiscountList.add(discount);
		}
		return returnDiscountList;
	}
}
