package ExceptionsAndErrorHandling.SquareRoot_lab2_2;

public class SquareRoot {
        private int number;

        public SquareRoot(int number) {
            this.number = number;
        }

        public double sqrt(double number) {
            if (number < 0) {
                throw new IllegalArgumentException("Sqrt for negative numbers is undefined!");
            }

            return Math.sqrt(number);
        }
    }
