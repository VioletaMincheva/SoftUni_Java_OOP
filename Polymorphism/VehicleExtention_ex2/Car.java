package Polymorphism.VehicleExtention_ex2;

public class Car extends VehicleImpl {

    public Car(double fuelQuantity, double fuelConsumptionInLittersPerKm, double tankCapacity) {
        super(fuelQuantity, fuelConsumptionInLittersPerKm, tankCapacity);
    }

    @Override
    public void driving(double distance, double additionalCost) {
        double fuelCost =
                distance * (getFuelConsumptionInLittersPerKm() + additionalCost);
        if (fuelCost <= getFuelQuantity()) {
            super.setFuelQuantity(getFuelQuantity() - fuelCost);
            System.out.printf("Car travelled %.2f km%n", distance);
        } else {
            System.out.println("Car needs refueling");
        }
    }

    @Override
    public void refueling(double littersForFueling) {
        if (littersForFueling <= 0) {
            System.out.println("Fuel must be a positive number");
        } else {
            if (littersForFueling + super.getFuelQuantity() > super.getTankCapacity()) {
                System.out.println("Cannot fit fuel in tank");
            } else {
                super.setFuelQuantity(getFuelQuantity() + littersForFueling);
            }
        }
    }

}
