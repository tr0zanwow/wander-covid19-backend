package covid19.backend.Models.Covid19;

import com.opencsv.bean.CsvBindByName;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CsvBeanStateSeriesLong {

    @CsvBindByName(column = "Date")
    private String date;
    @CsvBindByName(column = "State")
    private String state;
    @CsvBindByName(column = "Confirmed")
    private String confirmed;
    @CsvBindByName(column = "Recovered")
    private String recovered;
    @CsvBindByName(column = "Deceased")
    private String deceased;

    public CsvBeanStateSeriesLong() {
    }

    public CsvBeanStateSeriesLong(String date, String state, String confirmed, String recovered, String deceased) {
        this.date = date;
        this.state = state;
        this.confirmed = confirmed;
        this.recovered = recovered;
        this.deceased = deceased;
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

    public String getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(String confirmed) {
        this.confirmed = confirmed;
    }

    public String getRecovered() {
        return recovered;
    }

    public void setRecovered(String recovered) {
        this.recovered = recovered;
    }

    public String getDeceased() {
        return deceased;
    }

    public void setDeceased(String deceased) {
        this.deceased = deceased;
    }

    public String getDateEpoch(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss zz");
        Date date = null;
        try {
            date = df.parse(this.date+" 06:00:00 GMT+05:30");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        assert date != null;
        return String.valueOf(date.getTime());
    }
}
