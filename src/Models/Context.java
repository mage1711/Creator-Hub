package Models;

import org.bson.types.ObjectId;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

public class Context implements Serializable {
    private FileConverter converter;

    public Context() {
    }

    public Context(FileConverter converter) {
        if(converter != null)
        this.converter = converter;
    }

    public PostContent convertFile(File file) throws IOException {
        return converter.convertFile(file);
    }

    public File GetFile(ObjectId id) throws IOException {
        return converter.GetFile(id);
    }

}
