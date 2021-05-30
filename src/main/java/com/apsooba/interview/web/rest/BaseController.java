package com.apsooba.interview.web.rest;

import com.apsooba.interview.exception.ApsoobaException;
import com.apsooba.interview.exception.InterviewExceptionType;
import com.apsooba.interview.exception.InterviewException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class BaseController<T> {

    protected static final Logger logger1 = LogManager.getLogger(BaseController.class);

    protected ResponseEntity<RestResponse> failure(Exception e) {
        RestResponse restresponse = new RestResponse();
        restresponse.setErrorMessage(e.getMessage());
        ApsoobaException pe;
        if (e instanceof ApsoobaException) {
            pe = (ApsoobaException) e;
            logger1.error(pe);
        } else {
            e.printStackTrace();
            logger1.error(e.getStackTrace());
            pe = new InterviewException(InterviewExceptionType.DEFAULT_EXCEPTION);
        }
        restresponse.setErrorCode(pe.getCode());
        restresponse.setErrorMessage(pe.getMessageEn());
        restresponse.setPersianErrorMessage(pe.getMessageFa());
        ResponseEntity<RestResponse> responseEntity = new ResponseEntity<>(restresponse, HttpStatus.UNPROCESSABLE_ENTITY);
        return responseEntity;
    }

    protected ResponseEntity<RestResponse<T>> success(T result) {
        RestResponse<T> restResponse = new RestResponse();
        restResponse.setData(result);
        ResponseEntity<RestResponse<T>> responseEntity = new ResponseEntity(result, HttpStatus.OK);
        return responseEntity;
    }

}
