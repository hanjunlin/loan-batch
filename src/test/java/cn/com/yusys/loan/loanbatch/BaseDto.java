package cn.com.yusys.loan.loanbatch;

/**
 * @author ：hanjl
 * @date ：Created in 2021/11/12 0012 15:05
 * @description：
 */
public class BaseDto <T extends Object>{

    private String key;

    private T data;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
