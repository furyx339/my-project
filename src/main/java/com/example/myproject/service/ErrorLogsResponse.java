package com.example.myproject.service;

import com.example.myproject.model.ErrorLog;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Builder
public class ErrorLogsResponse {
    private Long id;
    private String lang;
    private String msg;
    private JsonNode st;
    private JsonNode context;

    public static ErrorLogsResponse buildResponse(ErrorLog errorLog){
            ErrorLogsResponse errorLogResponse = new ErrorLogsResponse();
            errorLogResponse.id = errorLog.getId();
            errorLogResponse.lang = errorLog.getLanguage();
            errorLogResponse.msg = errorLog.getMessage();
            
            // Since stacktrace and context are JsonNode types in the ErrorLog model,
            // we can directly assign them without type conversion
            errorLogResponse.st = errorLog.getStacktrace();
            errorLogResponse.context = errorLog.getContext();

            return errorLogResponse;
    }

    public static List<ErrorLogsResponse> buildResponses(List<ErrorLog> errorLogs){
        List<ErrorLogsResponse> responses  = new ArrayList<>();
        for (ErrorLog errorLog : errorLogs){
            responses.add(buildResponse(errorLog));
        }
        return responses;
    }

    public ErrorLogsResponse() {
    }

    public ErrorLogsResponse(Long id, String lang, String msg, JsonNode st, JsonNode context) {
        this.id = id;
        this.lang = lang;
        this.msg = msg;
        this.st = st;
        this.context = context;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public JsonNode getSt() {
        return st;
    }

    public void setSt(JsonNode st) {
        this.st = st;
    }

    public JsonNode getContext() {
        return context;
    }

    public void setContext(JsonNode context) {
        this.context = context;
    }

    @Override
    public String toString() {
        return "ErrorLogsResponse{" +
                "id=" + id +
                ", lang='" + lang + '\'' +
                ", msg='" + msg + '\'' +
                ", st=" + st +
                ", context=" + context +
                '}';
    }
}
