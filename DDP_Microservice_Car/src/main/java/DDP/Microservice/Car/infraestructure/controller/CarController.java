package DDP.Microservice.Car.infraestructure.controller;

import DDP.Microservice.Car.application.services.CarService;
import DDP.Microservice.Car.domain.dto.CarDto;
import DDP.Microservice.Car.domain.models.CarModel;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/car")
@AllArgsConstructor
public class CarController {

    private final CarService carService;

    @GetMapping
    public ResponseEntity<List<CarDto>> getAll(){
        return ResponseEntity.ok(carService.getAll());
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello World";
    }
}
