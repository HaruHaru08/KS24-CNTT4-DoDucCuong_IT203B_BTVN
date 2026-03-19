package session09MiniProject.smartsim.traffic;

public class YellowState implements TrafficLightState {
    private final TrafficLight trafficLight;

    public YellowState(TrafficLight trafficLight) {
        this.trafficLight = trafficLight;
    }

    @Override
    public String getName() {
        return "YELLOW";
    }

    @Override
    public long getDurationMillis() {
        return 2000;
    }

    @Override
    public TrafficLightState next() {
        return new RedState(trafficLight);
    }
}
