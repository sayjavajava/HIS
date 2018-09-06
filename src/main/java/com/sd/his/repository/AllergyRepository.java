package com.sd.his.repository;

import com.sd.his.model.Allergy;
import com.sd.his.wrapper.AllergyWrapper;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by jamal on 8/20/2018.
 */
public interface AllergyRepository extends JpaRepository<Allergy, Long> {


    @Query("SELECT new com.sd.his.wrapper.AllergyWrapper(allergy) FROM Allergy allergy where allergy.id=:id")
    AllergyWrapper getAllergyById(@Param("id") long allergyId);

    @Query("SELECT new com.sd.his.wrapper.AllergyWrapper(allergy) FROM Allergy allergy")
    List<AllergyWrapper> getPaginatedAllergies(Pageable pageable);

    @Query("SELECT new com.sd.his.wrapper.AllergyWrapper(allergy) FROM Allergy allergy")
    List<AllergyWrapper> getAllAllergies();

}