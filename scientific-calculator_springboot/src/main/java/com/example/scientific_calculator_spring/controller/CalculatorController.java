package com.example.scientific_calculator_spring.controller;



import com.example.scientific_calculator_spring.model.Calculation;
import com.example.scientific_calculator_spring.model.ComplexNumber;
import com.example.scientific_calculator_spring.service.ScientificCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/calculator")
public class CalculatorController {

    @Autowired
    private ScientificCalculator calculator;

    @GetMapping("/sin")
    public ResponseEntity<Double> sin(@RequestParam double x) {
        return ResponseEntity.ok(calculator.sin(x));
    }

    @GetMapping("/cos")
    public ResponseEntity<Double> cos(@RequestParam double x) {
        return ResponseEntity.ok(calculator.cos(x));
    }

    @GetMapping("/tan")
    public ResponseEntity<Double> tan(@RequestParam double x) {
        return ResponseEntity.ok(calculator.tan(x));
    }

    @GetMapping("/log")
    public ResponseEntity<Double> log(@RequestParam double x) {
        return ResponseEntity.ok(calculator.log(x));
    }

    @GetMapping("/ln")
    public ResponseEntity<Double> ln(@RequestParam double x) {
        return ResponseEntity.ok(calculator.ln(x));
    }

    @GetMapping("/exp")
    public ResponseEntity<Double> exp(@RequestParam double x) {
        return ResponseEntity.ok(calculator.exp(x));
    }

    @GetMapping("/power")
    public ResponseEntity<Double> power(@RequestParam double base, @RequestParam double exponent) {
        return ResponseEntity.ok(calculator.power(base, exponent));
    }

    @GetMapping("/complex/add")
    public ResponseEntity<ComplexNumber> addComplex(
            @RequestParam double real1, @RequestParam double imag1,
            @RequestParam double real2, @RequestParam double imag2) {
        ComplexNumber a = new ComplexNumber(real1, imag1);
        ComplexNumber b = new ComplexNumber(real2, imag2);
        return ResponseEntity.ok(calculator.addComplex(a, b));
    }

    @GetMapping("/complex/subtract")
    public ResponseEntity<ComplexNumber> subtractComplex(
            @RequestParam double real1, @RequestParam double imag1,
            @RequestParam double real2, @RequestParam double imag2) {
        ComplexNumber a = new ComplexNumber(real1, imag1);
        ComplexNumber b = new ComplexNumber(real2, imag2);
        return ResponseEntity.ok(calculator.subtractComplex(a, b));
    }

    @GetMapping("/complex/multiply")
    public ResponseEntity<ComplexNumber> multiplyComplex(
            @RequestParam double real1, @RequestParam double imag1,
            @RequestParam double real2, @RequestParam double imag2) {
        ComplexNumber a = new ComplexNumber(real1, imag1);
        ComplexNumber b = new ComplexNumber(real2, imag2);
        return ResponseEntity.ok(calculator.multiplyComplex(a, b));
    }

    @GetMapping("/complex/divide")
    public ResponseEntity<ComplexNumber> divideComplex(
            @RequestParam double real1, @RequestParam double imag1,
            @RequestParam double real2, @RequestParam double imag2) {
        ComplexNumber a = new ComplexNumber(real1, imag1);
        ComplexNumber b = new ComplexNumber(real2, imag2);
        return ResponseEntity.ok(calculator.divideComplex(a, b));
    }

    @GetMapping("/mean")
    public ResponseEntity<Double> mean(@RequestParam double... numbers) {
        return ResponseEntity.ok(calculator.mean(numbers));
    }

    @GetMapping("/median")
    public ResponseEntity<Double> median(@RequestParam double... numbers) {
        return ResponseEntity.ok(calculator.median(numbers));
    }

    @GetMapping("/standardDeviation")
    public ResponseEntity<Double> standardDeviation(@RequestParam double... numbers) {
        return ResponseEntity.ok(calculator.standardDeviation(numbers));
    }

    @GetMapping("/history")
    public ResponseEntity<List<Calculation>> getHistory() {
        return ResponseEntity.ok(calculator.getCalculationHistory());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
