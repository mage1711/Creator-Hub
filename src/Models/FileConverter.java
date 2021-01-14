package Models;

import java.io.File;
import java.io.IOException;

public interface FileConverter {
    PostContent convertFile(File file) throws IOException;
}
