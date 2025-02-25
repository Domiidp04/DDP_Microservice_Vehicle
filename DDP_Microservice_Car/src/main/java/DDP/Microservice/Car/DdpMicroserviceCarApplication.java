package DDP.Microservice.Car;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DdpMicroserviceCarApplication {

	public static void main(String[] args) {
		SpringApplication.run(DdpMicroserviceCarApplication.class, args);
	}

}
