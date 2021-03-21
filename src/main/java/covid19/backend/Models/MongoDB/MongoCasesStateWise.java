package covid19.backend.Models.MongoDB;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "data_state_wise")
public class MongoCasesStateWise {

    @MongoId
    private String _id;
    @Indexed
    private String date;
    private String state;
    private String stateCode;
    private Integer confirmed;
    private Integer recovered;
    private Integer deaths;
    private Integer active;
    private Integer deltaConfirmed;
    private Integer deltaRecovered;
    private Integer deltaDeaths;

    public MongoCasesStateWise() {
    }

    public MongoCasesStateWise(String date, String state, String stateCode, Integer confirmed, Integer recovered, Integer deaths, Integer active, Integer deltaConfirmed, Integer deltaRecovered, Integer deltaDeaths) {
        this.date = date;
        this.state = state;
        this.stateCode = stateCode;
        this.confirmed = confirmed;
        this.recovered = recovered;
        this.deaths = deaths;
        this.active = active;
        this.deltaConfirmed = deltaConfirmed;
        this.deltaRecovered = deltaRecovered;
        this.deltaDeaths = deltaDeaths;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public Integer getRecovered() {
        return recovered;
    }

    public void setRecovered(Integer recovered) {
        this.recovered = recovered;
    }

    public Integer getDeaths() {
        return deaths;
    }

    public void setDeaths(Integer deaths) {
        this.deaths = deaths;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public Integer getDeltaConfirmed() {
        return deltaConfirmed;
    }

    public void setDeltaConfirmed(Integer deltaConfirmed) {
        this.deltaConfirmed = deltaConfirmed;
    }

    public Integer getDeltaRecovered() {
        return deltaRecovered;
    }

    public void setDeltaRecovered(Integer deltaRecovered) {
        this.deltaRecovered = deltaRecovered;
    }

    public Integer getDeltaDeaths() {
        return deltaDeaths;
    }

    public void setDeltaDeaths(Integer deltaDeaths) {
        this.deltaDeaths = deltaDeaths;
    }

    public int getTotalActive(){
        return this.confirmed - this.recovered - this.deaths;
    }

}
