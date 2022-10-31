package com.example.irregation.repository;

import com.example.irregation.model.Land;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface LandRepository extends JpaRepository<Land, Integer> {

    @Query("SELECT l FROM Land l")
    List<Land> findAll();

    @Query("SELECT l FROM Land l WHERE l.area=10")
    List<Land> findByArea(double area);


}
