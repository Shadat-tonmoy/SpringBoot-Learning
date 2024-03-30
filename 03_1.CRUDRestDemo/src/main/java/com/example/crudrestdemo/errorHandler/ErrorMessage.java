package com.example.crudrestdemo.errorHandler;

public class ErrorMessage {
    private int errorStatus;
    private String message;
    private long timeStamp;

    public ErrorMessage() {
    }

    public ErrorMessage(int errorStatus, String message, long timeStamp) {
        this.errorStatus = errorStatus;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public int getErrorStatus() {
        return errorStatus;
    }

    public void setErrorStatus(int errorStatus) {
        this.errorStatus = errorStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
