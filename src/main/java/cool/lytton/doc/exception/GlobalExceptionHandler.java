package cool.lytton.doc.exception;

import cool.lytton.doc.exception.exceptions.TokenException;
import cool.lytton.doc.model.base.BaseResponse;
import cool.lytton.doc.model.base.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // 参数缺失异常
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseBody
    public ErrorResponse handleMissParamException(MissingServletRequestParameterException e) {
        ErrorResponse res = new ErrorResponse("400", "缺少参数");
        return res;
    }

    @ResponseBody
    @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(TokenException.class)
    public Object handleTokenException(Exception e) {
        String msg = e.getMessage();
        if(msg == null || msg.equals("")) {
            msg = "token异常";
        }
        ErrorResponse res = new ErrorResponse("401", msg);
        return res;
    }

    @ResponseBody
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public Object handleException(Exception e) {
        String msg = e.getMessage();
        if(msg == null || msg.equals("")) {
            msg = "服务器异常";
        }
        ErrorResponse res = new ErrorResponse("500", msg);
        return res;
    }
}
