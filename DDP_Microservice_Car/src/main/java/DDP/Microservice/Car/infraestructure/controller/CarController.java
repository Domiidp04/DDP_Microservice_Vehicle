package DDP.Microservice.Car.infraestructure.controller;

import DDP.Microservice.Car.application.services.CarService;
import DDP.Microservice.Car.domain.dto.CarDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cars")
@AllArgsConstructor
public class CarController {

    private final CarService carService;

    @GetMapping
    public ResponseEntity<List<CarDto>> getAll() {
        return ResponseEntity.ok(carService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<CarDto>> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(carService.getById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<Optional<CarDto>> getByLicensePlate(@RequestParam(name = "licensePlate") String licensePlate) {
        return ResponseEntity.ok(carService.getByLicensePlate(licensePlate));
    }

    @PostMapping
    public ResponseEntity<CarDto> save(@RequestBody CarDto car) {
        return ResponseEntity.ok(carService.save(car));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CarDto> update(@PathVariable("id") Long id, @RequestBody CarDto car) {
        return ResponseEntity.ok(carService.update(id, car));
    }
}
