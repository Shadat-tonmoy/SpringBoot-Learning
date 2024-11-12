package com.stcodesapp.springbootdemo.repository;

import com.stcodesapp.springbootdemo.model.Laptop;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LaptopRepository {

    private List<Laptop> laptops = new ArrayList<>();

    public void addLaptop(Laptop laptop){
        laptops.add(laptop);
    }

    public void printAllLaptops() {
        for(Laptop laptop : laptops){
            System.out.println("Laptop id is : "+laptop.hashCode());
        }
    }
}
