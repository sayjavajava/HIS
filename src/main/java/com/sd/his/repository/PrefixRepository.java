package com.sd.his.repository;


import com.sd.his.enums.ModuleEnum;
import com.sd.his.model.Doctor;
import com.sd.his.model.Prefix;
import com.sd.his.model.User;
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
public interface PrefixRepository extends JpaRepository<Prefix, Long> {
    Prefix findByModule(ModuleEnum moduleEnum);

}

