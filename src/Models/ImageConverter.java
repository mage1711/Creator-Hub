package Models;

import Controllers.Database;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;
import com.mongodb.client.gridfs.model.GridFSFile;
import com.mongodb.client.gridfs.model.GridFSUploadOptions;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;

import static com.mongodb.client.model.Filters.eq;

public class ImageConverter implements FileConverter {
    @Override
    public PostContent convertFile(File file) throws IOException {
        ObjectId contentId = null;
        contentId = ConvertImage(file);
        PostContent postContent= new PostContent(contentId,GetSize(file),GenerateMetadata(file));
        return postContent;
    }

    @Override
    public File GetFile(ObjectId id) throws IOException {
        return GetImageAsFile(id);
    }

    public static ObjectId ConvertImage(File file) throws IOException {
        Database db = new Database();
        GridFSBucket gridBucket = GridFSBuckets.create(db.getDatabase(), "Photo");
        GridFSUploadOptions uploadOptions = new GridFSUploadOptions().chunkSizeBytes(2048).metadata(GenerateMetadata(file));
        InputStream inStream = new FileInputStream(file);
        return gridBucket.uploadFromStream("U-"+file.getName(), inStream, uploadOptions);
    }

    public static File GetImage() throws IOException {
        String filePath = "C:\\Users\\ziada\\OneDrive\\Pictures\\Screenshots\\file.png";
        File file = new File(filePath);
        System.out.println(file.getName());
        String fileName = file.getName();
        return file;
    }
public static String GetFileExtension(File file){
    String fileName = file.getName();
    String extension ="";
    int i = fileName.lastIndexOf('.');
    if (i >= 0) { extension = fileName.substring(i+1); }
    System.out.println(extension);
    return extension;
}
public  static long GetSize(File file) throws IOException {
    BasicFileAttributes attr = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
    return attr.size();
}
public static Document GenerateMetadata(File file) throws IOException {
    Document metadata =new Document("type", "image").append("content_type", "image/"+GetFileExtension(file)).append("size",GetSize(file));
    return metadata;
}
public static File GetImageAsFile(ObjectId id) throws IOException {
    Database db = new Database();
    GridFSBucket gridBucket = GridFSBuckets.create(db.getDatabase(), "Photo");
    GridFSFile gridFSFile = gridBucket.find(eq("_id",id)).first();
    System.out.println("File Name:- " + gridFSFile.getFilename());
    FileOutputStream fileOutputStream = new FileOutputStream(gridFSFile.getFilename());
    gridBucket.downloadToStream(id, fileOutputStream);
    fileOutputStream.close();
    File result = new File(gridFSFile.getFilename());
    return result;
}
}

