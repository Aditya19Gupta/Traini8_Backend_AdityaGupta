package com.adi.dum.repository;

import com.adi.dum.model.Address;
import com.adi.dum.model.TrainingCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
