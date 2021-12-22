package com.jaho.cucumber.course.definitions;

import lombok.Data;
import java.util.Map;

@Data
public class RequestInformation {
    private String url;
    private Map<String, ?> headers;
    private String body;

    public RequestInformation (String url, Map<String, ?> headers, String body) {
        this.url=url;
        this.headers = headers;
        this.body = body;
    }

    public RequestInformation (String url, Map<String, ?> headers) {
        this.url=url;
        this.headers = headers;
    }

    public RequestInformation() {
    }
}
