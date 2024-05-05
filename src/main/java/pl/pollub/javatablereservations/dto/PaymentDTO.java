package pl.pollub.javatablereservations.dto;

public class PaymentDTO {

    private final double amount;

    public PaymentDTO(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}
