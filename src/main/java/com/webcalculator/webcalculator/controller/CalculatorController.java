package com.webcalculator.webcalculator.controller;


import com.webcalculator.webcalculator.entity.Expression;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Map;

@Controller
@RequestMapping("/calculator")
public class CalculatorController {

    @Getter
    private final Expression expression;

    public CalculatorController(Expression expression) {
        this.expression = expression;
    }


    @GetMapping
    public String greetingForm(Model model) {
        model.addAttribute(("expression"), new Expression());
        return "operation";
    }

    @PostMapping
    public String greetingSubmit(@ModelAttribute(name = "expression") Expression expression, Map<String, Object> map) {

        System.out.println(expression.getExpr());
        ScriptEngineManager factory = new ScriptEngineManager();
        ScriptEngine engine = factory.getEngineByName("JavaScript");

        String result = expression.getExpr();

        try{
            map.put("answer", engine.eval(result));
        } catch (ScriptException e){
            map.put("answer","<mark>"+e.getMessage()+"</mark>");
        }
        return "operation";
    }
    @GetMapping("/home")
    public String homePage() {
        return "home";
    }



}
