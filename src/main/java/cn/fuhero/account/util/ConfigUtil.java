package cn.fuhero.account.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

/**
 * Created by Fu Zhong on 2015/7/5.
 */
public class ConfigUtil {

    private static final Logger logger = LoggerFactory.getLogger(ConfigUtil.class);

    /**
     * 读取message.properties文件中对应的key的值
     *
     * @param key
     * @return value
     */
    public static String getConfigValue (String key) {
        String filename = FileUtil.getPath() + "message.properties";
        Properties properties = FileUtil.readPropertiesFile(filename);
        String value = properties.getProperty(key);
        try {
            value = new String(value.getBytes("ISO8859-1"), "UTF-8");
        }
        catch (UnsupportedEncodingException e) {
            logger.error("转码异常:{}", value);
            logger.error("异常代码:{}", e.getClass().getName());
            logger.error("异常信息:{}", e.getMessage());
            e.printStackTrace();
        }
        return value;
    }

}
