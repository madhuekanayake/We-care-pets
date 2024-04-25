package com.example.myapplication;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Caremodel {
    private String name;
    private String experience;
    private String availability;
    private String email;
    private String rate;

    // Empty constructor needed for Firebase
    public Caremodel() {
    }

    public Caremodel(String name, String experience, String availability, String email, String rate) {
        this.name = name;
        this.experience = experience;
        this.availability = availability;
        this.email = email;
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public String getExperience() {
        return experience;
    }

    public String getAvailability() {
        return availability;
    }

    public String getEmail() {
        return email;
    }

    public String getRate() {
        return rate;
    }
}