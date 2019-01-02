package com.example.hakim.homelless;

public class Situation {
    private int changeAge;
    private int changeCapital;
    private int changeHealth;
    private String Str;

    public Situation(String Str, int changeHealth, int changeCapital, int changeAge) {
        this.changeAge = changeAge;
        this.changeCapital = changeCapital;
        this.changeHealth = changeHealth;
        this.Str = Str;
    }
    public Situation(){
        this.changeAge = 0;
        this.changeCapital = 0;
        this.changeHealth = 0;
        this.Str = "None";
    }

    public int getChangeAge() {
        return changeAge;
    }

    public void setChangeAge(int changeAge) {
        this.changeAge = changeAge;
    }

    public int getChangeCapital() {
        return changeCapital;
    }

    public void setChangeCapital(int changeCapital) {
        this.changeCapital = changeCapital;
    }

    public int getChangeHealth() {
        return changeHealth;
    }

    public void setChangeHealth(int changeHealth) {
        this.changeHealth = changeHealth;
    }

    public String getStr() {
        return Str;
    }

    public void setStr(String str) {
        Str = str;
    }
}
