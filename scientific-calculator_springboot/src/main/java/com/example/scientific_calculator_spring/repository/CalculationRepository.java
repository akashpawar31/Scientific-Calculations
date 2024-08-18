package com.example.scientific_calculator_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.scientific_calculator_spring.model.Calculation;
@Repository
public interface CalculationRepository extends JpaRepository<Calculation, Long> {

}
