package pl.pollub.javatablereservations.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pollub.javatablereservations.interpreter.NumberExpression;
import pl.pollub.javatablereservations.service.MathService;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/")
public class MathController {

    private final MathService mathService;

    @Autowired
    public MathController(MathService mathService) {
        this.mathService = mathService;
    }

    @GetMapping(value = "math/calculate")
    public ResponseEntity<Double> calculate(@RequestParam("expression") String expression) {
        return ResponseEntity.of(Optional.of(new NumberExpression().interpret(expression)));
    }

    @GetMapping(value = "math/calculation/{type}")
    public ResponseEntity<Double> login(@PathVariable("type") String type, @RequestParam("params") String params) {
        List<Double> doubleParams = Arrays.stream(params.split(",")).map(Double::parseDouble).toList();
        return ResponseEntity.of(Optional.of(this.mathService.calculate(type, doubleParams)));
    }

}
