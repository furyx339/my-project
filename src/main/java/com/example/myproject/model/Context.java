package com.example.myproject.model;

import com.fasterxml.jackson.databind.JsonNode;
import com.vladmihalcea.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Type;

import java.util.List;
import java.util.Map;


@Embeddable
public class Context {

    @Embedded
    private Request request;

    @Type(value = JsonType.class)
    @Column(columnDefinition = "json")
    private JsonNode requestData;

    @Type(value = JsonType.class)
    @Column(columnDefinition = "json")
    private JsonNode headers;

    @Type(value = JsonType.class)
    @Column(columnDefinition = "json")
    private JsonNode cookies;

    @Type(value = JsonType.class)
    @Column(columnDefinition = "json")
    private JsonNode session;

    @Type(value = JsonType.class)
    @Column(columnDefinition = "json")
    private JsonNode route;

    @Type(value = JsonType.class)
    @Column(columnDefinition = "json")
    private JsonNode env;

    @Type(value = JsonType.class)
    @Column(columnDefinition = "json")
    private JsonNode git;

    @Type(value = JsonType.class)
    @Column(columnDefinition = "json")
    private List<Object> dumps;

    @Type(value = JsonType.class)
    @Column(columnDefinition = "json")
    private List<Object> logs;

    @Type(value = JsonType.class)
    @Column(columnDefinition = "json")
    private List<Object> queries;


    public Context() {
    }

    public Context(Request request, JsonNode requestData, JsonNode headers, JsonNode cookies, JsonNode session, JsonNode route, JsonNode env, JsonNode git, List<Object> dumps, List<Object> logs, List<Object> queries) {
        this.request = request;
        this.requestData = requestData;
        this.headers = headers;
        this.cookies = cookies;
        this.session = session;
        this.route = route;
        this.env = env;
        this.git = git;
        this.dumps = dumps;
        this.logs = logs;
        this.queries = queries;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public JsonNode getRequestData() {
        return requestData;
    }

    public void setRequestData(JsonNode requestData) {
        this.requestData = requestData;
    }

    public JsonNode getHeaders() {
        return headers;
    }

    public void setHeaders(JsonNode headers) {
        this.headers = headers;
    }

    public JsonNode getCookies() {
        return cookies;
    }

    public void setCookies(JsonNode cookies) {
        this.cookies = cookies;
    }

    public JsonNode getSession() {
        return session;
    }

    public void setSession(JsonNode session) {
        this.session = session;
    }

    public JsonNode getRoute() {
        return route;
    }

    public void setRoute(JsonNode route) {
        this.route = route;
    }

    public JsonNode getEnv() {
        return env;
    }

    public void setEnv(JsonNode env) {
        this.env = env;
    }

    public JsonNode getGit() {
        return git;
    }

    public void setGit(JsonNode git) {
        this.git = git;
    }

    public List<Object> getDumps() {
        return dumps;
    }

    public void setDumps(List<Object> dumps) {
        this.dumps = dumps;
    }

    public List<Object> getLogs() {
        return logs;
    }

    public void setLogs(List<Object> logs) {
        this.logs = logs;
    }

    public List<Object> getQueries() {
        return queries;
    }

    public void setQueries(List<Object> queries) {
        this.queries = queries;
    }

    @Override
    public String toString() {
        return "Context{" +
                "request=" + request +
                ", requestData=" + requestData +
                ", headers=" + headers +
                ", cookies=" + cookies +
                ", session=" + session +
                ", route=" + route +
                ", env=" + env +
                ", git=" + git +
                ", dumps=" + dumps +
                ", logs=" + logs +
                ", queries=" + queries +
                '}';
    }
}

