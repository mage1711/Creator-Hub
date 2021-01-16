package Models;

import java.io.Serializable;

public class VideoPost extends Post implements Serializable {
    private Object content;
    private Object context;
    private Post post;
    public VideoPost() {
        super();
    }

    public VideoPost(Post post, Object context) {
        this.context = context;
        this.post = post;
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

    public void setPost(Post post) {
        this.post = post;
    }

    public Post getPostItem() {
        return this.post;
    }


}
