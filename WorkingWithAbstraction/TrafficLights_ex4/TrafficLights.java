package JavaOOP.WorkingWithAbstraction.TrafficLights_ex4;

public class TrafficLights {
    private TrafficLightsSignals signal;

    public TrafficLights(TrafficLightsSignals signal) {
        this.signal = signal;
    }

    public TrafficLightsSignals getSignal() {
        return signal;
    }

    public void updated() {
        switch (signal){
            case RED:
                this.signal = TrafficLightsSignals.GREEN;
                break;
            case GREEN:
                this.signal = TrafficLightsSignals.YELLOW;
                break;
            case YELLOW:
                this.signal = TrafficLightsSignals.RED;
                break;
        }
    }

    @Override
    public String toString() {
        return signal.toString();
    }
}
