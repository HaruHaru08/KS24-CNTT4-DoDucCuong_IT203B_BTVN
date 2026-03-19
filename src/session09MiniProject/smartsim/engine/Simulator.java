package session09MiniProject.smartsim.engine;

import session09MiniProject.smartsim.factory.VehicleFactory;
import session09MiniProject.smartsim.model.Vehicle;
import session09MiniProject.smartsim.traffic.TrafficLight;
import session09MiniProject.smartsim.util.LogUtil;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Simulator {
    private final TrafficLight trafficLight;
    private final Intersection intersection;
    private final VehicleFactory factory;

    public Simulator() {
        this.trafficLight = new TrafficLight();
        this.intersection = new Intersection(trafficLight, 10);
        this.factory = new VehicleFactory(intersection, trafficLight);
    }

    public void start(int runSeconds) {
        LogUtil.log("Bắt đầu mô phỏng trong %d giây", runSeconds);

        Thread lightThread = new Thread(trafficLight);
        lightThread.setName("TrafficLightThread");
        lightThread.setDaemon(true);
        lightThread.start();

        ExecutorService vehiclePool = Executors.newCachedThreadPool();
        
        long endTime = System.currentTimeMillis() + runSeconds * 1000L;
        
        while (System.currentTimeMillis() < endTime) {
            Vehicle v = factory.createRandomVehicle();
            if (v != null) {
                vehiclePool.submit(v);
            }

            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }

        vehiclePool.shutdown();
        try {
            if (!vehiclePool.awaitTermination(5, TimeUnit.SECONDS)) {
                vehiclePool.shutdownNow();
            }
        } catch (InterruptedException e) {
            vehiclePool.shutdownNow();
            Thread.currentThread().interrupt();
        }

        trafficLight.stop();
        intersection.shutdown();

        LogUtil.log("Mô phỏng kết thúc. Xe đi qua: %d, Số lần kẹt: %d",
                intersection.getPassedCount(), intersection.getJamCount());
    }
}
