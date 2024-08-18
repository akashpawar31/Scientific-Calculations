//package com.example.scientific_calculator_spring.config;
//
//
//
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.sql.DataSource;
//
//@Configuration
//public class DataConfig {
//
//    @Bean
//    public DataSource dataSource() {
//        return DataSourceBuilder
//            .create()
//            .url("jdbc:mysql://localhost:3306/scientific_calculator")
//            .username("root")
//            .password("root")
//            .driverClassName("com.mysql.cj.jdbc.Driver")
//            .build();
//    }
//}
