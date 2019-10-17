package se.kth.iv1350.seminarium3.integration;
import java.util.ArrayList;
import java.util.List;

import se.kth.iv1350.seminarium3.model.Receipt;
import se.kth.iv1350.seminarium3.model.SaleDTO;
/**
 * Meant to represent communication with a database of Sales.
 */
public class SaleRegistry {
	private List<Receipt> salesLoggedInDatabase;
	/**
	 * Creates a new instance of <code>SaleRegistry</code>.
	 */
	SaleRegistry(){
		salesLoggedInDatabase  = new ArrayList<>();
	}
	/**
	 * Logs a sale in the database.
	 * 
	 * @param sale <code>Receipt</code> of <code>Sale</code> to be logged.
	 */
	public void logSale(Receipt sale) {
		salesLoggedInDatabase.add(sale);
	}

}
