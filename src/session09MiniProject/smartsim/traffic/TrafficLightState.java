package session09MiniProject.smartsim.traffic;

public interface TrafficLightState {
    String getName();
    long getDurationMillis();
    TrafficLightState next();
}
