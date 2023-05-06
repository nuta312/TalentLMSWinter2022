package com.digital.enums;

public enum ValueForBasicSettingsPage {
    URL("https://winter2022.talentlms.com/account/basic_index"),
    DESCRIPTION("TalentLMS it is an easy-to-use learning management system (LMS), suitable for both experienced and beginner trainers. The system allows you to quickly create courses for corporate online trainings."),
    LOGO("logo.png"),
    FAVICON("favicon.png"),
    DateFormat("MM/DD/YYYY"),
    TimeFormat("12-hour"),
    CURRENCY("Dollar"),
    ExternalAnnouncement("Please, enter your account details");

    String value;

    ValueForBasicSettingsPage (String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }
}

