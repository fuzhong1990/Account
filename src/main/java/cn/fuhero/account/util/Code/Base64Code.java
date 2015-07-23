package cn.fuhero.account.util.Code;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;

/**
 * Created by Fu Zhong on 2015/7/11.
 */
public class Base64Code {

    private static final Logger logger = LoggerFactory.getLogger(Base64Code.class);

    /**
     * base64加密 生成base64码
     * @param str 要加密的字符串
     * @return 加密后的编码
     */
    public static String encode (String str) {
        byte [] bytes = null;
        try {
            bytes = str.getBytes("UTF-8");
            if (bytes != null) {
                str = new BASE64Encoder().encode(bytes);
            }
        } catch (Exception e) {
            logger.error("Base64加密异常:{}", str);
            logger.error("异常代码:{}", e.getClass().getName());
            logger.error("异常信息:{}", e.getMessage());
            e.printStackTrace();
        }
        return str;
    }

    /**
     * base64解密 生成加密前的字符串
     * @param str 要解密的字符串
     * @return 加密前的字符串
     */
    public static String decode (String str) {
        byte [] bytes = null;
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            if (str != null) {
                bytes = decoder.decodeBuffer(str);
                str = new String(bytes, "UTF-8");
            }
        } catch (IOException e) {
            logger.error("Base64解密异常:{}", str);
            logger.error("异常代码:{}", e.getClass().getName());
            logger.error("异常信息:{}", e.getMessage());
            e.printStackTrace();
        }
        return str;
    }

}
