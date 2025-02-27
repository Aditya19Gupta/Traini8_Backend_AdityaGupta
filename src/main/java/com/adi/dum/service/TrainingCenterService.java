package com.adi.dum.service;

import com.adi.dum.model.TrainingCenter;
import com.adi.dum.repository.TrainingCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingCenterService {
    @Autowired
    private TrainingCenterRepository trainingCenterRepository;

    public TrainingCenter save(TrainingCenter trainingCenter) {
        return trainingCenterRepository.save(trainingCenter);
    }


    public List<TrainingCenter> findAll() {
        return trainingCenterRepository.findAllTrainingCenter();
    }
}
