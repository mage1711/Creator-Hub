package Models;

public class ImagePost extends PostDecorator {
    private Object content;
    private Object context;

    public ImagePost() {
    }

    public ImagePost(Object content, Object context) {
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

    @Override
    public Post getPost() {
        return null;
    }

    public String getAltText() {
        return "";
    }
}
