package DDP.Microservice.Car.application.services;

import DDP.Microservice.Car.application.repositories.CarRepository;
import DDP.Microservice.Car.domain.dto.CarDto;
import DDP.Microservice.Car.domain.models.CarModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@AllArgsConstructor
@Service
public class CarService {

    private final CarRepository carRepository;

    public List<CarDto> getAll() {
        return carRepository.getAll();
    }

    public Optional<CarDto> getById(Long id) {
        return carRepository.getById(id);
    }

    public CarDto save(CarDto car) {
        return carRepository.save(car);
    }

    public void delete(Long id) {
        carRepository.delete(id);
    }
}
