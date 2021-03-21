package covid19.backend.Models.MongoDB;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "data_nation_latest")
public class MongoNationLatestData {

    private String date;
    private Integer dailyConfirmed;
    private Integer totalConfirmed;
    private Integer dailyRecovered;
    private Integer totalRecovered;
    private Integer dailyDeceased;
    private Integer totalDeceased;

    public MongoNationLatestData() {
    }

    public MongoNationLatestData(String date, Integer dailyConfirmed, Integer totalConfirmed, Integer dailyRecovered, Integer totalRecovered, Integer dailyDeceased, Integer totalDeceased) {
        this.date = date;
        this.dailyConfirmed = dailyConfirmed;
        this.totalConfirmed = totalConfirmed;
        this.dailyRecovered = dailyRecovered;
        this.totalRecovered = totalRecovered;
        this.dailyDeceased = dailyDeceased;
        this.totalDeceased = totalDeceased;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getDailyConfirmed() {
        return dailyConfirmed;
    }

    public void setDailyConfirmed(Integer dailyConfirmed) {
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

    public Integer getActive(){
        return this.totalConfirmed - this.totalRecovered - this.totalDeceased;
    }
}
