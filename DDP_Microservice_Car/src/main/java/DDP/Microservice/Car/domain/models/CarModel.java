package DDP.Microservice.Car.domain.models;

import DDP.Microservice.Car.domain.dto.CarDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "car")
public class CarModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Brand cannot be null")
    @Size(max = 100, message = "Brand must be less than 100 characters")
    private String brand;

    @NotNull(message = "Model cannot be null")
    @Size(max = 100, message = "Model must be less than 100 characters")
    private String model;

    @NotNull(message = "Origin cannot be null")
    @Size(max = 255, message = "Origin must be less than 255 characters")
    private String origin;

    @NotNull(message = "Destination cannot be null")
    @Size(max = 255, message = "Destination must be less than 255 characters")
    private String destination;

    @Column(name = "estimated_time")
    @Min(value = 0, message = "Estimated time must be a positive number")
    private Long estimatedTime;

    @NotNull(message = "License plate cannot be null")
    @Size(min = 7, max = 7, message = "License plate must be exactly 7 characters")
    @Pattern(regexp = "^[0-9]{4}[A-Za-z]{3}$", message = "License plate must be in the format 1234ABC")
    @Column(name = "license_plate")
    private String licensePlate;

    @Column(name = "created_at")
    private LocalDateTime createAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public CarModel(CarDto car) {
        this.brand = car.getBrand();
        this.model = car.getModel();
        this.origin = car.getOrigin();
        this.destination = car.getDestination();
        this.estimatedTime = car.getEstimatedTime();
        this.licensePlate = car.getLicensePlate();
    }
}
