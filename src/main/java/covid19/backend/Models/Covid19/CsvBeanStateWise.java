package covid19.backend.Models.Covid19;

import com.opencsv.bean.CsvBindByName;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CsvBeanStateWise implements Serializable {

    @CsvBindByName(column = "Last_Updated_Time")
    private String lastUpdatedTime;
    @CsvBindByName
    private String state;
    @CsvBindByName
    private Integer confirmed;
    @CsvBindByName
    private Integer recovered;
    @CsvBindByName
    private Integer deaths;
    @CsvBindByName
    private Integer active;
    @CsvBindByName(column = "State_code")
    private String stateCode;
    @CsvBindByName(column = "Delta_Confirmed")
    private Integer deltaConfirmed;
    @CsvBindByName(column = "Delta_Recovered")
    private Integer deltaRecovered;
    @CsvBindByName(column = "Delta_Deaths")
    private Integer deltaDeaths;

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

    public String getlastUpdatedTime() {
        return getDateEpoch();
    }

    public void setlastUpdatedTime(String lastUpdatedTime) {
        this.lastUpdatedTime = lastUpdatedTime;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
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

    public String getDateEpoch(){
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss zz");
        Date date = null;
        try {
            date = df.parse(this.lastUpdatedTime+" GMT+05:30");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        assert date != null;
        return String.valueOf(date.getTime());
    }

}