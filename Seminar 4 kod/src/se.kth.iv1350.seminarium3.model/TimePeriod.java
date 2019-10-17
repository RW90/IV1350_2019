package se.kth.iv1350.seminarium3.model;

import java.time.LocalDate;

/**
 * Class meant to represent a period of time represented by a start date and an end date.
 */
public class TimePeriod {
    private final LocalDate startDate;
    private final LocalDate endDate;

    /**
     * Creates a <code>TimePeriod</code> object with a specific start and end date.
     * @param startDate Time that the period starts.
     * @param endDate Time that the period ends.
     */
    public TimePeriod(LocalDate startDate, LocalDate endDate){
        this.startDate = startDate;
        this.endDate = endDate;
    }
    /**
     * Creates a <code>TimePeriod</code> object with a specific end date
     * and start date from the time the object is instanced.
     * @param endDate Time that the period ends.
     */
    public TimePeriod(LocalDate endDate){
        this.startDate = LocalDate.now();
        this.endDate = endDate;
    }

    /**
     * When the <code>TimePeriod</code> starts.
     * @return Date when it starts.
     */
    public LocalDate getStartDate() {
        return startDate;
    }

    /**
     * When the <code>TimePeriod</code> expires.
     * @return Date when it expires.
     */
    public LocalDate getEndDate() {
        return endDate;
    }

    /**
     * Checks if the date sent to the method is within the <code>TimePeriod</code>.
     * @param date Date to check.
     * @return <code>True</code> if date is within the <code>TimePeriod</code>.
     */
    public boolean isDateInPeriod(LocalDate date){
        return afterStart(date) && beforeEnd(date);
    }

    private boolean afterStart(LocalDate date){
        return date.compareTo(startDate) >= 0;
    }

    private boolean beforeEnd(LocalDate date){
        return date.compareTo(endDate) <= 0;
    }

    /**
     * Checks if the current date is within the <code>TimePeriod</code>.
     * @return <code>True</code> if current date is within the <code>TimePeriod</code>.
     */
    public boolean isCurrent(){
        return isDateInPeriod(LocalDate.now());
    }

    /**
     * Checks if the <code>TimePeriod</code> has passed.
     * @return <code>True</code> if <code>TimePeriod</code> has expired.
     */
    public boolean isExpired(){
        return beforeEnd(LocalDate.now());
    }

}
