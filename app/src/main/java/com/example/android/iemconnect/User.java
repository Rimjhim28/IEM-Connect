package com.example.android.iemconnect;

public  class User {

    String name, contact, department, tech1, tech2, tech3;

    public User(){}

    public User (String name,String department){
        this.name = name;
        this.department = department;
    }

    public User (String name, String contact, String department, String tech1, String tech2, String tech3){
        this.name = name;
        this.contact = contact;
        this.department = department;
        this.tech1 = tech1;
        this.tech2 = tech2;
        this.tech3 = tech3;
    }

    public String getName(){
        return name;
    }

    public String getContact(){
        return contact;
    }

    public String getDepartment(){
        return department;
    }

    public String getTech1(){
        return tech1;
    }

    public String getTech2(){
        return tech2;
    }

    public String getTech3(){
        return tech3;
    }
}