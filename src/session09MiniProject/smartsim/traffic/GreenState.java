package session09MiniProject.smartsim.traffic;

public class GreenState implements TrafficLightState {
    private final TrafficLight trafficLight; // Reference to the context

    public GreenState(TrafficLight trafficLight) {
        this.trafficLight = trafficLight;
    }

    @Override
    public String getName() {
        return "GREEN";
    }

    @Override
    public long getDurationMillis() {
        return 5000; // Example duration
    }

    @Override
    public TrafficLightState next() {
        return new YellowState(trafficLight);
    }
}
