package com.webcalculator.webcalculator.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;


@Component
public class Expression {

    @Getter @Setter
    private String expr;
}
