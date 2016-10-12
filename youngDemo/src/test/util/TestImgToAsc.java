package test.util;

import com.util.imgtoascUtil.AsciiImageConverter;
import com.util.imgtoascUtil.AsciiImgCache;
import org.junit.Test;

import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.imageio.ImageIO;

public class TestImgToAsc{
    @Test
    public void test() throws IOException {
        File inputFile = new File("D:/a.jpg");
        BufferedImage input = ImageIO.read(inputFile);
        Font font = new Font("Courier", Font.PLAIN, 3);

        AsciiImgCache cache = AsciiImgCache.create(font);
        AsciiImageConverter imgConverter = new AsciiImageConverter(cache);
        BufferedImage output = imgConverter.convertImage(input);
        File outputfile = new File("D:/output.png");
        ImageIO.write(output, "png", outputfile);
    }
}
