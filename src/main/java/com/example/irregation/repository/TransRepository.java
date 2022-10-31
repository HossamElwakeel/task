package com.example.irregation.repository;

import com.example.irregation.model.Config;
import com.example.irregation.model.Trans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Objects;


@Repository
public interface TransRepository extends JpaRepository<Trans, Integer>{

    @Query("SELECT t.config.id, SUM(t.status) FROM  Trans t Group BY t.config.id")
    Map<Integer, Integer> sumOfIrrPerConfig();
    
}
