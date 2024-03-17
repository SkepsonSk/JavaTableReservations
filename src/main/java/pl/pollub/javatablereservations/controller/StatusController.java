package pl.pollub.javatablereservations.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pollub.javatablereservations.entity.Status;
import pl.pollub.javatablereservations.service.StatusService;

import java.util.List;

@RestController
@RequestMapping(value = "/")
public class StatusController {

    private final StatusService statusService;

    @Autowired
    public StatusController(
            StatusService statusService
    ) {
        this.statusService = statusService;
    }

    @GetMapping
    public List<Status> getStatusList() {
        return this.statusService.getAllStatusList();
    }

}
