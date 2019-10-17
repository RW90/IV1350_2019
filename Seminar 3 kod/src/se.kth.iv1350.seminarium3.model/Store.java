package se.kth.iv1350.seminarium3.model;

/**
 * Meant to represent the physical grocery store with name and address fields.
 */
public class Store {
    private String name;
    private Address address;

    /**
     * Creates a representation for the store the point-of-sale is located in.
     * @param name Name of the store.
     * @param address Address of the store.
     */
    public Store(String name, Address address){
        this.name = name;
        this.address = address;
    }

    /**
     * Returns <code>String</code> representation of the <code>Store</code>.
     * @return <code>String</code> representation.
     */
    public String toString(){
        String decoration = "========";
        StringBuilder builder = new StringBuilder();
        builder.append(decoration + " " + name + " " + decoration + "\n");
        builder.append(address);
        return builder.toString();
    }
}
