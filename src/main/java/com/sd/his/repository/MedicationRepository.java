package com.sd.his.repository;

import com.sd.his.model.Medication;
import com.sd.his.wrapper.MedicationWrapper;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jamal on 8/28/2018.
 */
@Repository
public interface MedicationRepository extends JpaRepository<Medication, Long> {

    @Query("SELECT new com.sd.his.wrapper.MedicationWrapper(medication) FROM Medication medication")
    List<MedicationWrapper> getPaginatedMedications(Pageable pageable);

    @Query("SELECT new com.sd.his.wrapper.MedicationWrapper(medication) FROM Medication medication")
    List<MedicationWrapper> getMedications();

    @Query("SELECT new com.sd.his.wrapper.MedicationWrapper(medication) FROM Medication medication where medication.id=:id")
    MedicationWrapper getMedicationById(@Param("id") long medicationId);
}