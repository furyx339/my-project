package com.example.myproject.model;

import com.fasterxml.jackson.databind.JsonNode;
import jakarta.persistence.*;

import java.math.BigInteger;
import java.util.Optional;

@Entity
@Table(name = "error_log")
public class ErrorLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String language;
    private String framework_version;
    private String language_version;
    private String exception_class;
    private BigInteger seen_at;
    private String message;

    @Column(columnDefinition = "json")
    private JsonNode stacktrace;

    @Column(columnDefinition = "json")
    private JsonNode context;

    private String stage;
    private String tracking_uuid;
    private String url;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    public ErrorLog() {
    }

    public ErrorLog(Long id, String language, String framework_version, String language_version, String exception_class, BigInteger seen_at, String message, JsonNode stacktrace, JsonNode context, String stage, String tracking_uuid, String url, Project project, Users user) {
        this.id = id;
        this.language = language;
        this.framework_version = framework_version;
        this.language_version = language_version;
        this.exception_class = exception_class;
        this.seen_at = seen_at;
        this.message = message;
        this.stacktrace = stacktrace;
        this.context = context;
        this.stage = stage;
        this.tracking_uuid = tracking_uuid;
        this.url = url;
        this.project = project;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getFramework_version() {
        return framework_version;
    }

    public void setFramework_version(String framework_version) {
        this.framework_version = framework_version;
    }

    public String getLanguage_version() {
        return language_version;
    }

    public void setLanguage_version(String language_version) {
        this.language_version = language_version;
    }

    public String getException_class() {
        return exception_class;
    }

    public void setException_class(String exception_class) {
        this.exception_class = exception_class;
    }

    public BigInteger getSeen_at() {
        return seen_at;
    }

    public void setSeen_at(BigInteger seen_at) {
        this.seen_at = seen_at;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public JsonNode getStacktrace() {
        return stacktrace;
    }

    public void setStacktrace(JsonNode stacktrace) {
        this.stacktrace = stacktrace;
    }

    public JsonNode getContext() {
        return context;
    }

    public void setContext(JsonNode context) {
        this.context = context;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getTracking_uuid() {
        return tracking_uuid;
    }

    public void setTracking_uuid(String tracking_uuid) {
        this.tracking_uuid = tracking_uuid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Users getUser(){
        return user;
    }

    public void setUser(Users user){
        this.user = user;
    }



    @Override
    public String toString() {
        return "ErrorLog{" +
                "id=" + id +
                ", language='" + language + '\'' +
                ", framework_version='" + framework_version + '\'' +
                ", language_version='" + language_version + '\'' +
                ", exception_class='" + exception_class + '\'' +
                ", seen_at=" + seen_at +
                ", message='" + message + '\'' +
                ", stacktrace=" + stacktrace +
                ", context=" + context +
                ", stage='" + stage + '\'' +
                ", tracking_uuid='" + tracking_uuid + '\'' +
                ", url='" + url + '\'' +
                ", project=" + project +
                ", user=" + user +
                '}';
    }
}
