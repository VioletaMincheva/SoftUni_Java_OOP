package ExceptionsAndErrorHandling.EnterNumbers_lab3;

public class EnterNumbers {
    private int startNumber;
    private int endNumber;

    public EnterNumbers(int startNumber, int endNumber) {
        this.setStartNumber(startNumber, endNumber);
        this.setEndNumber(endNumber, startNumber);
    }

    public void setStartNumber(int startNumber, int endNumber) {
        if (startNumber < 1 || startNumber > endNumber || startNumber > 100) {
            throw new IllegalArgumentException("Start number should be more than 1, less than 100 and less than end number.");
        } else {
            this.startNumber = startNumber;
        }
    }

    public void setEndNumber(int endNumber, int startNumber) {
        if (endNumber < 1 || startNumber > endNumber || endNumber > 100) {
            throw new IllegalArgumentException("End number should be more than 1, less than 100 and more than start number.");
        } else {
            this.endNumber = endNumber;
        }
    }
}
