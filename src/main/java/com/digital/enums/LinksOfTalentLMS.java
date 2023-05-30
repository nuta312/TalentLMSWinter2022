package com.digital.enums;

import lombok.Getter;

public enum LinksOfTalentLMS {
    @Getter
    FIRSTPAGE ("https://nuta1bema.talentlms.com/user/index");

    String firstTalentLMSPage;

    LinksOfTalentLMS(String firstTalentLMSPage) {
        this.firstTalentLMSPage = firstTalentLMSPage;
    }

    public String getFirstTalentLMSPage() {
        return this. firstTalentLMSPage;
    }
}
