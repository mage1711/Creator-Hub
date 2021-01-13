package Models;

import java.util.ArrayList;

public class Feed {
    private ArrayList<Post> posts;
    private User user;

    public Feed() {
    }

    public Feed(ArrayList<Post> posts, User user) {
        this.posts = posts;
        this.user = user;
    }

    public ArrayList<Post> getPosts() {
        return posts;
    }

    public void setPosts(ArrayList<Post> posts) {
        this.posts = posts;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArrayList<Post> generateFeed(User user) {
        return null;
    }
}
