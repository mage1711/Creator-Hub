package Models;

import java.io.File;

public class Context {
    private FileConverter converter;

    public Context() {
    }

    public Context(FileConverter converter) {
        this.converter = converter;
    }

    public Object getConverter() {
        return converter;
    }

    public void setConverter(FileConverter converter) {
        this.converter = converter;
    }

    public Object convertFile(File file) {
        return null;
    }
}
