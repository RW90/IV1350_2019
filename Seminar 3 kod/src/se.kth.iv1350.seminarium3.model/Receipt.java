package se.kth.iv1350.seminarium3.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Meant to represent a log of a <code>Sale</code> that has finished and now needs to be stored in
 * an archive for accounting and printed out as a proof of sale to the customer.
 */
public class Receipt {
    private final String timeOfSale;
    private final SaleDTO sale;
    private final Payment payment;
    private final Store store;

    /**
     * Creates the <code>Receipt</code> from a <code>Sale</code>.
     * @param sale <code>Sale</code> meant to be logged.
     * @param payment Customer payment.
     * @param store Store this sale took place in.
     */
    public Receipt( SaleDTO sale, Payment payment, Store store){
        this.sale = sale;
        this.payment = payment;
        this.store = store;
        String dateFormat = "yyyy-MM-dd HH:mm:ss";
        this.timeOfSale = LocalDateTime.now().format(DateTimeFormatter.ofPattern(dateFormat));
    }

    /**
     * Formats the <code>String</code> for printout.
     * @return <code>String</code> for printout.
     */
    public String toString(){
        String newSection = "\n";
        StringBuilder builder = new StringBuilder();
        builder.append(store.toString());
        builder.append(newSection);
        builder.append("Date: " + timeOfSale.toString());
        builder.append(newSection);
        builder.append(sale.toString());
        builder.append(newSection);
        builder.append(payment);

        return builder.toString();
    }
}
