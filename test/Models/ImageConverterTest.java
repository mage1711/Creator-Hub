package Models;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

class ImageConverterTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void convertFile() throws IOException {
        File image = ImageConverter.GetImage();
        Assertions.assertNotNull(image);
        System.out.println(ImageConverter.ConvertImage(image));
    }

    @Test
    void convertImage() {
    }

    @Test
    void GetImageAsFile() throws IOException {
        File image = ImageConverter.GetImage();
        Assertions.assertNotNull(image);
        ObjectId id = ImageConverter.ConvertImage(image);
        System.out.println(id);
        File result = ImageConverter.GetImageAsFile(id);
        Assertions.assertNotNull(result);
        System.out.println(result.getName());
    }
}