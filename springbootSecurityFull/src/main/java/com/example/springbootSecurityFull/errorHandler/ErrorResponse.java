package com.example.springbootSecurityFull.errorHandler;

public class ErrorResponse {

    private int statusCode;

    private String errorMessage;

    private long timeStamps;

    public ErrorResponse() {
    }

    public ErrorResponse(int statusCode, String errorMessage, long timeStamps) {
        this.statusCode = statusCode;
        this.errorMessage = errorMessage;
        this.timeStamps = timeStamps;
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

    public long getTimeStamps() {
        return timeStamps;
    }

    public void setTimeStamps(long timeStamps) {
        this.timeStamps = timeStamps;
    }
}
