package Models;

import java.io.File;
import java.io.IOException;

public class ImagePost extends Post {
    private PostContent content;
    private Context context;

    public ImagePost() {
        super();
    }

    public ImagePost(File file) throws IOException {
        super();
        context = new Context(new ImageConverter());
        this.content = context.convertFile(file);
    }
    public File GetImage() throws IOException {
        return context.GetFile(content.getContentId());
    }

    public Object getContent() {
        return content;
    }

    public void setContent(PostContent content) {
        this.content = content;
    }

    public Object getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }


}
