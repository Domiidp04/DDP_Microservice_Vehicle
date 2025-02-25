package DDP.Microservice.Car.domain.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

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

    @NotNull
    @Max(100)
    private String brand;

    @NotNull
    @Max(100)
    private String model;

    @NotNull
    private String origin;

    @NotNull
    private String destination;

    @Column(name = "estimated_time")
    private Long estimatedTime;

    @Min(7)
    @Max(7)
    @UniqueElements
    @NotNull
    @Column(name = "license_plate")
    private String licensePlate;

    @NotNull
    @Column(name = "created_at")
    private LocalDateTime createAt;

    @NotNull
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}
