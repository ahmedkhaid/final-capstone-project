package com.example.sharingapp;

public class Contact{
    private String email;
    private String userName;
    private String id;
    public Contact(String userName,String email,String id)
    {
        this.email=email;
        this.userName=userName;
        this.id=id;
    }
    public void setEmail(String email)
    {
        this.email=email;
        
    }
    public String getEmail()
    {
        return this.email;
    }
    public void setId(String id)
    {
        this.id=id;
    }
    public String getId()
    {
        return this.id;
    }
    public String getUsername()
    {
        return this.userName;
    }
    public void setUserName(String userName)
    {
        this.userName=userName;
    }
    public void UpdateId(String id)
    {
        this.id = id;
    }
}