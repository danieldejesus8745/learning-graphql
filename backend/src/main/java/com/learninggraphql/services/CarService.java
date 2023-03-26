package com.learninggraphql.services;

import com.learninggraphql.CarMapper;
import com.learninggraphql.dto.CarDTO;
import com.learninggraphql.entities.Car;
import com.learninggraphql.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

import static com.learninggraphql.utils.Messages.MESSAGE_2;


@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;
    private final CarMapper carMapper;

    public void addCar(CarDTO carDTO) {
        preventDuplicity(carDTO.getName());
        carRepository.save(carMapper.fromDTO(carDTO));
    }

    public List<CarDTO> findAllCars() {
        return carMapper.toListDTO(carRepository.findAll());
    }

    private void preventDuplicity(String carName) {
        Car car = carRepository.findByName(carName).orElse(null);
        if (Objects.nonNull(car)) throw new IllegalStateException(MESSAGE_2.getMessage());
    }

}
