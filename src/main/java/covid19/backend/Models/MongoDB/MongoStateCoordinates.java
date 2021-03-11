package covid19.backend.Models.MongoDB;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "state_coordinates")
public class MongoStateCoordinates {

    private String state;
    private Double latitude;
    private Double longitude;

    public MongoStateCoordinates() {
    }

    public MongoStateCoordinates(String state, Double latitude, Double longitude) {
        this.state = state;
        this.latitude = latitude;
        this.longitude = longitude;
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
