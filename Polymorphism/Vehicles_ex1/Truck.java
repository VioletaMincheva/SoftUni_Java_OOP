package Polymorphism.Vehicles_ex1;

import java.text.DecimalFormat;

public class Truck extends VehicleImpl {
    public Truck(double fuelQuantity, double fuelConsumptionInLittersPerKm) {
        super(fuelQuantity, fuelConsumptionInLittersPerKm);
    }

    public void driving(double distance) {
        double additionalConsumptionInSummer = 1.6;
        double fuelCost = distance * (getFuelConsumptionInLittersPerKm() + additionalConsumptionInSummer);
        if (fuelCost <= getFuelQuantity()) {
            super.setFuelQuantity(getFuelQuantity() - fuelCost);
            System.out.printf("Truck travelled %.2f km%n", distance);
        } else {
            System.out.println("Truck needs refueling");
        }
    }

    @Override
    public void refueling(double littersForFueling) {
        double fuelForRefuel = littersForFueling * 0.95;
        super.setFuelQuantity(getFuelQuantity() + fuelForRefuel);
    }

    @Override
    public String toString() {
        return String.format("Truck: %.2f", super.getFuelQuantity());
    }

}
