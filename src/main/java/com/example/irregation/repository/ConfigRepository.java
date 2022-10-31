package com.example.irregation.repository;

import com.example.irregation.model.Config;
import com.example.irregation.model.Land;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.NamedQuery;
import java.util.Date;
import java.util.List;


@Repository
public interface ConfigRepository extends JpaRepository<Config, Integer> {

    @Query( "Select c from Config c where c.startDate <= :currentDate and c.endDate >= :currentDate")
    List<Config> findByDateRange(Date currentDate);





//    @Query("")

//    select
//    c.id,
//    from Config as c, Trans t
//    where c.Num_irr<= t.status and c.id = t.config_id and c.start_date <= ?1 and c.end_date>= ?1



//    select c.id
//            if(c.start_date <= ?1 AND c.end_date>= ?1 And c.Num_irr<= t.status where c.id =t.config_id,"irrigate","don't irrig")
//    As Result
//    FROM Config c, Trans t


//    SELECT config_id,SUM(status) From Trans Group BY config_id



}
