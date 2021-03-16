package covid19.backend.Models.API;

import java.util.ArrayList;

public class StateListAPIResponse {
    private String state;
    private Integer confirmed;
    private ArrayList<Double> coordinates;

    public StateListAPIResponse() {
    }

    public StateListAPIResponse(String state, Integer confirmed, ArrayList<Double> coordinates) {
        this.state = state;
        this.confirmed = confirmed;
        this.coordinates = coordinates;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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
