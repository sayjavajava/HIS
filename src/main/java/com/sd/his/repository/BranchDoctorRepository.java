package com.sd.his.repository;

import com.sd.his.model.Branch;
import com.sd.his.model.BranchDoctor;
import com.sd.his.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 * @author    : waqas kamran
 * @Date      : 17-Apr-18
 * @version   : ver. 1.0.0
 *
 * ________________________________________________________________________________________________
 *
 *  Developer				Date		     Version		Operation		Description
 * ________________________________________________________________________________________________
 *
 *
 * ________________________________________________________________________________________________
 *
 * @Project   : HIS
 * @Package   : com.sd.his.*
 * @FileName  : UserAuthAPI
 *
 * Copyright ©
 * SolutionDots,
 * All rights reserved.
 *
 */
@Repository
public interface BranchDoctorRepository extends JpaRepository<BranchDoctor, Long> {

     BranchDoctor findByBranch(Branch branch);
     BranchDoctor findByDoctorAndPrimaryBranchTrue(Doctor doctor);
     void deleteAllByDoctorAndPrimaryBranchFalse(Doctor doctor);
     void deleteAllByDoctor(Doctor doctor);



}
