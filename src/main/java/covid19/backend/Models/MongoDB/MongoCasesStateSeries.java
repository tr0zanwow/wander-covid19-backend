package covid19.backend.Models.MongoDB;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "data_state_series")
public class MongoCasesStateSeries {

    @MongoId
    private String _id;
    private String state;
    private List<DailySeries> series;

    public MongoCasesStateSeries() {
        this.series = new ArrayList<>();
    }

    public MongoCasesStateSeries(String state, List<DailySeries> series) {
        this.state = state;
        this.series = series;
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

    public List<DailySeries> getSeries() {
        return series;
    }

    public void setSeries(List<DailySeries> series) {
        this.series = series;
    }

    public static class DailySeries {
        private String date;
        private String confirmed;
        private String recovered;
        private String deceased;

        public DailySeries() {
        }

        public DailySeries(String date, String confirmed, String recovered, String deceased) {
            this.date = date;
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
    }
}
