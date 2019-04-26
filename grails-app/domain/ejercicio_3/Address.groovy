package ejercicio_3

class Address {
    String address_line;
    String city;
    String location;
    String country;
    String state;
    String zip_code;
    String other_info;

    static constraints = {
    }

    Address(String address_line, String city, String location, String country, String state, String zip_code, String other_info) {
        this.address_line = address_line
        this.city = city
        this.location = location
        this.country = country
        this.state = state
        this.zip_code = zip_code
        this.other_info = other_info
    }
}
