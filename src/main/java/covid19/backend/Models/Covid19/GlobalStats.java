package covid19.backend.Models.Covid19;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GlobalStats {
    @JsonProperty("Global")
    private Global global;

    public GlobalStats() {
    }

    public GlobalStats(Global global) {
        this.global = global;
    }

    public Global getGlobal() {
        return global;
    }

    public void setGlobal(Global global) {
        this.global = global;
    }

    public class Global {
        @JsonProperty("NewConfirmed")
        private Integer newConfirmed;
        @JsonProperty("TotalConfirmed")
        private Integer totalConfirmed;
        @JsonProperty("NewDeaths")
        private Integer newDeaths;
        @JsonProperty("TotalDeaths")
        private Integer totalDeaths;
        @JsonProperty("NewRecovered")
        private Integer newRecovered;
        @JsonProperty("TotalRecovered")
        private Integer totalRecovered;
        @JsonProperty("Date")
        private String date;

        public Global() {
        }

        public Global(Integer newConfirmed, Integer totalConfirmed, Integer newDeaths, Integer totalDeaths, Integer newRecovered, Integer totalRecovered, String date) {
            this.newConfirmed = newConfirmed;
            this.totalConfirmed = totalConfirmed;
            this.newDeaths = newDeaths;
            this.totalDeaths = totalDeaths;
            this.newRecovered = newRecovered;
            this.totalRecovered = totalRecovered;
            this.date = date;
        }

        public Integer getNewConfirmed() {
            return newConfirmed;
        }

        public void setNewConfirmed(Integer newConfirmed) {
            this.newConfirmed = newConfirmed;
        }

        public Integer getTotalConfirmed() {
            return totalConfirmed;
        }

        public void setTotalConfirmed(Integer totalConfirmed) {
            this.totalConfirmed = totalConfirmed;
        }

        public Integer getNewDeaths() {
            return newDeaths;
        }

        public void setNewDeaths(Integer newDeaths) {
            this.newDeaths = newDeaths;
        }

        public Integer getTotalDeaths() {
            return totalDeaths;
        }

        public void setTotalDeaths(Integer totalDeaths) {
            this.totalDeaths = totalDeaths;
        }

        public Integer getNewRecovered() {
            return newRecovered;
        }

        public void setNewRecovered(Integer newRecovered) {
            this.newRecovered = newRecovered;
        }

        public Integer getTotalRecovered() {
            return totalRecovered;
        }

        public void setTotalRecovered(Integer totalRecovered) {
            this.totalRecovered = totalRecovered;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getDateEpoch(){
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
            Date date = null;
            try {
                date = df.parse(this.date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            assert date != null;
            return String.valueOf(date.getTime());
        }
    }
}
