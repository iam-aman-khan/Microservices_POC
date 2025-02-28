# Microservices_POC
This project implements a Microservices Architecture using Spring Boot, Spring Cloud Gateway, and Eureka Server for service discovery. The system consists of multiple services working together to generate numbers, filter prime numbers, and check for happy numbers, all orchestrated through a central Orchestrator Service.

Architecture & Flow
-------------------
Services Involved

1. API Gateway (Port: 8080)
   Routes all requests to the Orchestrator Service.
   Uses Spring Cloud Gateway for load balancing and routing.

2. Orchestrator Service (Port: 8083)
   Central service handling requests.
   Calls Number Service, Prime Service, and Happy Number Service using Feign Clients.
   Filters numbers based on conditions (Prime, Happy, etc.).

3. Number Service (Port: 8081)
   Generates a list of numbers in a given range.

4. Prime Service (Port: 8082)
   Checks if a number is prime.

5. Happy Number Service (Port: 8084)
   Checks if a number is a Happy Number.

6. Eureka Server (Port:8761)
   Eureka Server acts as the service registry
   Allows all microservices to register and discover each other dynamically.


Start services in the following order:
--------------------------------------

1. Eureka Server
2. API Gateway (api-gateway)
3. Orchestrator Service (orchestrator-service)
4. Number Service (number-service)
5. Prime Service (prime-service)
6. Happy Number Service (happy-number-service)


API Endpoints & Usage
----------------------
1. API Gateway (localhost:8080)
   All requests pass through API Gateway, which forwards them to Orchestrator

2. Orchestrator Service (localhost:8083/orchestrator)

API Endpoint                        |    Description
                                    | 
GET /numbers?start=X&end=Y          |    Get numbers from X to Y  
GET /prime?start=X&end=Y            |    Get prime numbers in range
GET /happy?start=X&end=Y            |    Get happy numbers in range
GET /prime-happy?start=X&end=Y      |    Get numbers that are both prime & happy


3. Number Service (localhost:8081/numbers)

API Endpoint                        |    Description
                                    | 
GET /?start=X&end=Y                 |    Returns a list of numbers in range

4. Prime Service (localhost:8082/prime/{number})

API Endpoint                        |    Description
                                    | 
GET /{number}                       |    Returns true if the number is prime, else false


5. Happy Number Service (localhost:8084/happy/{number})

API Endpoint                        |    Description
                                    | 
GET /{number}                       |    Returns true if the number is a happy number, else false




Feign Clients (Inter-Service Communication)
---------------------------------------------
Orchestrator Service uses Feign Clients to communicate with other services.
Feign Clients make REST API calls to Number Service, Prime Service, and Happy Number Service dynamically via Eureka.
Example Feign Client for Prime Service : 

@FeignClient(name = "prime-service")
public interface PrimeClient {
    @GetMapping("/prime/{number}")
    boolean isPrime(@PathVariable int number);
}



   
