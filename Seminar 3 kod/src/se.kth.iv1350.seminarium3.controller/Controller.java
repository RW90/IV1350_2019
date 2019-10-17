package se.kth.iv1350.seminarium3.controller;

import se.kth.iv1350.seminarium3.integration.CustomerRegistry;
import se.kth.iv1350.seminarium3.integration.InventoryRegistry;
import se.kth.iv1350.seminarium3.integration.RegistryCreator;
import se.kth.iv1350.seminarium3.integration.SaleRegistry;
import se.kth.iv1350.seminarium3.model.Address;
import se.kth.iv1350.seminarium3.model.CashRegister;
import se.kth.iv1350.seminarium3.model.DiscountDTO;
import se.kth.iv1350.seminarium3.model.Payment;
import se.kth.iv1350.seminarium3.model.Receipt;
import se.kth.iv1350.seminarium3.model.Sale;
import se.kth.iv1350.seminarium3.model.SaleDTO;
import se.kth.iv1350.seminarium3.model.Store;


import java.util.List;

/**
 * Controller class from MVC-pattern.
 */
public class Controller {
	private final InventoryRegistry inventoryRegistry;
	private final CustomerRegistry customerRegistry;
	private final SaleRegistry saleRegistry;
	private Sale currentSale;
	private final CashRegister register;
	private final Store store;
	
	/**
	 * Creates instance of <code>Controller</code>.
	 * 
	 * @param creator <code>RegistryCreator</code> instance to initialize connection to integration layer.
	 */
	public Controller(RegistryCreator creator) {
		this.inventoryRegistry = creator.getInventoryRegistry();
		this.customerRegistry = creator.getCustomerRegistry();
		this.saleRegistry = creator.getSaleRegistry();
		this.register = new CashRegister();
		this.store = new Store("RilleMart", new Address("Main Street", "1", "95712", "Kista"));
	}
	/**
	 * Starts a new <code>Sale</code>.
	 */
	public void startNewSale() {
		this.currentSale = new Sale(inventoryRegistry);
	}

	/**
	 * Adds a certain amount of an <code>Item</code> to the list of items in the <code>Sale</code>.
	 * Also checks if the itemID is valid.
	 * 
	 * @param itemID ID-number of <code>Item</code> to be added to the <code>Sale</code>.
	 * @param amount number of <code>Item</code> to be added to <code>Sale</code>.
	 * 
	 * @return True if the itemID is valid, false if not.
	 */
	public boolean addItem(int itemID, int amount) {
		boolean isItemIdValid = currentSale.addItem(itemID, amount);
		return isItemIdValid;
	}
	
	/**
	 * Gets <code>Sale</code> information as a DTO.
	 * 
	 * @return <code>SaleDTO</code> object containing data on ongoing sale.
	 */
	public SaleDTO saleInfo() {
		return currentSale.getSaleInfo();
	}
	
	/**
	 * Fetches a customers <code>Discount</code> from the database and applies it to <code>Sale</code>
	 * and then updates <code>Sale</code> info.
	 * 
	 * @param customerID ID of customer that requests discount.
	 * @return Data of <code>Sale</code>  as an immutable <code>SaleDTO</code> .
	 */
	public SaleDTO discountRequest(String customerID) {
		List<DiscountDTO> discount = customerRegistry.fetchDiscount(customerID);
		currentSale.addDiscount(discount);
		return currentSale.getSaleInfo();
	}
	
	/**
	 * Finishes a sale by calculating change, updating the cash register, database and returning a <code>Receipt</code>
	 * for the finished <code>Sale</code>.
	 * 
	 * @param payment Payment recieved from customer.
	 * 
	 * @return <code>Receipt</code> for the finished <code>Sale</code>.
	 */
	public Receipt finishSale(Payment payment) {
		payment.calculateChange(currentSale.getPrice());
		Receipt receipt = new Receipt(currentSale.getSaleInfo(), payment, store);
		register.updateMoneyAmount(payment);
		saleRegistry.logSale(receipt);
		inventoryRegistry.updateInventor(receipt);
		return receipt;
	}
}
