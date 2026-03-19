package session09MiniProject.smartsim.traffic;

public interface TrafficLightObserver {
    void onLightChanged(TrafficLightState newState);
}
