package se.kth.iv1350.seminarium3.model;

/**
 * Meant to represent a geographic address.
 */
public class Address {
    private final String streetName;
    private final String streetNumber;
    private final String postNr;
    private final String city;

    /**
     * Stores information about the store adress for the <code>Receipt</code>.
     * @param streetName
     * @param streetNumber
     * @param postNr
     * @param city
     */
    public Address(String streetName, String streetNumber, String postNr, String city){
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.postNr = postNr;
        this.city = city;
    }

    /**
     * Formats the <code>String</code> for <code>Receipt</code>.
     * @return A <code>String</code> representation of the <code>Adress</code>.
     */
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append(streetName + " " + streetNumber + ", " + postNr + ", " + city);
        return builder.toString();
    }
}
