package Controllers;

import Models.Creator;
import Models.ImagePost;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.rmi.RemoteException;
import java.util.Date;

class PostsControllerTest {
    Database db;
    PostsController postsController = new PostsController();

    @BeforeEach
    void setUp() {
    }

    public PostsControllerTest() throws RemoteException {
       db = Database.getCurrentDatabase();
    }


    @Test
    void main() {
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