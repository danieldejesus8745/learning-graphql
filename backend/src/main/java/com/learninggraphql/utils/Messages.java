package com.learninggraphql.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Messages {

    MESSAGE_1("Carro adicionado com sucesso"),
    MESSAGE_2("Carro já adicionado anteriormente");

    private final String message;

}
