package se.kth.iv1350.seminarium3.integration;

/**
 * Class meant to log errors that occur that aren't supposed to be displayed in the UI.
 * However, since no actual I/O is needed this class displays at System.out.
 */
public class ErrorLogger {

    /**
     * Dummy function meant to simulate logging errors but actually sending them to system.out.
     * @param e <code>Exception</code> meant to be logged.
     */
    public void logError(Throwable e){
        System.out.println("Log error: ");
        System.out.println(e);
    }
}
