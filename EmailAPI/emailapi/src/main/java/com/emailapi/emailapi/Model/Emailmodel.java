package com.emailapi.emailapi.Model;

public class Emailmodel {
    private String to, subject, message;

    public Emailmodel(String to, String subject, String message) {
        this.to = to;
        this.subject = subject;
        this.message = message;
    }

    public Emailmodel() {
    }

    public void setTo(String to) {
        this.to = to;
    }

    @Override
    public String toString() {
        return "Emailmodel [to=" + to + ", subject=" + subject + ", message=" + message + "]";
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTo() {
        return to;
    }

}
