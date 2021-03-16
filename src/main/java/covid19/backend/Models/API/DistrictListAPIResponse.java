package covid19.backend.Models.API;

import java.util.ArrayList;

public class DistrictListAPIResponse {
    private String district;
    private Integer confirmed;
    private ArrayList<Double> coordinates;

    public DistrictListAPIResponse() {
    }

    public DistrictListAPIResponse(String district, Integer confirmed, ArrayList<Double> coordinates) {
        this.district = district;
        this.confirmed = confirmed;
        this.coordinates = coordinates;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Integer getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Integer confirmed) {
        this.confirmed = confirmed;
    }

    public ArrayList<Double> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(ArrayList<Double> coordinates) {
        this.coordinates = coordinates;
    }
}
