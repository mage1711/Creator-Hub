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
        Database db = Database.getCurrentDatabase();
        ArrayList<Post> posts = new ArrayList<>();
        if (user.getClass() == User.class) {
            ArrayList<Object> postsDocs = db.getAllDocuments("Posts", Post.class);
            for (Object postDoc : postsDocs) {
                posts.add((Post) postDoc);
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

    public void CreatePost(User user,Post post){
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

//    @Override
//    public ArrayList<Object> generateFeed(User user) {
//
//        return null;
//    }

    public static void main(String[] args) throws IOException {
        Database db = Database.getCurrentDatabase();
        Creator user = new Creator("test","egypt","test@test.com");
        ImagePost post= new ImagePost(new Date(),"test",false,user,"normal");
        post.setContext(new Context());
        db.insertObject("Posts",post);
      System.out.println(db.getDocument("Posts","text",post.getText(),ImagePost.class));
        ImagePost result = (ImagePost) db.getDocument("Posts","poster.id",user.getId(),ImagePost.class);
        result.setContext(new Context(new ImageConverter()));
       System.out.println(result.getType());
//        ArrayList<Object> postsDocs = db.getAllDocuments("Posts", Post.class,"poster.id");
//         ImagePost result2 = (ImagePost) db.getDocument("Posts","text",post.getText(),ImagePost.class);
//         System.out.println(result.getType());


    }
}
