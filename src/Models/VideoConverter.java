package Models;

import Controllers.Database;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;
import com.mongodb.client.gridfs.model.GridFSUploadOptions;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.io.*;

public class VideoConverter implements FileConverter {
    @Override
    public PostContent convertFile(File file) {
        return null;
    }

    @Override
    public File GetFile(ObjectId id) throws IOException {
        return null;
    }

    public static ObjectId ConvertVideo() throws IOException {
        Database db = Database.getCurrentDatabase();
        GridFSBucket gridBucket = GridFSBuckets.create(db.getDatabase(), "Video");
        GridFSUploadOptions uploadOptions = new GridFSUploadOptions().chunkSizeBytes(5120).metadata(new Document("type", "video").append("content_type", "video/mp4"));
        InputStream inStream = GetVideo();
        return gridBucket.uploadFromStream("Upload.png", inStream, uploadOptions);

    }
    public static InputStream GetVideo() throws FileNotFoundException {
        String filePath = "C:\\Users\\ziada\\Videos\\database\\file.mp4";
        InputStream inStream = new FileInputStream(new File(filePath));
        return inStream;
    }
}
