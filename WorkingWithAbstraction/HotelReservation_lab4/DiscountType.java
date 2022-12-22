package JavaOOP.WorkingWithAbstraction.HotelReservation_lab4;

public enum DiscountType {
    VIP(20),
    SECOND_VISIT(10),
    NONE(0);

    private int value;

    DiscountType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
