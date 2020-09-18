package com.bbu.exception;
import com.bbu.util.ResultEnum;

public class ResultExecption extends RuntimeException {
    private ResultEnum resultEnum;
    private Integer code;
    private String message;

    public ResultExecption(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


    public ResultExecption(ResultEnum resultEnum) {
        this.resultEnum = resultEnum;
    }

    public ResultEnum getResultEnum() {
        return resultEnum;
    }

    public String getMessage() {
        if (resultEnum!=null){
            this.message=resultEnum.getMessage();
        }
        return message;
    }
    public Integer getCode() {
        if (resultEnum!=null){
            this.code=resultEnum.getCode();
        }
        return code;
    }
}
