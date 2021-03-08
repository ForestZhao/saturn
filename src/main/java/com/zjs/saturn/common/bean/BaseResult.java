package com.zjs.saturn.common.bean;

import lombok.Data;

@Data
public class BaseResult {

    /**
     * 0-success 1-failed
     */
    private Integer code = 1;

    private String errMsg;

    private Object result;


}
