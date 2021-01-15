package Models;

public abstract class PostDecorator extends Post {
    //protected Post post;

    public PostDecorator(Post post) {

    }

    public PostDecorator() {

    }


    public abstract Post getPost();
}
