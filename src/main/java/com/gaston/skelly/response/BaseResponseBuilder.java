package com.gaston.skelly.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class BaseResponseBuilder {

    private static final String SUCCESS = "SUCCESS";
    private static final String ERROR = "ERROR";
    public static ResponseEntity<BaseResponse> buildErrorResponse(BaseServiceErrorCode error, HttpStatus status) {
        BaseResponse response = new BaseResponse();
        response.setStatus(ERROR);
        Map<String, Object> errorMap = new HashMap<>();
        errorMap.put("code", error.getCode());
        errorMap.put("message", error.getMessage());
        response.setError(errorMap);
        return new ResponseEntity<>(response, status);
    }

    public static ResponseEntity<BaseResponse> buildSuccessResponse(Object data) {
        BaseResponse response = new BaseResponse();
        response.setStatus(SUCCESS);
        response.setData(data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public static ResponseEntity<BaseResponse> buildSuccessResponse(Object data, HttpStatus status) {
        BaseResponse response = new BaseResponse();
        response.setStatus(SUCCESS);
        response.setData(data);
        return new ResponseEntity<>(response, status);
    }
}
