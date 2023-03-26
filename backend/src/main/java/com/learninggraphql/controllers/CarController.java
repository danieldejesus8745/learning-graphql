package com.learninggraphql.controllers;

import com.learninggraphql.dto.CarDTO;
import com.learninggraphql.services.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

import static com.learninggraphql.utils.Messages.MESSAGE_1;
import static com.learninggraphql.utils.Messages.MESSAGE_2;

@Controller
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @MutationMapping
    public ResponseEntity<String> addCar(@Argument CarDTO carDTO) {
        try {
            carService.addCar(carDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(MESSAGE_1.getMessage());
        } catch (IllegalStateException exception) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(MESSAGE_2.getMessage());
        }
    }

    @QueryMapping
    public List<CarDTO> findAllCars() {
        return carService.findAllCars();
    }

}
