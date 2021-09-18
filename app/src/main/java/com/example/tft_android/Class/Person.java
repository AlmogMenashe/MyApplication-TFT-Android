package com.example.tft_android.Class;


public class Person {

    private String email;
    private String name;
    private String age;
    private String weight;
    private String height;
    private String sex;
    private String time;
    private String mattress;
    private String stairs;
    private String bottles;
    private String pullupbar;

    public Person(){

    }

    public Person(String email,String name, String age, String weight, String height,String sex,String time,String mattress,String stairs,String bottles,String pullupbar) {
        this.email = email;
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.sex = sex;
        this.time = time;
        this.mattress = mattress;
        this.stairs = stairs;
        this.bottles = bottles;
        this.pullupbar = pullupbar;
    }

    public String getEmail() { return email; }

    public String getName() { return name; }

    public String getAge() {
        return age;
    }

    public String getWeight() {
        return weight;
    }

    public String getHeight() {
        return height;
    }

    public String getSex() { return sex; }

    public String getTime() { return time; }

    public String getMattress() { return mattress; }

    public String getStairs() { return stairs; }

    public String getBottles() { return bottles; }

    public String getPullupbar() { return pullupbar; }


    public void setEmail(String email) { this.email = email; }

    public void setName(String name) { this.name = name; }

    public void setAge(String age) { this.age = age; }

    public void setWeight(String weight) { this.weight = weight; }

    public void setHeight(String height) { this.height = height; }

    public void setSex(String sex) { this.sex = sex; }

    public void setTime(String time) { this.time = time; }

    public void setMattress(String mattress) { this.mattress = mattress; }

    public void setStairs(String stairs) { this.stairs = stairs; }

    public void setBottles(String bottles) { this.bottles = bottles; }

    public void setPullupbar(String pullupbar) { this.pullupbar = pullupbar; }

}

