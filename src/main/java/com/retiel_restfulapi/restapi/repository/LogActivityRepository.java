package com.retiel_restfulapi.restapi.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import com.retiel_restfulapi.restapi.model.LogActivityModel;

@Repository
public interface LogActivityRepository extends JpaRepository<LogActivityModel, Integer> {
    
    @Query(value = "CALL sp_get_log_aktifitas()", nativeQuery = true)
    List<Object[]> getLogActivity();
}
