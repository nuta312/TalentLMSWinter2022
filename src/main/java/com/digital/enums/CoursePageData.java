package com.digital.enums;

public enum CoursePageData {


    COURSE_NAME1("Machine learning"),
    COURSE_NAME2("UI/UX"),
    CATEGORY1("Middle"),
    CATEGORY2("IT"),
    DESCRIPTION1("Machine learning is a branch of artificial " +
                        "intelligence (AI) and computer science " +
                        "which focuses on the use of data and algorithms " +
                        "to imitate the way that humans learn, gradually " +
                        "improving its accuracy."),
    DESCRIPTION2("User interface (UI) and user experience (UX) are " +
            "two words that you might hear mentioned frequently in tech " +
            "circles (and sometimes interchangeably).");





    String inputValue;

    CoursePageData (String inpValue){
        this.inputValue = inpValue;
    }

    public String getInpVal(){
        return this.inputValue;
    }

}
