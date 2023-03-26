package com.learninggraphql.controllers;

import com.learninggraphql.services.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/v1/cars")
public class CarController {

    private final CarService carService;

}
