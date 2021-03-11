package covid19.backend.Models.MongoDB;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Document(collection = "data_news")
public class MongoCovidNews {

    @MongoId
    private String _id;
    private String place;
    private List<Articles> articles;

    public MongoCovidNews() {
    }

    public MongoCovidNews(String place, List<Articles> articles) {
        this.place = place;
        this.articles = articles;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public List<Articles> getArticles() {
        return articles;
    }

    public void setArticles(List<Articles> articles) {
        this.articles = articles;
    }

    public static class Articles {
        private String sourceName;
        private String title;
        private String url;
        private String imgUrl;
        private String publishedAt;

        public Articles() {
        }

        public Articles(String sourceName, String title, String url, String imgUrl, String publishedAt) {
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

        public class Source {
            private String name;

            public Source() {
            }

            public Source(String name) {
                this.name = name;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }
}
