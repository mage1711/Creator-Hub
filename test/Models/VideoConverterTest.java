package Models;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class VideoConverterTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void convertFile() {
    }

    @Test
    void convertVideo() throws IOException {
        InputStream content = VideoConverter.GetVideo();
        Assert.assertNotNull(content);
        System.out.println(VideoConverter.ConvertVideo());
    }
    @Test
    void getVideo() {
    }
}