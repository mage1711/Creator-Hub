package Controllers;

import Models.*;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class PostsController extends UnicastRemoteObject implements IPostsController {
    public PostsController() throws RemoteException {
    }

    @Override
    public ArrayList<Post> getPosts(User user) {
        // TODO: Update to get each user feed
        Database db = Database.getCurrentDatabase();
        ArrayList<Post> posts = new ArrayList<>();
        if (user.getClass() == User.class) {
            ArrayList<Object> postsDocs = db.getAllDocuments("Posts", ImagePost.class);
            for (Object postDoc : postsDocs) {
                posts.add((ImagePost) postDoc);
            }
            System.out.println(posts.get(0).getId());
            return posts;
        }
        else if(user.getClass() == ViewerState.class){
            ArrayList<Creator> subscribed = ((ViewerState) user).getSubscribed();
            for (Creator creator :subscribed) {
                ArrayList<Object> postsDocs = db.getAllDocuments("Posts", ImagePost.class, "poster.id", creator.getId());
                for (Object postDoc : postsDocs) {
                    posts.add((ImagePost) postDoc);
                }
            }
            System.out.println(posts.get(0).getId());
            return posts;
        }



        return null;
    }
    @Override
    public void CreatePost(Creator user,Post post){
        if (user.getClass() == Creator.class){
            Database db = Database.getCurrentDatabase();
            if (ImagePost.class.equals(post.getClass())) {
                ImagePost imagePost = (ImagePost) post;
                imagePost.setContext(new Context());
                db.insertObject("Posts", imagePost);
            } else if (VideoPost.class.equals(post.getClass())) {
                VideoPost videoPost = (VideoPost) post;
                videoPost.setContext(new Context());
                db.insertObject("Posts", videoPost);
            }
            else {
                db.insertObject("Posts", post);
            }

        }

    }

    @Override
    public Post GetPost(User user) throws RemoteException {
        Database db = Database.getCurrentDatabase();
//        ArrayList<Post> posts = getPosts(user);
        ArrayList<Object> posts = db.getAllDocuments("Posts",Post.class);
        return (Post) posts.get(0);
    }

}
