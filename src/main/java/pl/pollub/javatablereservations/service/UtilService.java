package pl.pollub.javatablereservations.service;

import org.springframework.stereotype.Service;
import pl.pollub.javatablereservations.dto.ConvertDoubleOutputDTO;
import pl.pollub.javatablereservations.dto.ConvertInputDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UtilService {

    public ConvertDoubleOutputDTO convertStringToDouble(ConvertInputDTO convertInputDTO) {
        List<Double> doubleList = convertInputDTO.getStringList()
                .stream()
                .map( Double::parseDouble )
                .toList();

        return new ConvertDoubleOutputDTO(doubleList);
    }

}
