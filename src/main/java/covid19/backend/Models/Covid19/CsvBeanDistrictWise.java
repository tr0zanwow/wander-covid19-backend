package covid19.backend.Models.Covid19;

import com.opencsv.bean.CsvBindByName;

public class CsvBeanDistrictWise {

    @CsvBindByName(column = "State_Code")
    private String stateCode;

    @CsvBindByName
    private String state;

    @CsvBindByName
    private String district;

    @CsvBindByName
    private Integer confirmed;

    @CsvBindByName
    private Integer active;

    @CsvBindByName
    private Integer recovered;

    @CsvBindByName
    private Integer deceased;

    @CsvBindByName(column = "Delta_Confirmed")
    private Integer deltaConfirmed;

    @CsvBindByName(column = "Delta_Active")
    private Integer deltaActive;

    @CsvBindByName(column = "Delta_Recovered")
    private Integer deltaRecovered;

    @CsvBindByName(column = "Delta_Deceased")
    private Integer deltaDeceased;


    public CsvBeanDistrictWise() {
    }

    public CsvBeanDistrictWise(String stateCode, String state, String district, Integer confirmed, Integer active, Integer recovered, Integer deceased, Integer deltaConfirmed, Integer deltaActive, Integer deltaRecovered, Integer deltaDeceased) {
        this.stateCode = stateCode;
        this.state = state;
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

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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
