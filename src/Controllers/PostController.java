package Controllers;

import Models.*;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;

public class PostController {
    public static void main(String[] args) throws IOException {
        Database db = new Database();
        Gson gson = new Gson();
        db.DatabaseConnection();

        User user = new User("name","country","email");
        ImagePost post = new ImagePost(ImageConverter.GetImage());
        db.insertObject("Posts",post);
        post.setLikes(new ArrayList<User>());
        post.likePost(user);
        post.unlikePost(user);
        db.updateObject("Posts",post,"post.id",post.getId());
       ImagePost post2 = new ImagePost(ImageConverter.GetImage());
        db.insertObject("Posts",post2);
        post2.setLikes(new ArrayList<User>());
        post2.likePost(new User("name","country","email"));
        post2.setSubscriberOnly(true);
        db.updateObject("Posts",post2,"post.id",post.getId());
        System.out.println(post.GetImage().getName());
        System.out.println(post.getId());
    }
}
