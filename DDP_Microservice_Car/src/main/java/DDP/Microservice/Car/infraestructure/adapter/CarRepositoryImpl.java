package DDP.Microservice.Car.infraestructure.adapter;

import DDP.Microservice.Car.application.repositories.CarRepository;
import DDP.Microservice.Car.domain.dto.CarDto;
import DDP.Microservice.Car.domain.models.CarModel;
import DDP.Microservice.Car.infraestructure.repositories.CarJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class CarRepositoryImpl implements CarRepository {

    private final CarJpaRepository carJpaRepository;

    @Override
    public List<CarDto> getAll() {
        return carJpaRepository.findAll().stream().map(CarDto::new).collect(Collectors.toList());
    }

    @Override
    public Optional<CarDto> getById(Long id) {
        return carJpaRepository.findById(id).map(CarDto::new);
    }

    @Override
    public CarDto save(CarDto car) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
