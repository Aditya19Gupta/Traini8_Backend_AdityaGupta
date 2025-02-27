package com.adi.dum.service;

import com.adi.dum.model.Address;
import com.adi.dum.model.TrainingCenter;
import com.adi.dum.repository.AddressRepository;
import com.adi.dum.repository.TrainingCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public Address save(Address address) {
        return addressRepository.save(address);
    }


}
