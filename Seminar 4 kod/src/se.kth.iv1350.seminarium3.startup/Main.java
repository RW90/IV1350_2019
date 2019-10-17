package se.kth.iv1350.seminarium3.startup;

import se.kth.iv1350.seminarium3.controller.Controller;
import se.kth.iv1350.seminarium3.integration.RegistryCreator;
import se.kth.iv1350.seminarium3.view.View;

/**
* Contains the <code>main</code> method. Performs all startup
* of the application.
*/
public class Main {
	
	/**
	 * Starts the application.
	 *
	 * @param args The application does not take any command
	 * line parameters.
	 */
	public static void main(String[] args) {
		
		RegistryCreator registryCreator = new RegistryCreator();
		Controller contr = new Controller(registryCreator);
		View view = new View(contr);
		
		view.demoRun();

	}

}
