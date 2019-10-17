package se.kth.iv1350.seminarium3.integration;

/**
 * <code>Exception</code> thrown when the program can not utilize the database.
 */
public class DatabaseFailureException extends RuntimeException{
    private String msg;
    private Throwable log;

    /**
     * For when the database has a failure
     * @param cause The log message that is supposed to inform admin/devs what to do.
     */
    public DatabaseFailureException(String cause){
        super("Registration failed.", new Throwable(cause));
    }
}
