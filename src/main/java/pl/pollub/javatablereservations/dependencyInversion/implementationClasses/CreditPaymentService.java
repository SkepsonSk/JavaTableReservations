package pl.pollub.javatablereservations.dependencyInversion.implementationClasses;
import pl.pollub.javatablereservations.dependencyInversion.abstractClasses.BasePaymentService;

public class CreditPaymentService extends BasePaymentService {
    @Override
    public void processPayment(double amount) {
        System.out.println("Payment processed through credit.");
    }
}