package Polymorphism.VehicleExtention_ex2;

public class Truck extends VehicleImpl {

    public Truck(double fuelQuantity, double fuelConsumptionInLittersPerKm, double tankCapacity) {
        super(fuelQuantity, fuelConsumptionInLittersPerKm, tankCapacity);
    }

    public void driving(double distance, double additionalCost) {
        double fuelCost = distance * (super.getFuelConsumptionInLittersPerKm() + additionalCost);
        if (fuelCost <= getFuelQuantity()) {
            super.setFuelQuantity(super.getFuelQuantity() - fuelCost);
            System.out.printf("Truck travelled %.2f km%n", distance);
        } else {
            System.out.println("Truck needs refueling");
        }
    }

    @Override
    public void refueling(double littersForFueling) {
        if (littersForFueling <= 0) {
            System.out.println("Fuel must be a positive number");
        } else {
            double fuelForRefuel = littersForFueling * 0.95;
            if (fuelForRefuel + super.getFuelQuantity() > super.getTankCapacity()) {
                System.out.println("Cannot fit fuel in tank");
            } else {
                super.setFuelQuantity(getFuelQuantity() + fuelForRefuel);
            }
        }
    }

}
