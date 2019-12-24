package top.philxin.bean;

import lombok.Data;

@Data
public class DataVo<T> {
    private T data;
    private String message;
    private int errorNo;

    public static DataVo error(int errorNo, String message) {
        DataVo dataVo = new DataVo();
        dataVo.setMessage(message);
        dataVo.setErrorNo(errorNo);
        return dataVo;
    }

    public static DataVo success() {
        DataVo dataVo = new DataVo();
        dataVo.setErrorNo(0);
        dataVo.setMessage("success");
        return dataVo;
    }

    public static <V> DataVo<V> success(V data) {
        DataVo<V> dataVo = new DataVo<>();
        dataVo.setErrorNo(0);
        dataVo.setMessage("success");
        dataVo.setData(data);
        return dataVo;
    }
}
