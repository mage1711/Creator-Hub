package Models;

import java.util.ArrayList;
import java.util.Date;

public class Post {
    private String id;
    private ArrayList<User> likes;
    private Date date;
    private String text;
    private boolean subscriberOnly;
    private Creator poster;

    public Post() {
    }

    public Post(String id, ArrayList<User> likes, Date date, String text, boolean subscriberOnly, Creator poster) {
        this.id = id;
        this.likes = likes;
        this.date = date;
        this.text = text;
        this.subscriberOnly = subscriberOnly;
        this.poster = poster;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<User> getLikes() {
        return likes;
    }

    public void setLikes(ArrayList<User> likes) {
        this.likes = likes;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isSubscriberOnly() {
        return subscriberOnly;
    }

    public void setSubscriberOnly(boolean subscriberOnly) {
        this.subscriberOnly = subscriberOnly;
    }

    public Creator getPoster() {
        return poster;
    }

    public void setPoster(Creator poster) {
        this.poster = poster;
    }

    public void likePost(User user) {}

    public void unlikePost(User user) {}

    public void deletePost() {}
}
