package FunctionLayer;


/**
 * @author Nikolaj
 *
 * Denne klasse indeholder kontakt information om en kunde.
 */

public class Contact {


    private String email;
    private String name;
    private int phoneNumber;
    private String streetName;
    private String houseNumber;
    private int postalCode;



    public Contact(String email, String name, int phoneNumber, String streetName, String houseNumber, int postalCode){
        
        this.email = email;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.streetName = streetName;
        this.houseNumber = houseNumber;
        this.postalCode = postalCode;
    }


    public String getEmail  () { return email;}

    public void setEmail (String email) {this.email = email;}


    public String getName () { return name;}

    public void setName (String name) {this.name = name;}


    public int getPhoneNumber () { return phoneNumber;}

    public void setPhoneNumber (int phoneNumber) {this.phoneNumber = phoneNumber;}


    public String getStreetName () { return streetName;}

    public void setStreetName (String streetName) {this.streetName = streetName;}


    public String getHouseNumber () { return houseNumber;}

    public void setHouseNumber (String houseNumber) {this.houseNumber = houseNumber;}


    public int getPostalCode () { return postalCode;}

    public void setPostalCode (int postalCode) {this.postalCode = postalCode;}

    @Override
    public String toString() {
        return  "Email: " + getEmail() +
                "Name: " + getName() +
         "Phone Number: " + getPhoneNumber() +
         "Street Name: " + getStreetName() +
         "House Number: " + getHouseNumber() +
         "Postal Code: " + getPostalCode();

    }


}
