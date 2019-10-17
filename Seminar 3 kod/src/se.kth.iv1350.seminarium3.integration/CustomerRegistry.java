package se.kth.iv1350.seminarium3.integration;

import se.kth.iv1350.seminarium3.model.Customer;
import se.kth.iv1350.seminarium3.model.Discount;
import se.kth.iv1350.seminarium3.model.Person;
import se.kth.iv1350.seminarium3.model.TimePeriod;
import se.kth.iv1350.seminarium3.model.DiscountDTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Meant to represent communication with a database of customers.
 */
public class CustomerRegistry {
	private List<Customer> customersInDatabase = new ArrayList<>();
	/**
	 * Creates a new instance of CustomerRegistry.
	 */
	CustomerRegistry(){
		addListOfCustomers();
	}
	/**
	 * Meant for demo purposes to add customers to fake database.
	 */
	private void addListOfCustomers() {
		Person firstCustomer = new Person("570327", "Olle", "Karlsson");
		Person secondCustomer = new Person("950622", "Nina", "Backlund");
		customersInDatabase.add(new Customer(firstCustomer));
		customersInDatabase.add(new Customer(secondCustomer));
		Discount firstDiscount = new Discount(0.9f, "Pensionsrabatt", new TimePeriod(LocalDate.MAX));
		Discount secondDiscount = new Discount(0.8f, "Ungdomsrabatt", new TimePeriod(LocalDate.MAX));
		customersInDatabase.get(0).addDiscount(firstDiscount);
		customersInDatabase.get(1).addDiscount(secondDiscount);

	}

	/**
	 * Gets all discounts associated with <code>Customer</code> with id sent as argument.
	 * @param customerID Id of <code>Customer</code> requesting discounts.
	 * @return <code>List</code> of <code>DiscountDTO</code> for customer with id customerID.
	 */
	public List<DiscountDTO> fetchDiscount(String customerID) {
		for (Customer customer : customersInDatabase) {
			if (customer.isCustomer(customerID)) {
				return customer.getDiscount();
			}
		}
		return null;
	}
}

