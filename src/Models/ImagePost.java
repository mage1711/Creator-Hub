package Models;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;

public class ImagePost extends Post implements Serializable {
    private PostContent content;
    private Context context;

    public ImagePost() {
        super();
    }

    public ImagePost( Date date, String text, boolean subscriberOnly, Creator poster, String type) {
        super(date,  text,  subscriberOnly, poster, type);
    }

    public ImagePost( Date date, String text, boolean subscriberOnly, Creator poster, String type,File file) throws IOException {
        super(date,  text,  subscriberOnly, poster, type);
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
