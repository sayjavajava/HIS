package com.sd.his.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "PATIENT_VITAL")
@JsonIgnoreProperties(ignoreUnknown = true)
public class PatientVital  extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;


    @Column(name = "Name")
    private String name;

    @Column(name = "UNIT")
    private String unit;

    @Column(name = "STANDARD_VALUE")
    private String standardValue;

    public String getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(String currentValue) {
        this.currentValue = currentValue;
    }

    @Column(name = "CURRENT_VALUE")
    private String currentValue;

    @Column(name = "STATUS")
    private boolean status;

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "PATIENT_ID",nullable = false)
    private Patient patient;

    public PatientVital() {
    }


    public PatientVital(PatientVital patientVital) {
        this.setId(patientVital.getId());
        this.name = patientVital.getName();
        this.unit = patientVital.getUnit();
        this.standardValue = patientVital.getStandardValue();
        this.status = patientVital.getStatus();
        this.currentValue=patientVital.getCurrentValue();
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getStandardValue() {
        return standardValue;
    }

    public void setStandardValue(String standardValue) {
        this.standardValue = standardValue;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}