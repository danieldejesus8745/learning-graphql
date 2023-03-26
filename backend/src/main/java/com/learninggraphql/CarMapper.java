package com.learninggraphql;

import com.learninggraphql.dto.CarDTO;
import com.learninggraphql.entities.Car;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarMapper {

    public Car fromDTO(CarDTO carDTO) {
        Car car = new Car();
        car.setName(carDTO.getName());
        car.setManufacturer(carDTO.getManufacturer());

        return car;
    }

    public CarDTO toDTO(Car car) {
        CarDTO carDTO = new CarDTO();
        carDTO.setId(car.getId());
        carDTO.setName(car.getName());
        carDTO.setManufacturer(car.getManufacturer());

        return carDTO;
    }

    public List<CarDTO> toListDTO(List<Car> carsList) {
        return carsList.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

}
