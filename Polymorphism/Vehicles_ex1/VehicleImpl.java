package Polymorphism.Vehicles_ex1;

public abstract class VehicleImpl {
    private double fuelQuantity;
    private double fuelConsumptionInLittersPerKm;

    protected VehicleImpl(double fuelQuantity, double fuelConsumptionInLittersPerKm) {
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumptionInLittersPerKm(fuelConsumptionInLittersPerKm);
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    protected void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public double getFuelConsumptionInLittersPerKm() {
        return fuelConsumptionInLittersPerKm;
    }

    protected void setFuelConsumptionInLittersPerKm(double fuelConsumptionInLittersPerKm) {
        this.fuelConsumptionInLittersPerKm = fuelConsumptionInLittersPerKm;
    }

    public abstract void driving(double distance);

    public abstract void refueling(double littersForFueling);

}
