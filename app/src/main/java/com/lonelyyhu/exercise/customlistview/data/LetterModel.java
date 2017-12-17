package com.lonelyyhu.exercise.customlistview.data;

/**
 * Created by hulonelyy on 2017/11/18.
 */

public class LetterModel {

    private String upperCase;
    private String lowerCase;

    public LetterModel(String upperCase, String lowerCase) {
        this.upperCase = upperCase;
        this.lowerCase = lowerCase;
    }

    public String getUpperCase() {
        return upperCase;
    }


    public String getLowerCase() {
        return lowerCase;
    }

    public void setUpperCase(String upperCase) {
        this.upperCase = upperCase;
    }

    public void setLowerCase(String lowerCase) {
        this.lowerCase = lowerCase;
    }
}
