package DDP.Microservice.Car.application.repositories;

import DDP.Microservice.Car.domain.dto.CarDto;

import java.util.List;
import java.util.Optional;

public interface CarRepository {

    List<CarDto> getAll();

    Optional<CarDto> getById(Long id);

    CarDto save(CarDto car);

    CarDto update(Long id, CarDto car);

    Optional<CarDto> getByLicensePlate(String licensePlate);

    void delete(Long id);
}
