package cn.tedu.csmall.common.ex.handler;

import cn.tedu.csmall.common.ex.ServiceException;
import cn.tedu.csmall.common.web.JsonResult;
import cn.tedu.csmall.common.web.State;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ServiceException.class)
    public JsonResult<Void> handleServiceException(ServiceException ex) {
        return JsonResult.fail(ex.getState(), ex.getMessage());
    }

    @ExceptionHandler(BindException.class)
    public JsonResult<Void> handleBindException(BindException ex) {
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        StringBuffer stringBuffer = new StringBuffer();
        for (FieldError fieldError : fieldErrors) {
            stringBuffer.append("; ");
            stringBuffer.append((fieldError.getDefaultMessage()));
        }
        String message = stringBuffer.substring(1);
        return JsonResult.fail(State.ERR_BAD_REQUEST,message);
    }
}
