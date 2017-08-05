package com.veadan.config.exception;

import com.veadan.config.resultFormat.JsonResult;
import com.veadan.config.resultFormat.EnumCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Veadan on 2017/5/1.
 */
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public JsonResult handle(Exception e) {
        if (e instanceof PdaException) {
            PdaException pdaException = (PdaException) e;
            return new JsonResult(EnumCode.EXCEPTION, pdaException.getMessage(),null);


        } else {
            return new JsonResult(EnumCode.UNKNOWN_ERROR,"未知错误",null);
  }
    }
}
