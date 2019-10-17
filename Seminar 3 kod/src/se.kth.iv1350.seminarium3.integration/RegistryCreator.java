package se.kth.iv1350.seminarium3.integration;
/**
 * This class is responsible for instantiating all registrys.
 */
public class RegistryCreator {
	
	private CustomerRegistry customerRegistry = new CustomerRegistry();
	private InventoryRegistry inventoryRegistry = new InventoryRegistry();
	private SaleRegistry saleRegistry = new SaleRegistry();
	
	/**
	 * Get the value of customerRegistry
	 * 
	 * @return the value of customerRegistry
	 */
	public CustomerRegistry getCustomerRegistry() {
		return customerRegistry;
	}
	
	/**
	 * Get the value of inventoryRegistry
	 * 
	 * @return the value of inventoryRegistry
	 */
	public InventoryRegistry getInventoryRegistry() {
		return inventoryRegistry;
	}
	
	/**
	 * Get the value of saleRegistry
	 * 
	 * @return the value of saleRegistry
	 */
	public SaleRegistry getSaleRegistry() {
		return saleRegistry;
	}
	
}
