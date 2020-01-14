package com.lovers.common.base.dto.common;

import java.util.HashMap;

public class Result {

    private boolean success;

    private String message;

    private Object data=new HashMap<>();

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
