package DDP.Microservice.Car.infraestructure.repositories;

import DDP.Microservice.Car.domain.models.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarJpaRepository extends JpaRepository<CarModel, Long> {
}
