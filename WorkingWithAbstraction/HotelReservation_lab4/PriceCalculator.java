package JavaOOP.WorkingWithAbstraction.HotelReservation_lab4;

public class PriceCalculator {
    private double pricePerDay;
    private int numberOfDays;
    private Season season;
    private DiscountType discountType;

    public PriceCalculator(double pricePerDay, int numberOfDays, Season season, DiscountType discountType) {
        this.pricePerDay = pricePerDay;
        this.numberOfDays = numberOfDays;
        this.season = season;
        this.discountType = discountType;
    }

    public double calculate() {
       return  (pricePerDay * numberOfDays * season.getValue())
                * (1 - (discountType.getValue() / 100.00));
    }

}
