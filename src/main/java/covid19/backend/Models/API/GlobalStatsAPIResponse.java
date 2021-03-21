package covid19.backend.Models.API;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class GlobalStatsAPIResponse {
    private Global global;
    private National national;

    public GlobalStatsAPIResponse() {
    }

    public GlobalStatsAPIResponse(Global global, National national) {
        this.global = global;
        this.national = national;
    }

    public Global getGlobal() {
        return global;
    }

    public void setGlobal(Global global) {
        this.global = global;
    }

    public National getNational() {
        return national;
    }

    public void setNational(National national) {
        this.national = national;
    }

    public static class Global {
        private String date;
        private String active;
        private String confirmed;
        private String recovered;
        private String deceased;
        private String deltaConfirmed;
        private String deltaRecovered;
        private String deltaDeceased;

        public Global() {
        }

        public Global(String date, String active, String confirmed, String recovered, String deceased, String deltaConfirmed, String deltaRecovered, String deltaDeceased) {
            this.date = date;
            this.active = active;
            this.confirmed = confirmed;
            this.recovered = recovered;
            this.deceased = deceased;
            this.deltaConfirmed = deltaConfirmed;
            this.deltaRecovered = deltaRecovered;
            this.deltaDeceased = deltaDeceased;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getActive() {
            return active;
        }

        public void setActive(String active) {
            this.active = active;
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

        public String getDeltaConfirmed() {
            return deltaConfirmed;
        }

        public void setDeltaConfirmed(String deltaConfirmed) {
            this.deltaConfirmed = deltaConfirmed;
        }

        public String getDeltaRecovered() {
            return deltaRecovered;
        }

        public void setDeltaRecovered(String deltaRecovered) {
            this.deltaRecovered = deltaRecovered;
        }

        public String getDeltaDeceased() {
            return deltaDeceased;
        }

        public void setDeltaDeceased(String deltaDeceased) {
            this.deltaDeceased = deltaDeceased;
        }
    }

    public static class National {
        private String confirmed;
        private ArrayList<Double> coordinates;

        public National() {
        }

        public National(String confirmed) {
            ArrayList<Double> coordinatesList = new ArrayList<>();
            coordinatesList.add(70.86671478454372);
            coordinatesList.add(23.184606689518663);

            this.confirmed = confirmed;
            this.coordinates = coordinatesList;
        }

        public String getConfirmed() {
            return confirmed;
        }

        public void setConfirmed(String confirmed) {
            this.confirmed = confirmed;
        }

        public ArrayList<Double> getCoordinates() {
            return coordinates;
        }

        public void setCoordinates(ArrayList<Double> coordinates) {
            this.coordinates = coordinates;
        }
    }
}
