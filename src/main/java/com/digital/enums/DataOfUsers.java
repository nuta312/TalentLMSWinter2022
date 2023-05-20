package com.digital.enums;

public enum DataOfUsers {
    LOGIN("nuta1bema"),
    PASSWORD("nuta1bema");

    String usersData;
    DataOfUsers(String usersData){
        this.usersData = usersData;
    }

    public String getUsersData(){
        return this.usersData;
    }
}
