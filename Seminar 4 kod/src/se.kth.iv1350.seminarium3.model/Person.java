package se.kth.iv1350.seminarium3.model;

/**
 * Meant to represent a person.
 */
public class Person {
    private final String personNr;
    private String firstName;
    private String lastName;

    /**
     * Creates an instance of a person meant to represent a customer at the store.
     *
     * @param personNr The persons id-number. Immutable after setting.
     * @param firstName The persons first name.
     * @param lastName The persons last name.
     */
    public Person(String personNr, String firstName, String lastName){
        this.personNr = personNr;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Getter for persons id-number.
     * @return <code>personNr</code> field.
     */
    public String getPersonNr() {
        return personNr;
    }

    /**
     * Getter for persons first name.
     * @return <code>firstName</code> field.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Setter for persons first name.
     * @param firstName The persons new first name.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Getter for persons last name.
     * @return <code>lastName</code> field.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Setter for persons last name.
     * @param lastName The persons new last name.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
