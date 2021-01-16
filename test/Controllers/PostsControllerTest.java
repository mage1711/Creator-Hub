package Controllers;

import Models.Creator;
import Models.ImagePost;
import Models.Post;
import Models.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

class PostsControllerTest {
    Database db;
    PostsController postsController = new PostsController();
    ArrayList<Object> users;
    User user;

    @BeforeEach
    void setUp() {
        user = (User) users.get(0);
    }

    public PostsControllerTest() throws RemoteException {
       db = Database.getCurrentDatabase();
       users = db.getAllDocuments("Users",User.class);
    }

    @Test
    void GetAllPost() {
        ArrayList<Post> posts = postsController.getPosts(user);
        Assertions.assertNotNull(posts);
        System.out.println("======================="+posts.get(0).getId()+"======================");
        System.out.println(posts);
    }

    @Test
    void CreatePost() {
        Creator creator = new Creator("test","egypt","test@test.com");
        ImagePost post= new ImagePost(new Date(),"test",false,creator,"normal");
        postsController.CreatePost(creator,post);
        Object result = db.getDocument("Posts", "poster.id", creator.getId(), ImagePost.class);
        Assertions.assertNotNull(result);
        post = (ImagePost) result;
        db.deleteObject("Posts",null,"id", post.getId());
        result = db.getDocument("Posts", "poster.id", creator.getId(), ImagePost.class);
        Assertions.assertNull(result);
    }
}