package session09MiniProject.smartsim.model;

import session09MiniProject.smartsim.traffic.TrafficLightObserver;
import session09MiniProject.smartsim.traffic.TrafficLightState;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class Vehicle implements Runnable {
    // TrafficLightObserver is not strictly necessary here if Intersection handles logic
    // But let's see implementation.
    // The previous implementation had it.
    
    private static final AtomicInteger ID_GENERATOR = new AtomicInteger(1);
    
    protected final int id;
    protected final VehicleType type;
    protected final int speedMillis;
    protected final boolean priority;
    protected final String name;

    public Vehicle(VehicleType type, int speedMillis, boolean priority) {
        this.id = ID_GENERATOR.getAndIncrement();
        this.type = type;
        this.speedMillis = speedMillis;
        this.priority = priority;
        this.name = String.format("%s#%02d", type.name(), id);
    }
    
    // Abstract methods should be public or protected
    public abstract void driveToIntersection() throws InterruptedException;
    public abstract void crossIntersection() throws InterruptedException;
    
    // Getters
    public int getId() { return id; }
    public VehicleType getType() { return type; }
    public int getSpeedMillis() { return speedMillis; }
    public boolean isPriority() { return priority; }
    public String getName() { return name; }
    
    @Override
    public String toString() {
        return name + (priority ? " (Priority)" : "");
    }
    
    // run method
    @Override
    public void run() {
        try {
            driveToIntersection();
            crossIntersection();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
