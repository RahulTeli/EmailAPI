package com.emailapi.emailapi.Model;

public class Emailresponse {
    public String token;

    public Emailresponse(String token)
    {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    } 
}
