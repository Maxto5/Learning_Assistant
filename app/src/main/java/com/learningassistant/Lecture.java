package com.learningassistant;

public class Lecture {
    private  String unit_code,unit_name,session,class_size,mode,lecturer_name,day,time;

    //generated getter and setter methods
    public String getUnit_code() {
        return unit_code;
    }

    public void setUnit_code(String unit_code) {
        this.unit_code = unit_code;
    }

    public String getUnit_name() {
        return unit_name;
    }

    public void setUnit_name(String unit_name) {
        this.unit_name = unit_name;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getClass_size() {
        return class_size;
    }

    public void setClass_size(String class_size) {
        this.class_size = class_size;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getLecturer_name() {
        return lecturer_name;
    }

    public void setLecturer_name(String lecturer_name) {
        this.lecturer_name = lecturer_name;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    //generate empty constructor
    public Lecture() {
    }

    //generate full constructor

    public Lecture(String unit_code, String unit_name, String session, String class_size, String mode, String lecturer_name, String day, String time) {
        this.unit_code = unit_code;
        this.unit_name = unit_name;
        this.session = session;
        this.class_size = class_size;
        this.mode = mode;
        this.lecturer_name = lecturer_name;
        this.day = day;
        this.time = time;
    }
}
