package cn.fuhero.account.model;

import cn.fuhero.account.util.ConfigUtil;

/**
 * Created by Fu Zhong on 2015/7/5.
 */
public class Result {
    public static final String STATE_FAIL = "0";
    public static final String STATE_SUCCESS = "1";
    public static final String STATE_ERROR = "2";

    private String state;
    private Object data;
    private String message;

    public Result (String state, Object data) {
        this.state = state;
        this.data = data;
        this.message = ConfigUtil.getConfigValue(state);
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static boolean isSuccess (Result result) {
        if (result.getState().equals(Result.STATE_SUCCESS)) {
            return true;
        }
        return false;
    }

    public static Result setSuccessResultData (Object data) {
        return new Result(Result.STATE_SUCCESS, data);
    }

    public static Result getErrorResult () {
        return new Result(Result.STATE_ERROR, "");
    }

}
