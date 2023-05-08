package com.digital.ui;

public enum data {
    NAME("john"),
    SURNAME("Doe"),
    EMAIL(data.NAME.getUserInfo()+"."+data.SURNAME.getUserInfo()+"@gmail.com"),

    PASSWORD("SomeWords123546"),
    BIO("some info about someone"),
    LEARNERTYPE("Trainer-Type"),//"Admin-Type"||"Trainer-Type"||"Learner-Type"
    TIMEZONE("92"),//by value
    LANGUAGE("en"),
    CHECKBOXSTATUS("Active"),
    CHECKBOXDEACTIVE("deactivate_user"),
    URL("https://www.talentlms.com/"),
    URLUSER("https://nna.talentlms.com/user/index"),
    URLINFO("//a [text()='Info']")

    ;
    String userInfo;
    data(String userInfo){
        this.userInfo=userInfo;
    }
    public String getUserInfo(){
        return userInfo;
    }
}
