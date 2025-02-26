package DDP.Microservice.Car.infraestructure.repositories;

import DDP.Microservice.Car.domain.models.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarJpaRepository extends JpaRepository<CarModel, Long> {
    Optional<CarModel> findByLicensePlate(String licensePlate);
}
