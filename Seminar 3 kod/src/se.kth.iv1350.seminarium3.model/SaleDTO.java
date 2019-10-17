package se.kth.iv1350.seminarium3.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
/**
 * Contains immutable information about a <code>Sale</code>.
 */
public final class SaleDTO {
	private final PriceDTO price;
	private final List<ItemDTO> itemList;

	/**
	 * Creates a new instance of <code>SaleDTO</code> from a <code>Sale</code>.
	 * 
	 * @param sale <code>Sale</code> instance that is to be copied into an immutable DTO-object.
	 */
	SaleDTO(Sale sale) {
		this.price = sale.getPrice();
		this.itemList = makeListsImmutable(sale.getItems());
	}

	private List makeListsImmutable(List list){
		return Collections.unmodifiableList(list);
	}


	/**
	 * Get the <code>Price</code> of the <code>SaleDTO</code> as a <code>PriceDTO</code>.
	 * @return The price of the sale.
	 */
	public PriceDTO getPrice() {
		return price;
	}

	/**
	 * Get the <code>ItemDTO</code> <code>List</code> of items in the <code>SaleDTO</code>.
	 * @return The items of the sale.
	 */
	public List<ItemDTO> getItems() {
		return itemList;
	}

	/**
	 * Turns a <code>SaleDTO</code> into a <code>String</code> representation.
	 * 
	 * @return <code>SaleDTO</code> as <code>String</code>.
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Items: \n");
		for(ItemDTO item : itemList) {
			builder.append(item.toString() + "\n");
		}
		builder.append(this.price.toString());
		return builder.toString();
	}
}
