package com.adi.dum.repository;

import com.adi.dum.model.TrainingCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainingCenterRepository extends JpaRepository<TrainingCenter, Long> {

    @Query(value = "SELECT tc FROM TrainingCenter as tc")
    List<TrainingCenter> findAllTrainingCenter();
}
