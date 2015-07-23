package cn.fuhero.account.util.Code;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * Created by Fu Zhong on 2015/7/5.
 */
public class UrlCode {

    private static final Logger logger = LoggerFactory.getLogger(UrlCode.class);

    /**
     * 对字符串进制 decode
     *
     * @param url 需要转码的字符串
     * @return 转码后的结果
     */
    public static String decodeUrl (String url) {
        try {
            url  = URLDecoder.decode(url, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            logger.error("转码异常:{}", url);
            logger.error("异常代码:{}", e.getClass().getName());
            logger.error("异常信息:{}", e.getMessage());
            e.printStackTrace();
        }
        return url;
    }
}
