package session09MiniProject.smartsim.model;

import session09MiniProject.smartsim.engine.Intersection;
import session09MiniProject.smartsim.traffic.TrafficLight;
import session09MiniProject.smartsim.util.LogUtil;

public class StandardVehicle extends Vehicle {
    private final Intersection intersection;
    private final TrafficLight trafficLight;

    public StandardVehicle(VehicleType type, int speed, Intersection intersection, TrafficLight trafficLight) {
        super(type, speed, false);
        this.intersection = intersection;
        this.trafficLight = trafficLight;
    }

    @Override
    public void driveToIntersection() throws InterruptedException {
        LogUtil.log("%s is driving to intersection.", getName());
        intersection.enterQueue(this);
    }

    @Override
    public void crossIntersection() throws InterruptedException {
        intersection.awaitGreenAndCross(this);
    }
}
