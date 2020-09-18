package com.bbu.handle;



import com.bbu.exception.ResultExecption;
import com.bbu.util.Result;
import com.bbu.util.ResultEnum;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ResultExeceptionAdvice {
        @ExceptionHandler(value = Exception.class)
        @ResponseBody
        public Result ResultExeceptionAdvice(Exception e){
        ResultExecption resultExecption = null;
        if (e instanceof ResultExecption){
            resultExecption = (ResultExecption)e;
            return Result.build(resultExecption);
        }else {
            return Result.build(new ResultExecption(ResultEnum.UNKNOWN_EXCEPTION));
        }
    }



}
