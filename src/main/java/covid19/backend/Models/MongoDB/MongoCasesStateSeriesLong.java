package covid19.backend.Models.MongoDB;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "data_state_series_long")
public class MongoCasesStateSeriesLong {

    @MongoId
    private String _id;
    private String date;
    private String state;
    private String confirmed;
    private String recovered;
    private String deceased;

    public MongoCasesStateSeriesLong() {
    }

    public MongoCasesStateSeriesLong(String date, String state, String confirmed, String recovered, String deceased) {
        this.date = date;
        this.state = state;
        this.confirmed = confirmed;
        this.recovered = recovered;
        this.deceased = deceased;
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

    public int getTotalActive(){
        return Integer.parseInt(this.confirmed) - Integer.parseInt(this.recovered) - Integer.parseInt(this.deceased);
    }

}
