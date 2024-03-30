package com.example.japAdvanced.errorHandler;

public class ErrorMessage {

    private int statusCode;

    private String errorMessage;

    private long timeStamp;

    public ErrorMessage() {}

    public ErrorMessage(int statusCode, String errorMessage, long timeStamp) {
        this.statusCode = statusCode;
        this.errorMessage = errorMessage;
        this.timeStamp = timeStamp;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
