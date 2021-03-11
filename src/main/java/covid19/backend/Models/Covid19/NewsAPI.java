package covid19.backend.Models.Covid19;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "status",
        "totalResults",
        "articles"
})
public class NewsAPI {

    @JsonProperty("status")
    private String status;
    @JsonProperty("totalResults")
    private Integer totalResults;
    @JsonProperty("articles")
    private List<Article> articles = null;

    public NewsAPI() {
    }
    public NewsAPI(String status, Integer totalResults, List<Article> articles) {
        super();
        this.status = status;
        this.totalResults = totalResults;
        this.articles = articles;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("totalResults")
    public Integer getTotalResults() {
        return totalResults;
    }

    @JsonProperty("totalResults")
    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    @JsonProperty("articles")
    public List<Article> getArticles() {
        return articles;
    }

    @JsonProperty("articles")
    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
            "source",
            "author",
            "title",
            "description",
            "url",
            "urlToImage",
            "publishedAt",
            "content"
    })
    public static class Article {

        @JsonProperty("source")
        private Source source;
        @JsonProperty("author")
        private String author;
        @JsonProperty("title")
        private String title;
        @JsonProperty("description")
        private String description;
        @JsonProperty("url")
        private String url;
        @JsonProperty("urlToImage")
        private String urlToImage;
        @JsonProperty("publishedAt")
        private String publishedAt;
        @JsonProperty("content")
        private String content;

        public Article() {
        }

        public Article(Source source, String author, String title, String description, String url, String urlToImage, String publishedAt, String content) {
            super();
            this.source = source;
            this.author = author;
            this.title = title;
            this.description = description;
            this.url = url;
            this.urlToImage = urlToImage;
            this.publishedAt = publishedAt;
            this.content = content;
        }

        @JsonProperty("source")
        public Source getSource() {
            return source;
        }

        @JsonProperty("source")
        public void setSource(Source source) {
            this.source = source;
        }

        @JsonProperty("author")
        public String getAuthor() {
            return author;
        }

        @JsonProperty("author")
        public void setAuthor(String author) {
            this.author = author;
        }

        @JsonProperty("title")
        public String getTitle() {
            return title;
        }

        @JsonProperty("title")
        public void setTitle(String title) {
            this.title = title;
        }

        @JsonProperty("description")
        public String getDescription() {
            return description;
        }

        @JsonProperty("description")
        public void setDescription(String description) {
            this.description = description;
        }

        @JsonProperty("url")
        public String getUrl() {
            return url;
        }

        @JsonProperty("url")
        public void setUrl(String url) {
            this.url = url;
        }

        @JsonProperty("urlToImage")
        public String getUrlToImage() {
            return urlToImage;
        }

        @JsonProperty("urlToImage")
        public void setUrlToImage(String urlToImage) {
            this.urlToImage = urlToImage;
        }

        @JsonProperty("publishedAt")
        public String getPublishedAt() {
            return publishedAt;
        }

        @JsonProperty("publishedAt")
        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        @JsonProperty("content")
        public String getContent() {
            return content;
        }

        @JsonProperty("content")
        public void setContent(String content) {
            this.content = content;
        }

        public String getPublishedDateEpoch() throws ParseException {
            SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
            Date parsedDate = inputFormat.parse(this.publishedAt);
            return String.valueOf(parsedDate.getTime());
        }

    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
            "id",
            "name"
    })
    public static class Source {

        @JsonProperty("id")
        private Object id;
        @JsonProperty("name")
        private String name;

        public Source() {
        }

        public Source(Object id, String name) {
            super();
            this.id = id;
            this.name = name;
        }

        @JsonProperty("id")
        public Object getId() {
            return id;
        }

        @JsonProperty("id")
        public void setId(Object id) {
            this.id = id;
        }

        @JsonProperty("name")
        public String getName() {
            return name;
        }

        @JsonProperty("name")
        public void setName(String name) {
            this.name = name;
        }

    }
}