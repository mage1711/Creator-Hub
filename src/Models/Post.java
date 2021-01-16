package Models;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class Post implements Serializable {
    private String id;
    private ArrayList<User> likes;
    private Date date;
    private String text;
    private String type;
    private boolean subscriberOnly;
    private Creator poster;

    public Post() {
        byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);
        String generatedString = new String(array, Charset.forName("UTF-8"));
        this.id = generatedString;
    }

    public Post( Date date, String text, boolean subscriberOnly, Creator poster, String type) {
        byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);
        String generatedString = new String(array, Charset.forName("UTF-8"));
        this.id = generatedString;
        this.date = date;
        this.text = text;
        this.subscriberOnly = subscriberOnly;
        this.poster = poster;
        this.type = type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void likePost(User user) {
        this.likes.add(user);
    }

    public void unlikePost(User user) {
        User delete = new User();
        for (User u: this.likes
             ) {
            if(u.getId() == user.getId()){
                delete = u;
            }
        }
        this.likes.remove(delete);
    }

    public void deletePost() {}

}
