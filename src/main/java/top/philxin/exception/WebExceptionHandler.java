package top.philxin.exception;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import top.philxin.bean.DataVo;

@ControllerAdvice
@ResponseBody
public class WebExceptionHandler {
    Logger logger = Logger.getLogger(this.getClass());

    @ExceptionHandler
    public DataVo unknownAccount(UnknownAccountException e) {
        logger.error("账户不存在",e);
        return DataVo.error(-1,"该账户不存在");
    }

    @ExceptionHandler
    public DataVo unknownException(Exception e) {
        logger.error("发生了未知错误",e);
        return DataVo.error(-99, "未知错误，请联系系统管理员");
    }
}
