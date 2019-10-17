package se.kth.iv1350.seminarium3.view;

import se.kth.iv1350.seminarium3.model.PriceDTO;
import se.kth.iv1350.seminarium3.model.SaleObserver;

/**
 * Observing for finished sales and updates total revenue display.
 */
public class TotalRevenueView implements SaleObserver {

    private int totalRevenue = 0;

    /**
     * Observer meant to observe revenuestreams.
     */
    public TotalRevenueView(){
        totalRevenue = 0;
        updateDisplay();
    }
    /**
     * Updates the observer with a price.
     * @param price <code>Price</code> to observe.
     */
    @Override
    public void saleHasFinished(PriceDTO price) {
        totalRevenue += price.getTotalPrice();
        updateDisplay();
    }

    private void updateDisplay(){
        System.out.println("Total rev display: ");
        System.out.println(totalRevenue + " total revenue since program initialization.");
    }
}