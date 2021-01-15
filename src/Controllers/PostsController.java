package Controllers;

import Models.Post;
import Models.User;
import Models.ViewerState;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

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

    public static void main(String[] args) throws IOException {
//        Database db = Database.getCurrentDatabase();
//        Gson gson = new Gson();
//        db.DatabaseConnection();
//
//        User user = new User("name","country","email");
//        ImagePost post = new ImagePost(ImageConverter.GetVideo());
//        db.insertObject("Posts",post);
//        post.setLikes(new ArrayList<User>());
//        post.likePost(user);
//        post.unlikePost(user);
//        db.updateObject("Posts",post,"post.id",post.getId());
//       ImagePost post2 = new ImagePost(ImageConverter.GetVideo());
//        db.insertObject("Posts",post2);
//        post2.setLikes(new ArrayList<User>());
//        post2.likePost(new User("name","country","email"));
//        post2.setSubscriberOnly(true);
//        db.updateObject("Posts",post2,"post.id",post.getId());
//        System.out.println(post.GetVideo().getName());
//        System.out.println(post.getId());
    }


}
