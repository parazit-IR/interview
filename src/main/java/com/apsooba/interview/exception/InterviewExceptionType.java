package com.apsooba.interview.exception;

public enum InterviewExceptionType {

    DEFAULT_EXCEPTION(1, "Exception in Interview API", "خطا در سامانه "),
    POST_NOT_FOUND_EXCEPTION(2, "Post Record Not Found", "رکورد موردنظر پیدا نشد");

    private int errorCode;
    private String errorMessageEn;
    private String errorMessageFa;

    InterviewExceptionType(int errorCode, String errorMessageEn, String errorMessageFa) {
        this.errorCode = errorCode;
        this.errorMessageEn = errorMessageEn;
        this.errorMessageFa = errorMessageFa;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMessageEn() {
        return errorMessageEn;
    }

    public String getErrorMessageFa() {
        return errorMessageFa;
    }

    @Override
    public String toString() {
        return "InterviewExceptionType{" +
                "errorCode=" + errorCode +
                ", errorMessageEn='" + errorMessageEn + '\'' +
                ", errorMessageFa='" + errorMessageFa + '\'' +
                '}';
    }
    }
