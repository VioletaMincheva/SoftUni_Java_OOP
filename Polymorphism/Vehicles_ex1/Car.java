package Polymorphism.Vehicles_ex1;

import java.text.DecimalFormat;

public class Car extends VehicleImpl {

    public Car(double fuelQuantity, double fuelConsumptionInLittersPerKm) {
        super(fuelQuantity, fuelConsumptionInLittersPerKm);
    }

    @Override
    public void driving(double distance) {
        double additionalConsumptionInSummer = 0.9;
        double fuelCost =
                distance * (getFuelConsumptionInLittersPerKm() + additionalConsumptionInSummer);
        if (fuelCost <= getFuelQuantity()) {
            super.setFuelQuantity(getFuelQuantity() - fuelCost);
            System.out.printf("Car travelled %.2f km%n", distance);
        } else {
            System.out.println("Car needs refueling");
        }
    }

    @Override
    public void refueling(double littersForFueling) {
        super.setFuelQuantity(getFuelQuantity() + littersForFueling);
    }

    @Override
    public String toString() {
        return String.format("Car: %.2f", super.getFuelQuantity());
    }
}
