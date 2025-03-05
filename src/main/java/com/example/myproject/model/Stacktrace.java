package com.example.myproject.model;

import com.fasterxml.jackson.databind.JsonNode;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import com.vladmihalcea.hibernate.type.json.JsonType;
import org.hibernate.annotations.Type;

import java.util.List;
import java.util.Map;


@Embeddable
public class Stacktrace {

    private String file;
    private int line_number;


    private String method;
    private String className;

    @Type(value = JsonType.class)
    private JsonNode codeSnippet;

    @Type(value = JsonType.class)
    private List<String> arguments = List.of();

    private boolean applicationFrame;

    // Constructors
    public Stacktrace() {
    }

    public Stacktrace(String file, int line_number, String method, String className, JsonNode codeSnippet, List<String> arguments, boolean applicationFrame) {
        this.file = file;
        this.line_number = line_number;
        this.method = method;
        this.className = className;
        this.codeSnippet = codeSnippet;
        this.arguments = arguments;
        this.applicationFrame = applicationFrame;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public int getLine_number() {
        return line_number;
    }

    public void setLine_number(int line_number) {
        this.line_number = line_number;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public JsonNode getCodeSnippet() {
        return codeSnippet;
    }

    public void setCodeSnippet(JsonNode codeSnippet) {
        this.codeSnippet = codeSnippet;
    }

    public List<String> getArguments() {
        return arguments;
    }

    public void setArguments(List<String> arguments) {
        this.arguments = arguments;
    }

    public boolean isApplicationFrame() {
        return applicationFrame;
    }

    public void setApplicationFrame(boolean applicationFrame) {
        this.applicationFrame = applicationFrame;
    }

    @Override
    public String toString() {
        return "Stacktrace{" +
                "file='" + file + '\'' +
                ", line_number=" + line_number +
                ", method='" + method + '\'' +
                ", className='" + className + '\'' +
                ", codeSnippet=" + codeSnippet +
                ", arguments=" + arguments +
                ", applicationFrame=" + applicationFrame +
                '}';
    }
}
