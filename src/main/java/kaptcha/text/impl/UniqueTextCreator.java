package kaptcha.text.impl;

import com.google.common.collect.Sets;
import kaptcha.text.TextProducer;
import kaptcha.util.Configurable;

import java.util.Random;
import java.util.Set;

/**
 * Created by xiang.xu on 2015/2/25.
 */
public class UniqueTextCreator extends Configurable implements TextProducer {
    @Override
    public String getText() {
        int length = getConfig().getTextProducerCharLength();
        char[] chars = getConfig().getTextProducerCharString();
        Random random = new Random();
        Set<Character> word = Sets.newTreeSet();
        while (word.size() < length) {
            word.add(chars[random.nextInt(chars.length)]);
        }
        StringBuffer buffer = new StringBuffer();
        for (Character character : word) {
            buffer.append(character);
        }
        return buffer.toString();
    }
}
