package Controllers;

import Models.*;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;

public class PostsController extends UnicastRemoteObject implements IPostsController {
    public PostsController() throws RemoteException {
    }

    @Override
    public ArrayList<Post> getPosts(User user) {
        // TODO: Update to get each user feed
        if (user.getClass() == ViewerState.class || user.getClass() == User.class) {
            Database database = Database.getCurrentDatabase();
            ArrayList<Post> posts = new ArrayList<>();
            ArrayList<Object> postsDocs = database.getAllDocuments("Posts", Post.class);
            for (Object postDoc : postsDocs) {
                posts.add((Post) postDoc);
            }
            System.out.println(posts.get(0).getId());
            return posts;
        }
        return null;
    }

    @Override
    public ArrayList<Object> generateFeed(User user) {

        return null;
    }

    public static void main(String[] args) throws IOException {
        Database db = Database.getCurrentDatabase();
        Creator user = new Creator("test","egypt","test@test.com");
        ImagePost post= new ImagePost(new Date(),"test",false,user,"normal");
        post.setContext(new Context());
        db.insertObject("Posts",post);
      System.out.println(db.getDocument("Posts","text",post.getText(),ImagePost.class));
        ImagePost result = (ImagePost) db.getDocument("Posts","text",post.getText(),ImagePost.class);
       System.out.println(result.getType());
//         ImagePost result2 = (ImagePost) db.getDocument("Posts","text",post.getText(),ImagePost.class);
//         System.out.println(result.getType());

    }
}
