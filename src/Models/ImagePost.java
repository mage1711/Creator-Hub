package Models;

public class ImagePost extends PostDecorator {
    private Object content;
    private Object context;
    private Post post;
    public ImagePost() {
    }

    public ImagePost(Post post, Object context) {
        this.context = context;
        this.post = post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Post getPostItem() {
        return this.post;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public Object getContext() {
        return context;
    }

    public void setContext(Object context) {
        this.context = context;
    }

    @Override
    public Post getPost() {
        return this;
    }

    public String getAltText() {
        return "";
    }
}
