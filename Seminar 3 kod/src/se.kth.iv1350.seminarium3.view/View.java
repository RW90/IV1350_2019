package se.kth.iv1350.seminarium3.view;

import se.kth.iv1350.seminarium3.controller.Controller;
import se.kth.iv1350.seminarium3.model.Payment;
import se.kth.iv1350.seminarium3.model.Printer;
import se.kth.iv1350.seminarium3.model.Receipt;

/**
 * Class meant to represent the whole view layer from MVC-pattern.
 */
public class View {
	private final Controller contr;
	private final Printer printer;
	/**
	 * Creates an instance of View
	 * 
	 * @param controller Sets immutable controller.
	 */
	public View(Controller controller) {
		this.contr = controller;
		this.printer = new Printer();
	}

	/**
	 * Meant to demonstrate program functionality.
	 */
	public void demoRun() {
		
		System.out.println("Starting new sale");
		contr.startNewSale();
		
		System.out.println("Adding item");
		contr.addItem(1, 1);
		System.out.println(contr.saleInfo().toString());
		
		System.out.println("Adding item");
		contr.addItem(2, 3);
		System.out.println(contr.saleInfo().toString());
		
		System.out.println("Adding item");
		contr.addItem(3, 2);
		System.out.println(contr.saleInfo().toString());
		
		System.out.println("Adding item");
		contr.addItem(1, 2);
		System.out.println(contr.saleInfo().toString());
		
		System.out.println("Requesting discount");
		contr.discountRequest("950622");
		System.out.println(contr.saleInfo().toString());
		
		System.out.println("Finishing sale");
		Payment payment = new Payment(200);
		Receipt receipt = contr.finishSale(payment);
		printer.printReceipt(receipt);
	}
}
