package com.jack_the_coder.bilboard_backend.model;

public class StatusResponse {
    private String operationResult;
    private String operationName;

    public String getOperationResult () {
        return operationResult;
    }

    public void setOperationResult ( String operationResult ) {
        this.operationResult = operationResult;
    }

    public String getOperationName () {
        return operationName;
    }

    public void setOperationName ( String operationName ) {
        this.operationName = operationName;
    }
}
