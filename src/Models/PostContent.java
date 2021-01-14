package Models;

import org.bson.Document;

public class PostContent {
    private String contentId;
    private long size;
    private Document metadata;

    public PostContent() {
    }

    public PostContent(String contentId, long size, Document metadata) {
        this.contentId = contentId;
        this.size = size;
        this.metadata = metadata;
    }

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
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
