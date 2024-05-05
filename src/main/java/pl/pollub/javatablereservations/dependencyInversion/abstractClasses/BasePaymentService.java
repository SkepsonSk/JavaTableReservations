package pl.pollub.javatablereservations.dependencyInversion.abstractClasses;
import pl.pollub.javatablereservations.dependencyInversion.interfaces.PaymentService;

public abstract class BasePaymentService implements PaymentService {
    public abstract void processPayment(double amount);
}
