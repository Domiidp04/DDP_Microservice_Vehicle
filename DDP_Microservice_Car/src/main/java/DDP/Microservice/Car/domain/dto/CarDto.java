package DDP.Microservice.Car.domain.dto;

import DDP.Microservice.Car.domain.models.CarModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CarDto {

    private String brand;

    private String model;

    private String origin;

    private String destination;

    private Long estimatedTime;

    private String licensePlate;

    public CarDto(CarModel carModel) {
        this.brand = carModel.getBrand();
        this.model = carModel.getModel();
        this.origin = carModel.getOrigin();
        this.destination = carModel.getDestination();
        this.setEstimatedTime(carModel.getEstimatedTime());
        this.licensePlate = carModel.getLicensePlate();
    }
}
