package pl.pollub.javatablereservations.dto;


import java.util.List;

public class ConvertDoubleOutputDTO {

    private final List<Double> doubleList;

    public ConvertDoubleOutputDTO(List<Double> doubleList) {
        this.doubleList = doubleList;
    }

    public List<Double> getDoubleList() {
        return doubleList;
    }
}
