package com.sd.his.repositiories;

import com.sd.his.model.Properties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PropertiesRepo extends JpaRepository<Properties,Integer> {

    Properties findById(Integer i);
}
