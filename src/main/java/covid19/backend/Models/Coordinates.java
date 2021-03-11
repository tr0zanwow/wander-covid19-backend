package covid19.backend.Models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "latitude",
        "longitude",
        "type",
        "name",
        "number",
        "postal_code",
        "street",
        "confidence",
        "region",
        "region_code",
        "county",
        "locality",
        "administrative_area",
        "neighbourhood",
        "country",
        "country_code",
        "continent",
        "label"
})
public class Coordinates {

    @JsonProperty("latitude")
    private Double latitude;
    @JsonProperty("longitude")
    private Double longitude;
    @JsonProperty("type")
    private String type;
    @JsonProperty("name")
    private String name;
    @JsonProperty("number")
    private Object number;
    @JsonProperty("postal_code")
    private Object postalCode;
    @JsonProperty("street")
    private Object street;
    @JsonProperty("confidence")
    private Integer confidence;
    @JsonProperty("region")
    private String region;
    @JsonProperty("region_code")
    private String regionCode;
    @JsonProperty("county")
    private String county;
    @JsonProperty("locality")
    private String locality;
    @JsonProperty("administrative_area")
    private Object administrativeArea;
    @JsonProperty("neighbourhood")
    private Object neighbourhood;
    @JsonProperty("country")
    private String country;
    @JsonProperty("country_code")
    private String countryCode;
    @JsonProperty("continent")
    private String continent;
    @JsonProperty("label")
    private String label;

    /**
     * No args constructor for use in serialization
     */
    public Coordinates() {
    }

    /**
     * @param continent
     * @param country
     * @param latitude
     * @param postalCode
     * @param confidence
     * @param county
     * @param locality
     * @param label
     * @param type
     * @param administrativeArea
     * @param number
     * @param regionCode
     * @param street
     * @param neighbourhood
     * @param countryCode
     * @param name
     * @param region
     * @param longitude
     */
    public Coordinates(Double latitude, Double longitude, String type, String name, Object number, Object postalCode, Object street, Integer confidence, String region, String regionCode, String county, String locality, Object administrativeArea, Object neighbourhood, String country, String countryCode, String continent, String label) {
        super();
        this.latitude = latitude;
        this.longitude = longitude;
        this.type = type;
        this.name = name;
        this.number = number;
        this.postalCode = postalCode;
        this.street = street;
        this.confidence = confidence;
        this.region = region;
        this.regionCode = regionCode;
        this.county = county;
        this.locality = locality;
        this.administrativeArea = administrativeArea;
        this.neighbourhood = neighbourhood;
        this.country = country;
        this.countryCode = countryCode;
        this.continent = continent;
        this.label = label;
    }

    @JsonProperty("latitude")
    public Double getLatitude() {
        return latitude;
    }

    @JsonProperty("latitude")
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    @JsonProperty("longitude")
    public Double getLongitude() {
        return longitude;
    }

    @JsonProperty("longitude")
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("number")
    public Object getNumber() {
        return number;
    }

    @JsonProperty("number")
    public void setNumber(Object number) {
        this.number = number;
    }

    @JsonProperty("postal_code")
    public Object getPostalCode() {
        return postalCode;
    }

    @JsonProperty("postal_code")
    public void setPostalCode(Object postalCode) {
        this.postalCode = postalCode;
    }

    @JsonProperty("street")
    public Object getStreet() {
        return street;
    }

    @JsonProperty("street")
    public void setStreet(Object street) {
        this.street = street;
    }

    @JsonProperty("confidence")
    public Integer getConfidence() {
        return confidence;
    }

    @JsonProperty("confidence")
    public void setConfidence(Integer confidence) {
        this.confidence = confidence;
    }

    @JsonProperty("region")
    public String getRegion() {
        return region;
    }

    @JsonProperty("region")
    public void setRegion(String region) {
        this.region = region;
    }

    @JsonProperty("region_code")
    public String getRegionCode() {
        return regionCode;
    }

    @JsonProperty("region_code")
    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    @JsonProperty("county")
    public String getCounty() {
        return county;
    }

    @JsonProperty("county")
    public void setCounty(String county) {
        this.county = county;
    }

    @JsonProperty("locality")
    public String getLocality() {
        return locality;
    }

    @JsonProperty("locality")
    public void setLocality(String locality) {
        this.locality = locality;
    }

    @JsonProperty("administrative_area")
    public Object getAdministrativeArea() {
        return administrativeArea;
    }

    @JsonProperty("administrative_area")
    public void setAdministrativeArea(Object administrativeArea) {
        this.administrativeArea = administrativeArea;
    }

    @JsonProperty("neighbourhood")
    public Object getNeighbourhood() {
        return neighbourhood;
    }

    @JsonProperty("neighbourhood")
    public void setNeighbourhood(Object neighbourhood) {
        this.neighbourhood = neighbourhood;
    }

    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    @JsonProperty("country_code")
    public String getCountryCode() {
        return countryCode;
    }

    @JsonProperty("country_code")
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @JsonProperty("continent")
    public String getContinent() {
        return continent;
    }

    @JsonProperty("continent")
    public void setContinent(String continent) {
        this.continent = continent;
    }

    @JsonProperty("label")
    public String getLabel() {
        return label;
    }

    @JsonProperty("label")
    public void setLabel(String label) {
        this.label = label;
    }

}