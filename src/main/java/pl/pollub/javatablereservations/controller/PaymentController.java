package pl.pollub.javatablereservations.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pollub.javatablereservations.dependencyInversion.implementationClasses.CreditPaymentService;
import pl.pollub.javatablereservations.dependencyInversion.interfaces.PaymentService;
import pl.pollub.javatablereservations.dto.PaymentDTO;

@RestController
@RequestMapping(value = "/payment")
public class PaymentController {

    @PostMapping(value = "/process/credit")
    public void processPayment(@RequestBody PaymentDTO paymentDTO) {
        PaymentService paymentService = new CreditPaymentService();
        paymentService.processPayment(paymentDTO.getAmount());
    }

}
