package cn.fuhero.account.util.Code;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.security.MessageDigest;

/**
 * Created by Fu Zhong on 2015/7/11.
 */
public class MD5Code {

    private static final Logger logger = LoggerFactory.getLogger(MD5Code.class);

    /**
     * MD5加密 生成32位小写的MD5码
     * @param str 要加密的字符串
     * @return 返回32位的MD5码
     */
    public static String encode32LowerCase (String str)  {
        MessageDigest disgest = null;
        StringBuilder hexValue = new StringBuilder();
        try {
            disgest = MessageDigest.getInstance("MD5");
            byte [] bytes = str.getBytes("UTF-8");
            byte [] md5Byte = disgest.digest(bytes);
            for (int i=0; i<md5Byte.length; i++) {
                int val = ((int) md5Byte[i]) & 0xff;
                if (val < 16) {
                    hexValue.append("0");
                }
                hexValue.append(Integer.toHexString(val));
            }
        } catch (Exception e) {
            logger.error("MD5加密异常:{}", str);
            logger.error("异常代码:{}", e.getClass().getName());
            logger.error("异常信息:{}", e.getMessage());
            e.printStackTrace();
        }
        return  hexValue.toString().toLowerCase();
    }

    /**
     * MD5加密 生成32位大写的MD5码
     * @param str 要加密的字符串
     * @return 返回32位的MD5码
     */
    public static String encode32UpperCase (String str) {
        str = encode32LowerCase(str);
        return str.toUpperCase();
    }

}
