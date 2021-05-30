package com.apsooba.interview.exception;

import java.util.function.Supplier;

public class InterviewException extends ApsoobaException implements Supplier<InterviewException> {

    @Override
    public InterviewException get() {
        return this;
    }

    public InterviewException(int code, String messageEn, String messageFa) {
        this.setApp("interview");
        this.setCode(code);
        this.setMessageEn(messageEn);
        this.setMessageFa(messageFa);
    }

    public InterviewException(InterviewExceptionType interviewExceptionType) {
        this(interviewExceptionType.getErrorCode(), interviewExceptionType.getErrorMessageEn(), interviewExceptionType.getErrorMessageFa());
    }

}
