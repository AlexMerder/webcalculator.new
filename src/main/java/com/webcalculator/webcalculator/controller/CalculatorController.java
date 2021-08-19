package com.webcalculator.webcalculator.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping("/calculator")
public class CalculatorController {

    @GetMapping
    public String greetingForm(Model model) {
        model.addAttribute(("expression"), new Expression());
        return "operation";
    }

    @PostMapping
    public String greetingSubmit(@ModelAttribute(name = "expression") Expression expression, Map<String, Object> map) throws IOException, InterruptedException, ScriptException {

        System.out.println(expression.getExpr());
        ScriptEngineManager factory = new ScriptEngineManager();
        ScriptEngine engine = factory.getEngineByName("JavaScript");

        map.put("answer", engine.eval(expression.getExpr()));
        return "operation";
    }
    @GetMapping("/home")
    public String homePage(){
        return "home";
    }
}
