package ejercicio_3

import com.google.gson.Gson
import grails.converters.JSON
import groovy.json.JsonSlurper
import org.grails.web.json.JSONObject

class ClientController {

    def index() {

    }

    def getAgencies() {
        def siteId = params.site_id;
        def paymentMethod = params.payment_method_id;
        def nearTo = params.latitude+","+params.longitude;
        def url = new URL("http://localhost:4567/agencias?site_id=${siteId}&payment_method_id=${paymentMethod}&near_to=${nearTo}")
        def connection = (HttpURLConnection) url.openConnection()
        connection.setRequestMethod("GET")
        connection.setRequestProperty("Accept", "application/json")
        connection.setRequestProperty("User-Agent", "Mozilla/5.0")
        JsonSlurper json = new JsonSlurper()
        def result = json.parse(connection.getInputStream())
        render result as JSON
    }

    def saveAgency() {
        println params.agency
        def jsonSlurper = new JsonSlurper()
        def data = jsonSlurper.parseText(params.agency)
        Agency agency = createAgency(data);
        agency.save()
        return agency
    }

    def createAgency(agency) {
        Address address = new Address(agency.address.address_line, agency.address.city, agency.address.location, agency.address.country, agency.address.state, agency.address.zip_code, agency.address.other_info);
        return new Agency(address, Integer.parseInt(agency.agency_code), agency.description, agency.disabled, Double.parseDouble(agency.distance), agency.id, agency.payment_method_id, agency.phone, agency.site_id)
    }
}
