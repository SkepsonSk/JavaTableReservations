package pl.pollub.javatablereservations.service;

import org.springframework.stereotype.Service;
import pl.pollub.javatablereservations.functionalInterface.MathCalculation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MathService {

    private static final Map<String, MathCalculation> CALCULATION_MAP_BY_NAME = new HashMap<>();
    static {
        CALCULATION_MAP_BY_NAME.put("sum", (List<Double> params) -> params.stream().mapToDouble(Double::doubleValue).sum());
    }

    public double calculate(String calculationName, List<Double> params) {
        return CALCULATION_MAP_BY_NAME.get(calculationName).calculate(params);
    }

}
