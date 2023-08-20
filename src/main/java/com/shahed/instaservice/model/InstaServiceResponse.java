package com.shahed.instaservice.model;

import lombok.Data;

@Data
public class InstaServiceResponse {
    private Boolean hasError;
    private String message;
    private String content;
    private Integer status;

    public InstaServiceResponse() {
    }

    public InstaServiceResponse(String message, Integer status) {
        this.hasError = Boolean.TRUE;
        this.message = message;
        this.status = status;
    }

    public InstaServiceResponse(String message, String content, Integer status) {
        this.hasError = Boolean.TRUE;
        this.message = message;
        this.content = content;
        this.status = status;
    }
}
