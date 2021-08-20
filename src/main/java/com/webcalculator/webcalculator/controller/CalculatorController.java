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
        return "calculator";
    }

    @GetMapping("/home")
    public String homePage() {
        return "home";
    }
    @GetMapping("/about")
    public String about() {
        return "about";
    }
    @GetMapping("/features")
    public String features() {
        return "features";
    }

    @PostMapping
    public String newCalc(@ModelAttribute(name = "expression")Expression expression, Map<String,Object> map){
        ScriptEngineManager factory =  new ScriptEngineManager();
        ScriptEngine engine = factory.getEngineByName("JavaScript");

        String expr = expression.getExpr();

        try{
            map.put("answer", engine.eval(expr));
        } catch (ScriptException e){
            map.put("answer","<mark>"+e.getMessage()+"</mark>");
        }
        return "calculator";
    }
}
