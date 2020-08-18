package cool.lytton.doc.model.base;

import java.util.List;

// 默认http返回的基础模型
public class BaseResponse<T> {
    private int code = 0;
    private String msg = "success";
    private List<T> result;

    public BaseResponse() {
        this.code = 0;
        this.msg = "success";
        this.result = null;
    }

    public BaseResponse(int code, String msg, List<T> result) {
        this.code = code;
        this.msg = msg;
        this.result = result;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }
}
