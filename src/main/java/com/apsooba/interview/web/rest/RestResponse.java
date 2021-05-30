package com.apsooba.interview.web.rest;

public class RestResponse<T> {

    private Integer errorCode;
    private String errorMessage;
    private String persianErrorMessage;
    private T data;

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getPersianErrorMessage() {
        return persianErrorMessage;
    }

    public void setPersianErrorMessage(String persianErrorMessage) {
        this.persianErrorMessage = persianErrorMessage;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
