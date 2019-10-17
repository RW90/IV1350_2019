package se.kth.iv1350.seminarium3.view;

/**
 * Meant to handle error displaying to the UI. Actually just displays to System.out.
 */
public class ErrorDisplay{

    /**
     * Dummy funciton meant to display the error in some way to the UI. Writes to System.out.
     * @param e <code>Exception</code> to display.
     */
    public void displayError(Exception e){
        System.out.println("Displaying error: ");
        System.out.println(e);
    }
}
