package com.sd.his.wrapper;

import java.util.Date;
import java.util.List;

public class VitalWrapper {

    private String createdOn;
    private String currentValue;
    private Long id;
    private List<VitalWrapper> listOfVital;
    private String name;
    private String patient;
    private long  patientId;
    private String standardValue;
    private boolean status;
    private String unit;

    private String updatedOn;

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public String getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(String currentValue) {
        this.currentValue = currentValue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<VitalWrapper> getListOfVital() {
        return listOfVital;
    }

    public void setListOfVital(List<VitalWrapper> listOfVital) {
        this.listOfVital = listOfVital;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }

    public long getPatientId() {
        return patientId;
    }

    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }

    public String getStandardValue() {
        return standardValue;
    }

    public void setStandardValue(String standardValue) {
        this.standardValue = standardValue;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(String updatedOn) {
        this.updatedOn = updatedOn;
    }
}