package covid19.backend.Models.API;

import java.util.List;

public class OverviewStatsAPIResponse {
    private OverviewStats statistics;
    private List<OverviewStats> series;
    private List<OverviewNews> news;

    public OverviewStatsAPIResponse() {
    }

    public OverviewStatsAPIResponse(OverviewStats statistics, List<OverviewStats> series, List<OverviewNews> news) {
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

    public List<OverviewStats> getSeries() {
        return series;
    }

    public void setSeries(List<OverviewStats> series) {
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
        private String confirmed;
        private String recovered;
        private String deceased;

        public OverviewStats() {
        }

        public OverviewStats(String date, String confirmed, String recovered, String deceased) {
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
}
