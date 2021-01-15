package Models;

import org.bson.types.ObjectId;

import java.io.File;
import java.io.IOException;

public interface FileConverter {
    PostContent convertFile(File file) throws IOException;
    File GetFile(ObjectId id) throws IOException;
}
