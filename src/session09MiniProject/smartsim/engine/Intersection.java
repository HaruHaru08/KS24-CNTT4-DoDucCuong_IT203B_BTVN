package session09MiniProject.smartsim.engine;

import session09MiniProject.smartsim.exception.CollisionException;
import session09MiniProject.smartsim.exception.TrafficJamException;
import session09MiniProject.smartsim.model.Vehicle;
import session09MiniProject.smartsim.traffic.TrafficLight;
import session09MiniProject.smartsim.traffic.TrafficLightObserver;
import session09MiniProject.smartsim.traffic.TrafficLightState;
import session09MiniProject.smartsim.util.LogUtil;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Intersection implements TrafficLightObserver {

    private final ReentrantLock lock = new ReentrantLock(true);
    private final Condition greenCondition = lock.newCondition();

    private final BlockingQueue<Vehicle> waitingQueue;
    private final int maxQueueSize;
    private final TrafficLight trafficLight;

    private volatile int passedCount = 0;
    private volatile int jamCount = 0;

    public Intersection(TrafficLight trafficLight, int maxQueueSize) {
        this.trafficLight = trafficLight;
        this.maxQueueSize = maxQueueSize;
        this.waitingQueue = new LinkedBlockingQueue<>(maxQueueSize);
        this.trafficLight.registerObserver(this);
    }

    public void enterQueue(Vehicle vehicle) throws InterruptedException {
        // Use offer with timeout or check size
        // If queue is full, we log and discard or throw exception if we want to stop
        if (!waitingQueue.offer(vehicle)) {
            jamCount++;
            LogUtil.log("Traffic Jam! Queue full. Vehicle " + vehicle + " could not enter.");
            // In a real sim, we might want to block until space available, or throw exception.
            // The original code threw TrafficJamException.
            // Let's stick to throwing it if the calling code handles it, or just log.
            // The Simulator calls this indirectly via Vehicle.run().
            // If Vehicle.run throws exception, the thread terminates.
        }
    }

    public void awaitGreenAndCross(Vehicle vehicle) throws InterruptedException {
        // Simple FIFO logic
        // First, ensure we are at the head of the queue
        while (true) {
            Vehicle head = waitingQueue.peek();
            if (head != null && head.equals(vehicle)) {
                break;
            }
            // Wait a bit if not at head
            TimeUnit.MILLISECONDS.sleep(50);
        }

        lock.lock();
        try {
            // Wait for green light or if priority
            while (!canCross(vehicle)) {
                greenCondition.await();
            }

            // Remove from queue (should be head)
            waitingQueue.take();

            LogUtil.log("%s đang đi qua ngã tư", vehicle);
            TimeUnit.MILLISECONDS.sleep(vehicle.getSpeedMillis());
            passedCount++;
            LogUtil.log("%s đã qua giao lộ", vehicle);
        } finally {
            lock.unlock();
        }
    }

    private boolean canCross(Vehicle vehicle) {
        // Check light state from TrafficLight
        TrafficLightState state = trafficLight.getCurrentState();
        if (state == null) return false;
        boolean isGreen = "GREEN".equals(state.getName());
        return isGreen || vehicle.isPriority();
    }

    @Override
    public void onLightChanged(TrafficLightState newState) {
        lock.lock();
        try {
            greenCondition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public int getPassedCount() {
        return passedCount;
    }

    public int getJamCount() {
        return jamCount;
    }

    public void shutdown() {
        trafficLight.unregisterObserver(this);
    }
}
