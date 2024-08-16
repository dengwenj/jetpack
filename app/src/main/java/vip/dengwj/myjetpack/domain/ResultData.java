package vip.dengwj.myjetpack.domain;

public class ResultData<T> {
    private boolean success;
    private int code;
    private String msg;
    private T data;


    public ResultData() {
    }

    public ResultData(boolean success, int code, String msg, T data) {
        this.success = success;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 获取
     * @return success
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     * 设置
     * @param success
     */
    public void setSuccess(boolean success) {
        this.success = success;
    }

    /**
     * 获取
     * @return code
     */
    public int getCode() {
        return code;
    }

    /**
     * 设置
     * @param code
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * 获取
     * @return msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * 设置
     * @param msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * 获取
     * @return data
     */
    public T getData() {
        return data;
    }

    /**
     * 设置
     * @param data
     */
    public void setData(T data) {
        this.data = data;
    }

    public String toString() {
        return "ResultData{success = " + success + ", code = " + code + ", msg = " + msg + ", data = " + data + "}";
    }

    public static <V> ResultData<V> success(V data) {
        return new ResultData<V>(true, 10000, "success", data);
    }
}
