package com.stcodesapp.springbootdemo.services;

import com.stcodesapp.springbootdemo.model.Laptop;
import com.stcodesapp.springbootdemo.repository.LaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LaptopService {

    @Autowired
    private LaptopRepository laptopRepository;

    public void addLaptop(Laptop laptop) {
        laptopRepository.addLaptop(laptop);

    }

    public void printAllLaptops() {
        laptopRepository.printAllLaptops();
    }
}
