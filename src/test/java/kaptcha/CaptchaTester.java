package kaptcha;

import kaptcha.util.Config;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Properties;

/**
 * Created by xiang.xu on 2015/2/16.
 */
public class CaptchaTester {
    @Test
    public void test() throws IOException, URISyntaxException {
        Properties properties = new Properties();
        properties.put("kaptcha.textproducer.char.string", "就看规则要不商量个字典规则出来");
        properties.put("kaptcha.textproducer.char.length", "3");
        properties.put("kaptcha.textproducer.font.names", "宋体,微软雅黑,楷体,仿宋");
        properties.put("kaptcha.textproducer.font.size", "80");
        properties.put("kaptcha.textproducer.char.space", "20");
        properties.put("kaptcha.image.width", "400");
        properties.put("kaptcha.image.height", "200");
        Config config = new Config(properties);
        Producer producer = config.getProducerImpl();
        String capText = producer.createText();
        BufferedImage bufferedImage = producer.createImage(capText);
        File parent = new File(this.getClass().getResource("").toURI());
        File file = new File(parent, "kaptcha.jpg");
        FileOutputStream out = new FileOutputStream(file);
        ImageIO.write(bufferedImage, "jpg", out);

    }
}
