package com.example.scientific_calculator_spring.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.scientific_calculator_spring.model.Calculation;
import com.example.scientific_calculator_spring.model.ComplexNumber;
import com.example.scientific_calculator_spring.repository.CalculationRepository;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
public class ScientificCalculator {

    @Autowired
    private CalculationRepository calculationRepository;
    

    public double sin(double x) {
        double result = Math.sin(x);
        saveCalculation("sin", Double.toString(x), Double.toString(result));
        return result;
    }

    public double cos(double x) {
        double result = Math.cos(x);
        saveCalculation("cos", Double.toString(x), Double.toString(result));
        return result;
    }

    public double tan(double x) {
        double result = Math.tan(x);
        saveCalculation("tan", Double.toString(x), Double.toString(result));
        return result;
    }

    public double log(double x) {
        if (x <= 0) {
            throw new IllegalArgumentException("Logarithm is undefined for non-positive numbers");
        }
        double result = Math.log10(x);
        saveCalculation("log", Double.toString(x), Double.toString(result));
        return result;
    }

    public double ln(double x) {
        if (x <= 0) {
            throw new IllegalArgumentException("Natural logarithm is undefined for non-positive numbers");
        }
        double result = Math.log(x);
        saveCalculation("ln", Double.toString(x), Double.toString(result));
        return result;
    }

    public double exp(double x) {
        double result = Math.exp(x);
        saveCalculation("exp", Double.toString(x), Double.toString(result));
        return result;
    }

    public double power(double base, double exponent) {
        if (base == 0 && exponent < 0) {
            throw new IllegalArgumentException("Cannot raise zero to a negative power");
        }
        double result = Math.pow(base, exponent);
        saveCalculation("power", base + "," + exponent, Double.toString(result));
        return result;
    }

    public ComplexNumber addComplex(ComplexNumber a, ComplexNumber b) {
        ComplexNumber result = a.add(b);
        saveCalculation("addComplex", a + "," + b, result.toString());
        return result;
    }

    public ComplexNumber subtractComplex(ComplexNumber a, ComplexNumber b) {
        ComplexNumber result = a.subtract(b);
        saveCalculation("subtractComplex", a + "," + b, result.toString());
        return result;
    }

    public ComplexNumber multiplyComplex(ComplexNumber a, ComplexNumber b) {
        ComplexNumber result = a.multiply(b);
        saveCalculation("multiplyComplex", a + "," + b, result.toString());
        return result;
    }

    public ComplexNumber divideComplex(ComplexNumber a, ComplexNumber b) {
        ComplexNumber result = a.divide(b);
        saveCalculation("divideComplex", a + "," + b, result.toString());
        return result;
    }

    public double mean(double... numbers) {
        double sum = Arrays.stream(numbers).sum();
        double result = sum / numbers.length;
        saveCalculation("mean", Arrays.toString(numbers), Double.toString(result));
        return result;
    }

    public double median(double... numbers) {
        Arrays.sort(numbers);
        double result;
        if (numbers.length % 2 == 0) {
            result = (numbers[numbers.length / 2 - 1] + numbers[numbers.length / 2]) / 2.0;
        } else {
            result = numbers[numbers.length / 2];
        }
        saveCalculation("median", Arrays.toString(numbers), Double.toString(result));
        return result;
    }

    public double standardDeviation(double... numbers) {
        double mean = mean(numbers);
        double sumSquaredDiff = Arrays.stream(numbers)
                .map(x -> Math.pow(x - mean, 2))
                .sum();
        double result = Math.sqrt(sumSquaredDiff / numbers.length);
        saveCalculation("standardDeviation", Arrays.toString(numbers), Double.toString(result));
        return result;
    }

    private void saveCalculation(String operation, String input, String result) {
        Calculation calculation = new Calculation(operation, input, result, LocalDateTime.now());
        calculationRepository.save(calculation);
        
       
        List<Calculation> allCalculations = calculationRepository.findAll();
        if (allCalculations.size() > 50) {
            calculationRepository.delete(allCalculations.get(0));
        }
    }

    public List<Calculation> getCalculationHistory() {
        return calculationRepository.findAll();
    }
}
