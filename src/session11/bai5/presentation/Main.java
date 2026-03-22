package session11.bai5.presentation;

import session11.bai5.business.DoctorBusiness;
import session11.bai5.model.Doctor;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DoctorBusiness business = new DoctorBusiness();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. List all doctors");
            System.out.println("2. Add new doctor");
            System.out.println("3. Exit");
            System.out.print("Choose: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    List<Doctor> doctors = business.getAllDoctors();
                    for (Doctor d : doctors) {
                        System.out.println(d.getId() + " - " + d.getName() + " - " + d.getSpecialization());
                    }
                    break;
                case 2:
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Specialization: ");
                    String spec = scanner.nextLine();

                    Doctor d = new Doctor(id, name, spec);
                    if (business.addDoctor(d)) {
                        System.out.println("Added successfully!");
                    } else {
                        System.out.println("Failed to add.");
                    }
                    break;
                case 3:
                    System.exit(0);
                    break;
            }
        }
    }
}
