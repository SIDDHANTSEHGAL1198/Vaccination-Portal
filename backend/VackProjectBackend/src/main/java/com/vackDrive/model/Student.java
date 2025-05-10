package com.vackDrive.model;

import java.time.LocalDate;

public class Student {

    private Long id;
    private String name;
    private String className;
    private LocalDate dateOfBirth;
    private boolean vaccinated;
    private String vaccineName;

    public LocalDate getDateofVaccination() {
        return dateofVaccination;
    }

    public void setDateofVaccination(LocalDate dateofVaccination) {
        this.dateofVaccination = dateofVaccination;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", className='" + className + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", vaccinated=" + vaccinated +
                ", vaccineName='" + vaccineName + '\'' +
                ", dateofVaccination=" + dateofVaccination +
                '}';
    }

    private LocalDate dateofVaccination;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean getVaccinated() {
        return vaccinated;
    }

    public void setVaccinated(boolean vaccinated) {
        this.vaccinated = vaccinated;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }
}
