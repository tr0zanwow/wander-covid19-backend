package covid19.backend.Models.API;

public class NationLatestAPIResponse {
    private String confirmed;
    private String recovered;
    private String deceased;

    public NationLatestAPIResponse() {
    }

    public NationLatestAPIResponse(String confirmed, String recovered, String deceased) {
        this.confirmed = confirmed;
        this.recovered = recovered;
        this.deceased = deceased;
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
