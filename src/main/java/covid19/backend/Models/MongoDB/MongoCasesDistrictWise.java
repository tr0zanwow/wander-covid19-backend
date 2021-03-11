package covid19.backend.Models.MongoDB;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "data_district_wise")
public class MongoCasesDistrictWise {

    @MongoId
    private String _id;
    @Indexed
    private String state;
    private String stateCode;
    private String district;
    private Integer confirmed;
    private Integer active;
    private Integer recovered;
    private Integer deceased;
    private Integer deltaConfirmed;
    private Integer deltaActive;
    private Integer deltaRecovered;
    private Integer deltaDeceased;

    public MongoCasesDistrictWise() {
    }

    public MongoCasesDistrictWise(String state, String stateCode, String district, Integer confirmed, Integer active, Integer recovered, Integer deceased, Integer deltaConfirmed, Integer deltaActive, Integer deltaRecovered, Integer deltaDeceased) {
        this.state = state;
        this.stateCode = stateCode;
        this.district = district;
        this.confirmed = confirmed;
        this.active = active;
        this.recovered = recovered;
        this.deceased = deceased;
        this.deltaConfirmed = deltaConfirmed;
        this.deltaActive = deltaActive;
        this.deltaRecovered = deltaRecovered;
        this.deltaDeceased = deltaDeceased;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
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

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public Integer getRecovered() {
        return recovered;
    }

    public void setRecovered(Integer recovered) {
        this.recovered = recovered;
    }

    public Integer getDeceased() {
        return deceased;
    }

    public void setDeceased(Integer deceased) {
        this.deceased = deceased;
    }

    public Integer getDeltaConfirmed() {
        return deltaConfirmed;
    }

    public void setDeltaConfirmed(Integer deltaConfirmed) {
        this.deltaConfirmed = deltaConfirmed;
    }

    public Integer getDeltaActive() {
        return deltaActive;
    }

    public void setDeltaActive(Integer deltaActive) {
        this.deltaActive = deltaActive;
    }

    public Integer getDeltaRecovered() {
        return deltaRecovered;
    }

    public void setDeltaRecovered(Integer deltaRecovered) {
        this.deltaRecovered = deltaRecovered;
    }

    public Integer getDeltaDeceased() {
        return deltaDeceased;
    }

    public void setDeltaDeceased(Integer deltaDeceased) {
        this.deltaDeceased = deltaDeceased;
    }
}
