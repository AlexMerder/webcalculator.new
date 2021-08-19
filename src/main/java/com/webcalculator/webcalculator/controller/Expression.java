package com.webcalculator.webcalculator.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;


@Component
public class Expression {

    @Getter @Setter
    private String expr;
}
