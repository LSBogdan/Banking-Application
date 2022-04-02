package customer;


public class Address {
    private String county;
    private String city;
    private String street;
    private int number;
    private int postalCode;

    public Address(){
        this.county = "";
        this.city = "";
        this.street = "";
        this.number = 0;
        this.postalCode = 0;
    }

    public Address(String county, String city, String street, int number, int postalCode){
        this.county = county;
        this.city = city;
        this.street = street;
        this.number = number;
        this.postalCode = postalCode;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "county='" + county + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", number=" + number +
                ", postalCode=" + postalCode +
                '}';
    }
}
