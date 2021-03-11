package covid19.backend.Models.MongoDB;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;
import java.util.List;

@Document(collection = "data_video_news")
public class MongoCovidVideoNews {

    @MongoId
    private String _id;
    private String state;
    private List<VideoNews> news;

    public MongoCovidVideoNews() {
    }

    public MongoCovidVideoNews(String state, List<VideoNews> news) {
        this.state = state;
        this.news = news;
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

    public List<VideoNews> getNews() {
        return news;
    }

    public void setNews(List<VideoNews> news) {
        this.news = news;
    }

    public static class VideoNews {
        private String title;
        private String url;
        private String thumbnailUrl;
        private String publishDate;
        private String description;
        private String duration;
        private String channelName;

        public VideoNews() {
        }

        public VideoNews(String title, String url, String thumbnailUrl, String publishDate, String description, String duration, String channelName) {
            this.title = title;
            this.url = url;
            this.thumbnailUrl = thumbnailUrl;
            this.publishDate = publishDate;
            this.description = description;
            this.duration = duration;
            this.channelName = channelName;
        }

        public String getDuration() {
            return duration;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }

        public String getChannelName() {
            return channelName;
        }

        public void setChannelName(String channelName) {
            this.channelName = channelName;
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

        public String getThumbnailUrl() {
            return thumbnailUrl;
        }

        public void setThumbnailUrl(String thumbnailUrl) {
            this.thumbnailUrl = thumbnailUrl;
        }

        public String getPublishDate() {
            return publishDate;
        }

        public void setPublishDate(String publishDate) {
            this.publishDate = publishDate;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }
}
