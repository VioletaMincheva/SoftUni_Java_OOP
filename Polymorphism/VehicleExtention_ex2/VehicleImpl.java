package Polymorphism.VehicleExtention_ex2;

public abstract class VehicleImpl {
    private double fuelQuantity;
    private double fuelConsumptionInLittersPerKm;
    private double tankCapacity;

    public VehicleImpl(double fuelQuantity, double fuelConsumptionInLittersPerKm, double tankCapacity) {
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumptionInLittersPerKm(fuelConsumptionInLittersPerKm);
        this.setTankCapacity(tankCapacity);
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public double getFuelConsumptionInLittersPerKm() {
        return fuelConsumptionInLittersPerKm;
    }

    public void setFuelConsumptionInLittersPerKm(double fuelConsumptionInLittersPerKm) {
        this.fuelConsumptionInLittersPerKm = fuelConsumptionInLittersPerKm;
    }

    public double getTankCapacity() {
        return tankCapacity;
    }

    public void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    public abstract void driving(double distance, double additionalCost);

    public abstract void refueling(double littersForFueling);

    @Override
    public String toString() {
        return String.format("%s: %.2f", getClass().getSimpleName(), getFuelQuantity());
    }
}
