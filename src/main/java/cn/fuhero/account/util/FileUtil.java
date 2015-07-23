package cn.fuhero.account.util;

import cn.fuhero.account.util.Code.UrlCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Fu Zhong on 2015/7/5.
 */
public class FileUtil {

    private static final Logger logger = LoggerFactory.getLogger(FileUtil.class);

    /**
     * 获取项目的绝对路径
     *
     * @return String 项目的绝对路径
     */
    public static String getPath () {
        String path = Thread.currentThread().getContextClassLoader().getResource("").toString();
        path = path.replaceAll("%20", " ");
        String os = System.getProperty("os.name");
        String regex = ".*?[wW]indows.*?";
        if (os != null && os.matches(regex)) {
//            return path.substring(6);
            return  Pattern.compile("file:/").split(path)[1];
        }
        return path;
    }

    /**
     * 获取项目饿web文件的绝对路径
     *
     * @return String 项目的Web绝对路径
     */
    public static String getWebPath () {
        return getPath().split("classes/")[0];
    }

    /**
     * 根据文件加载Properties信息
     *
     * @param filePath properties绝对路径文件的名称
     * @return Properties 把properties文件的信息加载成Properties对象
     */
    public static Properties readPropertiesFile (String filePath) {
        Properties properties = new Properties();
        FileInputStream fis = null;
        try {
            try {
                fis = new FileInputStream(filePath);
                properties.load(fis);
            }
            catch (IOException e) {
                logger.error("读取文件异常,文件路径:{}", filePath);
                logger.error("异常代码:{}", e.getClass().getName());
                logger.error("异常信息:{}", e.getMessage());
                e.printStackTrace();
            }
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    logger.error("关闭文件流错误,文件路径:{}", filePath);
                    logger.error("异常代码:{}", e.getClass().getName());
                    logger.error("异常信息:{}", e.getMessage());
                    e.printStackTrace();
                }
            }
        }
        return properties;
    }
}
