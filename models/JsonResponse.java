package com.revature.models;

public class JsonResponse {
    private Boolean successful;
    private String message;
    private Object data;


    public JsonResponse(Boolean successful, String message, Object data) {
        this.successful = successful;
        this.message = message;
        this.data = data;
    }

    public JsonResponse() {
    }

    public Boolean isSuccessful() {
        return this.successful;
    }

    public Boolean getSuccessful() {
        return this.successful;
    }

    public void setSuccessful(Boolean successful) {
        this.successful = successful;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "{" +
            " successful='" + isSuccessful() + "'" +
            ", message='" + getMessage() + "'" +
            ", data='" + getData() + "'" +
            "}";
    }
    

}
