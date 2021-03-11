package covid19.backend.Models.Covid19;

import com.opencsv.bean.CsvBindByName;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CsvBeanNationSeries {

    @CsvBindByName(column = "Date_YMD")
    private String date;

    @CsvBindByName(column = "Daily Confirmed")
    private Integer dailyConfirmed;

    @CsvBindByName(column = "Total Confirmed")
    private Integer totalConfirmed;

    @CsvBindByName(column = "Daily Recovered")
    private Integer dailyRecovered;

    @CsvBindByName(column = "Total Recovered")
    private Integer totalRecovered;

    @CsvBindByName(column = "Daily Deceased")
    private Integer dailyDeceased;

    @CsvBindByName(column = "Total Deceased")
    private Integer totalDeceased;

    public CsvBeanNationSeries() {
    }

    public CsvBeanNationSeries(String date, Integer dailyConfirmed, Integer totalConfirmed, Integer dailyRecovered, Integer totalRecovered, Integer dailyDeceased, Integer totalDeceased) {
        this.date = date;
        this.dailyConfirmed = dailyConfirmed;
        this.totalConfirmed = totalConfirmed;
        this.dailyRecovered = dailyRecovered;
        this.totalRecovered = totalRecovered;
        this.dailyDeceased = dailyDeceased;
        this.totalDeceased = totalDeceased;
    }

    public String getdate() {
        return date;
    }

    public void setdate(String date) {
        this.date = date;
    }

    public Integer getdailyConfirmed() {
        return dailyConfirmed;
    }

    public void setdailyConfirmed(Integer dailyConfirmed) {
        this.dailyConfirmed = dailyConfirmed;
    }

    public Integer getTotalConfirmed() {
        return totalConfirmed;
    }

    public void setTotalConfirmed(Integer totalConfirmed) {
        this.totalConfirmed = totalConfirmed;
    }

    public Integer getDailyRecovered() {
        return dailyRecovered;
    }

    public void setDailyRecovered(Integer dailyRecovered) {
        this.dailyRecovered = dailyRecovered;
    }

    public Integer getTotalRecovered() {
        return totalRecovered;
    }

    public void setTotalRecovered(Integer totalRecovered) {
        this.totalRecovered = totalRecovered;
    }

    public Integer getDailyDeceased() {
        return dailyDeceased;
    }

    public void setDailyDeceased(Integer dailyDeceased) {
        this.dailyDeceased = dailyDeceased;
    }

    public Integer getTotalDeceased() {
        return totalDeceased;
    }

    public void setTotalDeceased(Integer totalDeceased) {
        this.totalDeceased = totalDeceased;
    }

    public String getDate2Epoch(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss aa zz");
        Date date = null;
        try {
            date = df.parse(this.date+" 09:00:00 AM GMT+05:30");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        assert date != null;
        return String.valueOf(date.getTime());
    }

}
