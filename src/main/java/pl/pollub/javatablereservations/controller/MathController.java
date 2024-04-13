package pl.pollub.javatablereservations.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pollub.javatablereservations.interpreter.NumberExpression;

import java.util.Optional;

@RestController
@RequestMapping(value = "/")
public class MathController {

    @GetMapping(value = "math")
    public ResponseEntity<Double> login(@RequestParam("expression") String expression) {
        return ResponseEntity.of(Optional.of(new NumberExpression().interpret(expression)));
    }

}
