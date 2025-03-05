package com.example.myproject.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;


@Embeddable
public class Request {
    private String url;
    private String ip;

    @Column(insertable = false, updatable = false)
    private String method;
    private String userAgent;

    public Request() {
    }

    public Request(String url, String ip, String method, String userAgent) {
        this.url = url;
        this.ip = ip;
        this.method = method;
        this.userAgent = userAgent;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    @Override
    public String toString() {
        return "Request{" +
                "url='" + url + '\'' +
                ", ip='" + ip + '\'' +
                ", method='" + method + '\'' +
                ", userAgent='" + userAgent + '\'' +
                '}';
    }
}
