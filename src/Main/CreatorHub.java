package Main;

import Controllers.Database;
import Models.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import com.google.gson.Gson;

public class CreatorHub {
    public static void main(String[] args) {
        Database db = new Database();
         Gson gson = new Gson();
        db.DatabaseConnection();
        User user = new User("name","country","email");
        ImagePost post = new ImagePost(new Post(),new Context());
        db.insertObject("Posts",post);
        post.setLikes(new ArrayList<User>());
        post.likePost(user);
        post.unlikePost(user);
        db.updateObject("Posts",post,"post.id",post.getPostItem().getId());
        /*ImagePost post = new ImagePost(new Post(),new PostContent("name","size","metadata"),new Context());
        db.insertObject("Posts",post);
        post.setLikes(new ArrayList<User>());
        post.likePost(new User("name","country","email"));
        post.setSubscriberOnly(true);
        db.updateObject("Posts",post,"post.id",post.getPostItem().getId());
        System.out.println(post.getPostItem().getId());*/
    }
}
