package covid19.backend.Models.API;

import java.util.List;

public class OverviewStatsAPIResponse {
    private OverviewStats statistics;
    private List<OverviewSeries> series;
    private List<OverviewNews> news;

    public OverviewStatsAPIResponse() {
    }

    public OverviewStatsAPIResponse(OverviewStats statistics, List<OverviewSeries> series, List<OverviewNews> news) {
        this.statistics = statistics;
        this.series = series;
        this.news = news;
    }

    public OverviewStats getStatistics() {
        return statistics;
    }

    public void setStatistics(OverviewStats statistics) {
        this.statistics = statistics;
    }

    public List<OverviewSeries> getSeries() {
        return series;
    }

    public void setSeries(List<OverviewSeries> series) {
        this.series = series;
    }

    public List<OverviewNews> getNews() {
        return news;
    }

    public void setNews(List<OverviewNews> news) {
        this.news = news;
    }

    public static class OverviewStats {
        private String date;
        private String active;
        private String confirmed;
        private String recovered;
        private String deceased;
        private String deltaConfirmed;
        private String deltaRecovered;
        private String deltaDeceased;

        public OverviewStats() {
        }

        public OverviewStats(String date, String active, String confirmed, String recovered, String deceased, String deltaConfirmed, String deltaRecovered, String deltaDeceased) {
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

    public static class OverviewNews {
        private String sourceName;
        private String title;
        private String url;
        private String imgUrl;
        private String publishedAt;

        public OverviewNews() {
        }

        public OverviewNews(String sourceName, String title, String url, String imgUrl, String publishedAt) {
            this.sourceName = sourceName;
            this.title = title;
            this.url = url;
            this.imgUrl = imgUrl;
            this.publishedAt = publishedAt;
        }

        public String getSourceName() {
            return sourceName;
        }

        public void setSourceName(String sourceName) {
            this.sourceName = sourceName;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }
    }

    public static class OverviewSeries {
        private String date;
        private String confirmed;
        private String recovered;
        private String deceased;

        public OverviewSeries() {
        }

        public OverviewSeries(String date, String confirmed, String recovered, String deceased) {
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
