package com.sd.his.wrapper;

import com.sd.his.model.Patient;
import com.sd.his.model.PatientVital;
import com.sd.his.repository.PatientRepository;
import com.sun.xml.internal.bind.api.impl.NameConverter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Column;
import java.util.List;

public class PatientVitalWrapper extends BaseWrapper {


    @Autowired
    PatientRepository patientRepository;

    private Long id;
    private String name;
    private String unit;
    private String standardValue;
    private String currentValue;
    private boolean status;

    List<PatientVital> listOfVital;


    public PatientVitalWrapper(long id, String name, String unit, String standardValue, String currentValue, boolean status, String patient) {
        this.id = id;
        this.name = name;
        this.unit = unit;
        this.standardValue = standardValue;
        this.currentValue = currentValue;
        this.status = status;
        this.patientId = patient;
    }

    public PatientVitalWrapper(long id, String name, String unit, String standardValue, String currentValue, boolean status, Patient patient) {
        this.id = id;
        this.name = name;
        this.unit = unit;
        this.standardValue = standardValue;
        this.currentValue = currentValue;
        this.status = status;
        this.patientId = String.valueOf(patient.getId());
    }

    public PatientVitalWrapper() {
    }

    public PatientVitalWrapper(List<PatientVital> list, String name, Patient patient, boolean status, String unit) {
        this.listOfVital = list;
        this.name = name;
        this.patient = patient;
        this.status = status;
        this.unit = unit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    private Patient patient;

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    private String patientId;

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


    public String getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(String currentValue) {
        this.currentValue = currentValue;
    }


    public List<PatientVital> getListOfVital() {
        return listOfVital;
    }

    public void setListOfVital(List<PatientVital> listOfVital) {
        this.listOfVital = listOfVital;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public PatientVitalWrapper(String createdDate, String currentValue, long id, String name, long patientId, String Standard, boolean
            status, String unit, String updated) {
        super.setCreatedOn(createdDate);
        this.currentValue = currentValue;
        this.id = id;
        this.name = name;
       this.patientId=String.valueOf(patientId);
        this.standardValue = Standard;
        this.status = status;
        this.unit = unit;
        super.setUpdatedOn(updated);
    }

    public PatientVitalWrapper(String currentValue,long id,String name,boolean status,String unit){
    this.currentValue=currentValue;
    this.id=id;
    this.name=name;
    this.status=status;
    this.unit=unit;
    }
}