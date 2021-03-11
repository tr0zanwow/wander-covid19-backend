package covid19.backend.Models.MongoDB;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "district_coordinates")
public class MongoDistrictCoordinates {

    private String state;
    private String district;
    private Double latitude;
    private Double longitude;

    public MongoDistrictCoordinates() {
    }

    public MongoDistrictCoordinates(String state, String district, Double latitude, Double longitude) {
        this.state = state;
        this.district = district;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
