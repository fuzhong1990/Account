package cn.fuhero.account.util;

/**
 * Created by Fu Zhong on 2015/7/7.
 */
public class StringUtil {

    public static final String EMAIL_REGEX = "^(\\w+((-\\w+)|(\\.\\w+))*)\\+\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$";
    public static final String BRITH_REGEX = "\\\\d{4}-\\\\d{2}-\\\\d{2}";
    public static final String phone_regex = "^((13[0-9])|(15[^4,\\\\D])|(18[0,5-9]))\\\\d{8}$";


}
