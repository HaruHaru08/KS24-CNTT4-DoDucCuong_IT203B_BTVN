package session09MiniProject.smartsim.traffic;

import session09MiniProject.smartsim.util.LogUtil;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class TrafficLight implements Runnable {
    // List of observers
    private final List<TrafficLightObserver> observers = new CopyOnWriteArrayList<>();
    
    // Current state
    private volatile TrafficLightState currentState;
    
    private volatile boolean active = true;

    public TrafficLight() {
        // Initial state is Green
        this.currentState = new GreenState(this);
    }
    
    // Register/Unregister
    public void registerObserver(TrafficLightObserver observer) {
        observers.add(observer);
    }
    
    public void unregisterObserver(TrafficLightObserver observer) {
        observers.remove(observer);
    }
    
    public TrafficLightState getCurrentState() {
        return currentState;
    }
    
    public void stop() {
        active = false;
    }

    @Override
    public void run() {
        while (active) {
            // Log the change
            LogUtil.log("Đèn chuyển sang %s", currentState.getName());
            
            // Notify observers about state change
            for (TrafficLightObserver observer : observers) {
                observer.onLightChanged(currentState);
            }
            
            // Sleep for duration of current state
            try {
                Thread.sleep(currentState.getDurationMillis());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
            
            // Move to next state
            currentState = currentState.next();
        }
    }
}
