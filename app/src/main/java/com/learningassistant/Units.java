package com.learningassistant;

public class Units {
    private String unit_code;
    private String unit_name;
    private String session;
    private String size;
    private String mode;
    private String lecturer;
    private String day;
    private String time;
    private String venue;

    public Units() {
    }

    public Units(String unit_code, String unit_name, String session, String size, String mode, String lecturer, String day, String time, String venue) {
        this.unit_code = unit_code;
        this.unit_name = unit_name;
        this.session = session;
        this.size = size;
        this.mode = mode;
        this.lecturer = lecturer;
        this.day = day;
        this.time = time;
        this.venue = venue;
    }

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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getLecturer() {
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
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

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

}

