package com.digital.ui;

public enum users {
    NAME("Salmon"), SURNAME("Khan"),EMAIL("salkhan@gmail.com"), USERNAME("salkhan");
    String userInfo;
    users(String userInfo){
        this.userInfo=userInfo;
    }
    public String getUserInfo(){
        return userInfo;
    }
}
