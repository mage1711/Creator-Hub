package Models;

public class PostContent {
    private String name;
    private String size;
    private String metadata;

    public PostContent() {
    }

    public PostContent(String name, String size, String metadata) {
        this.name = name;
        this.size = size;
        this.metadata = metadata;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getMetadata() {
        return metadata;
    }

    public void setMetadata(String metadata) {
        this.metadata = metadata;
    }
}
