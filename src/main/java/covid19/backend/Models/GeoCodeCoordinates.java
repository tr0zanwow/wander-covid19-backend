package covid19.backend.Models;

import java.util.*;

public class GeoCodeCoordinates {

    private List<Object> data;

    public GeoCodeCoordinates() {
        super();
    }

    public GeoCodeCoordinates(List<Object> data) {
        this.data = data;
    }

    public List<Object> getData() {
        return data;
    }

    public void setData(List<Object> data) {
        if (data.size() != 0 && (data.get(0)) instanceof Map) {
            this.data = data;
        } else {
            this.data = Collections.EMPTY_LIST;
        }
    }

}
