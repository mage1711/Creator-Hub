package Models;

import org.bson.Document;
import org.bson.types.ObjectId;

public class PostContent {
    private ObjectId contentId;
    private long size;
    private Document metadata;

    public PostContent() {
    }

    public PostContent(ObjectId contentId, long size, Document metadata) {
        this.contentId = contentId;
        this.size = size;
        this.metadata = metadata;
    }

    public ObjectId getContentId() {
        return contentId;
    }

    public void setContentId(ObjectId  contentId) {
        this.contentId = contentId;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public Document getMetadata() {
        return metadata;
    }

    public void setMetadata(Document metadata) {
        this.metadata = metadata;
    }
}
