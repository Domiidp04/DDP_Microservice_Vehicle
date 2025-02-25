package DDP.Microservice.Car.application.repositories;

import DDP.Microservice.Car.domain.dto.CarDto;
import DDP.Microservice.Car.domain.models.CarModel;

import java.util.List;
import java.util.Optional;

public interface CarRepository {

    List<CarDto> getAll();
    Optional<CarDto> getById(Long id);
    CarDto save(CarDto car);
    void delete(Long id);
}
