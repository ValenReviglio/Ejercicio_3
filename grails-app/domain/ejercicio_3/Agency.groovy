package ejercicio_3

class Agency {

    Address address
    Integer agency_code
    String description
    String disabled
    Double distance
    String id
    String payment_method_id
    String phone
    String site_id
    static constraints = {
        agency_code nullable: false
        agency_code unique: true
    }

    Agency(Address address, Integer agency_code, String description, String disabled, Double distance, String id, String payment_method_id, String phone, String site_id) {
        this.address = address
        this.agency_code = agency_code
        this.description = description
        this.disabled = disabled
        this.distance = distance
        this.id = id
        this.payment_method_id = payment_method_id
        this.phone = phone
        this.site_id = site_id
    }

    @Override
    public String toString() {
        return "Agency{" +
                "address=" + address +
                ", agency_code=" + agency_code +
                ", description='" + description + '\'' +
                ", disabled='" + disabled + '\'' +
                ", distance=" + distance +
                ", id='" + id + '\'' +
                ", payment_method_id='" + payment_method_id + '\'' +
                ", phone='" + phone + '\'' +
                ", site_id='" + site_id + '\'' +
                '}';
    }
}
