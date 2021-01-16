package Models;

import java.util.Date;

public abstract class PostDecorator extends Post {
    public PostDecorator(Date date, String text, boolean subscriberOnly, Creator poster, String type) {
        super(date, text, subscriberOnly, poster, type);
    }

    public PostDecorator() {
        super();
    }
    protected Post post;

//    public PostDecorator(Post post) {
//
//    }
//
//    public PostDecorator() {
//
//    }


    public abstract Post getPost();
}
