package se.kth.iv1350.seminarium3.model;

/**
 * Class representing the cash register.
 */
public class CashRegister {
	private int moneyAmount = 0;
	
	/**
	 * Updates the money in the register.
	 * 
	 * @param payment Amount payed by customer. Gets added to the amount in the register.
	 */
	public void updateMoneyAmount(Payment payment) {
		this.moneyAmount += (payment.getPayAmount() - payment.getChangeAmount());
	}
	/**
	 * Get the value of moneyAmount.
	 * 
	 * @return Value of moneyAmount.
	 */
	public int getMoneyAmount() {
		return moneyAmount;
	}
}

