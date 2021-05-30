package com.apsooba.interview.exception;

public class ApsoobaException extends Exception{

    private String app;
    private int code;
    private String messageEn;
    private String messageFa;

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessageEn() {
        return messageEn;
    }

    public void setMessageEn(String messageEn) {
        this.messageEn = messageEn;
    }

    public String getMessageFa() {
        return messageFa;
    }

    public void setMessageFa(String messageFa) {
        this.messageFa = messageFa;
    }
}
