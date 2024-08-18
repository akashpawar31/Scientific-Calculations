
# Scientific Calculator Spring Boot Application

This Spring Boot application provides a scientific calculator with advanced mathematical operations, complex number calculations, statistical functions, and calculation history management.

## Setup

1. Clone the repository
2. Configure the MySQL database in `src/main/resources/application.properties`
3. Run the application using `mvn spring-boot:run` or by executing the JAR file

## API Endpoints

### Basic Operations
- GET /api/calculator/sin?x=45
- GET /api/calculator/cos?x=10
- GET /api/calculator/tan?x=30
- GET /api/calculator/log?x=40
- GET /api/calculator/ln?x={value}
- GET /api/calculator/exp?x={value}
- GET /api/calculator/power?base={value}&exponent={value}

### Complex Number Operations
- GET /api/calculator/complex/add?real1={value}&imag1={value}&real2={value}&imag2={value}
- GET /api/calculator/complex/subtract?real1={value}&imag1={value}&
