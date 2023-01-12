import java.util.List;

public class Smartphone implements Browsable, Callable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    public List<String> getNumbers() {
        return numbers;
    }

    public List<String> getUrls() {
        return urls;
    }

    @Override
    public String browse() {
        StringBuilder browseOutput = new StringBuilder();
        for (String currentUrl : this.urls) {
            if (currentUrl.matches("\\D+")) {
                browseOutput
                        .append("Browsing: " + currentUrl + "!")
                        .append(System.lineSeparator());
            } else {
                browseOutput.append("Invalid URL!").append(System.lineSeparator());
            }
        }
        return browseOutput.toString().trim();
    }
    @Override
    public String call() {
        StringBuilder callOutput = new StringBuilder();
        for (String currentNumber : this.numbers) {
            if (currentNumber.matches("\\d+")) {
                callOutput
                        .append("Calling... " + currentNumber)
                        .append(System.lineSeparator());
            } else {
                callOutput.append("Invalid number!").append(System.lineSeparator());
            }
        }
        return callOutput.toString().trim();
    }
}
