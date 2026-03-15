package session06.bai6;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

class TicketPool {
    private final String roomName;
    private final AtomicInteger soldTickets = new AtomicInteger(0);
    private final int totalCapacity;

    public TicketPool(String roomName, int capacity) {
        this.roomName = roomName;
        this.totalCapacity = capacity;
    }

    public synchronized boolean sell() {
        if (soldTickets.get() < totalCapacity) {
            soldTickets.incrementAndGet();
            return true;
        }
        return false;
    }

    public int getSold() { return soldTickets.get(); }
    public String getName() { return roomName; }
}

class DeadlockDetector implements Runnable {
    @Override
    public void run() {
        ThreadMXBean bean = ManagementFactory.getThreadMXBean();
        long[] deadlockedThreads = bean.findDeadlockedThreads();
        if (deadlockedThreads != null) {
            System.out.println("CẢNH BÁO: Phát hiện Deadlock!");
        } else {
            System.out.println("Không phát hiện deadlock.");
        }
    }
}

public class Bai6 {
    private static ExecutorService executor;
    private static List<TicketPool> pools = new ArrayList<>();
    private static boolean running = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- MENU RẠP CHIẾU PHIM ---");
            System.out.println("1. Bắt đầu | 2. Tạm dừng | 3. Tiếp tục | 4. Thống kê | 5. Quét Deadlock | 6. Thoát");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Số phòng: ");
                    int p = scanner.nextInt();

                    System.out.print("Số vé/phòng: ");
                    int t = scanner.nextInt();

                    System.out.print("Số quầy: ");
                    int c = scanner.nextInt();

                    pools.clear();
                    for (int i = 0; i < p; i++) {
                        pools.add(new TicketPool("Phòng " + (char) ('A' + i), t));
                    }

                    executor = Executors.newFixedThreadPool(c);
                    running = true;

                    for (int i = 0; i < c; i++) {
                        executor.execute(() -> {
                            while (running) {
                                pools.forEach(pool -> {
                                    if (pool.sell())
                                        System.out.println("Bán thành công tại " + pool.getName());
                                });
                                try {
                                    Thread.sleep(500);
                                } catch (InterruptedException e) {
                                }
                            }
                        });
                    }
                    break;

                case 2:
                    running = false;
                    break;

                case 3:
                    running = true;
                    break;

                case 4:
                    pools.forEach(p1 -> System.out.println(p1.getName() + ": " + p1.getSold() + " vé"));
                    break;

                case 5:
                    new DeadlockDetector().run();
                    break;

                case 6:
                    if (executor != null)
                        executor.shutdown();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        }
    }
}
