package Models;

public class VideoPost extends PostDecorator {
    private Object content;
    private Object context;

    public VideoPost() {
    }

    public VideoPost(Object content, Object context) {
        this.content = content;
        this.context = context;
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

    public Object getThumbnail() {
        return null;
    }

    @Override
    public Post getPost() {
        return null;
    }
}
