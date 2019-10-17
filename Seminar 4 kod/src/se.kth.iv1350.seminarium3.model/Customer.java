package se.kth.iv1350.seminarium3.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Class meant to hold a certain customer represented by a person and their discounts.
 */
public class Customer {
	private Person customer;
	private List<Discount> discounts = new ArrayList<>();
	
	/**
	 * Creates an instance of Customer.
	 * 
	 * @param customer ID number of the customer.
	 */
	public Customer(Person customer) {
		this.customer = customer;
	}

	/**
	 * Used to add a discount to the customer.
	 * 
	 * @param discount Discount add.
	 */
	public void addDiscount(Discount discount) {
		this.discounts.add(discount);
	}

	/**
	 * Removes a discount from the customer.
	 *
	 * @param id Id of the discount to remove.
	 */
	public void removeDiscount(String id){
		for(Discount discount : discounts){
			if(discount.getId().equals(id)){
				discounts.remove(discount);
			}
		}
	}

	/**
	 * Checks if an id-number represents the <code>Customer</code> <code>Person</code>.
	 * @param id Id number of <code>Person</code> to find.
	 * @return <code>true</code> if the customer has the searched for id.
	 */
	public boolean isCustomer(String id){
		return customer.getPersonNr().equals(id);
	}
	/**
	 * Gets customers ID number.
	 * 
	 * @return Customers ID number.
	 */
	public String getCustomerID() {
		return customer.getPersonNr();
	}
	/**
	 * Gets customers discounts.
	 * 
	 * @return Value of discount.
	 */
	public List<DiscountDTO> getDiscount() {
		List<DiscountDTO> returnList = new ArrayList<>();
		for(Discount discount : discounts){
			returnList.add(new DiscountDTO(discount));
		}
		return returnList;
	}
}
