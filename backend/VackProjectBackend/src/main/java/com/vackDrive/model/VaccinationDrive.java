package com.vackDrive.model;

import java.time.LocalDateTime;

public class VaccinationDrive {
    private int id;
    private String vaccinationName;
    private LocalDateTime date;
    private String availableDoses;
    private String applicableClasses;
    private boolean isEditable;

    // Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVaccinationName() {
        return vaccinationName;
    }

    public void setVaccinationName(String vaccinationName) {
        this.vaccinationName = vaccinationName;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getAvailableDoses() {
        return availableDoses;
    }

    public void setAvailableDoses(String availableDoses) {
        this.availableDoses = availableDoses;
    }

    public String getApplicableClasses() {
        return applicableClasses;
    }

    public void setApplicableClasses(String applicableClasses) {
        this.applicableClasses = applicableClasses;
    }

    public boolean isEditable() {
        return isEditable;
    }

    public void setEditable(boolean editable) {
        isEditable = editable;
    }
}
