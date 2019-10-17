package se.kth.iv1350.seminarium3.model;

/**
 * Observer pattern interface for observing sales.
 */
public interface SaleObserver {

    /**
     * Updates the observer with a price.
     * @param price <code>Price</code> to observe.
     */
    public void saleHasFinished(PriceDTO price);
}
