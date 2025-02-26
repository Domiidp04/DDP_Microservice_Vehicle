package DDP.Microservice.Car.infraestructure.adapter;

import DDP.Microservice.Car.application.repositories.CarRepository;
import DDP.Microservice.Car.domain.dto.CarDto;
import DDP.Microservice.Car.domain.models.CarModel;
import DDP.Microservice.Car.infraestructure.repositories.CarJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
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
        return new CarDto(carJpaRepository.save(new CarModel(car)));
    }

    @Override
    public CarDto update(Long id, CarDto carDto) {
        CarModel carModel = carJpaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Car not found"));

        BeanUtils.copyProperties(carDto, carModel, getNullPropertyNames(carDto));

        carModel.setUpdatedAt(LocalDateTime.now());

        return new CarDto(carJpaRepository.save(carModel));
    }

    @Override
    public Optional<CarDto> getByLicensePlate(String licensePlate) {
        return carJpaRepository.findByLicensePlate(licensePlate).map(CarDto::new);
    }

    @Override
    public void delete(Long id) {
        carJpaRepository.deleteById(id);
    }


    private String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<>();
        for (java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) {
                emptyNames.add(pd.getName());
            }
        }
        return emptyNames.toArray(new String[0]);
    }
}
