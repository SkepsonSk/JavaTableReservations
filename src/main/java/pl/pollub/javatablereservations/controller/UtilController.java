package pl.pollub.javatablereservations.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pollub.javatablereservations.dto.ConvertDoubleOutputDTO;
import pl.pollub.javatablereservations.dto.ConvertInputDTO;
import pl.pollub.javatablereservations.service.UtilService;

@RestController
@RequestMapping(value = "/util")
public class UtilController {

    private final UtilService utilService;

    @Autowired
    public UtilController(UtilService utilService) {
        this.utilService = utilService;
    }

    @PostMapping(value = "/convert/string/double")
    public ConvertDoubleOutputDTO getUsers(@RequestBody ConvertInputDTO input) {
        return this.utilService.convertStringToDouble(input);
    }


}
