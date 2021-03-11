package covid19.backend.Repository;

import covid19.backend.Models.GeoCodeCoordinates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class GeoCoding {

    @Autowired
    RestTemplate restTemplate;

    public GeoCoding() {
    }

    public GeoCodeCoordinates getCoordinates(String location) {
        return restTemplate.getForObject("http://api.positionstack.com/v1/forward?access_key=cea922545545ec86def36431b1f3bec9&query=" + location, GeoCodeCoordinates.class);
    }
}
