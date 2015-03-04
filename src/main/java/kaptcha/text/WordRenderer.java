package kaptcha.text;

import java.awt.image.BufferedImage;

/**
 * {@link kaptcha.text.WordRenderer} is responsible for rendering words.
 */
public interface WordRenderer {
    public BufferedImage renderWord(String word, int width, int height);
}
