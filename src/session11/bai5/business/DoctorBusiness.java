package session11.bai5.business;

import session11.bai5.dao.DoctorDAO;
import session11.bai5.model.Doctor;

import java.util.List;

public class DoctorBusiness {
    private DoctorDAO doctorDAO;

    public DoctorBusiness() {
        this.doctorDAO = new DoctorDAO();
    }

    public List<Doctor> getAllDoctors() {
        return doctorDAO.getAllDoctors();
    }

    public boolean addDoctor(Doctor doctor) {
        // Basic validation or business logic if needed
        if (doctor.getName() == null || doctor.getName().isEmpty()) {
            return false;
        }
        return doctorDAO.insertDoctor(doctor);
    }
}
