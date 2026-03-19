package session09MiniProject.smartsim.model;

import session09MiniProject.smartsim.engine.Intersection;
import session09MiniProject.smartsim.traffic.TrafficLight;
import session09MiniProject.smartsim.util.LogUtil;

public class PriorityVehicle extends Vehicle {
    private final Intersection intersection;
    private final TrafficLight trafficLight;

    public PriorityVehicle(VehicleType type, int speed, Intersection intersection, TrafficLight trafficLight) {
        super(type, speed, true);
        this.intersection = intersection;
        this.trafficLight = trafficLight;
    }

    @Override
    public void driveToIntersection() throws InterruptedException {
        LogUtil.log("%s (Priority) is rushing to intersection!", getName());
        intersection.enterQueue(this);
    }

    @Override
    public void crossIntersection() throws InterruptedException {
        // Priority vehicles can cross even on red light if safe (logic handled in Intersection)
        intersection.awaitGreenAndCross(this);
    }
}
