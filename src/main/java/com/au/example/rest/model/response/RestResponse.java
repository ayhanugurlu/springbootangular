package com.au.example.rest.model.response;


public class RestResponse<T> {

    private long traceID;

    private int status;

    private T data;

    private String message;

    public RestResponse(long traceID, int status, T data, String message) {
        this.traceID = traceID;
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public RestResponse(long traceID, int status, String message) {
        this.traceID = traceID;
        this.status = status;
        this.message = message;
    }

    public long getTraceID() {
        return traceID;
    }

    public void setTraceID(long traceID) {
        this.traceID = traceID;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
