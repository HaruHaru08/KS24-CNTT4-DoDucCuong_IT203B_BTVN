package session04.bai6;

import java.time.LocalDate;
import java.util.List;

public class UserService {
    public User updateProfile(User existingUser, UserProfile newProfile, List<User> allUsers) {
        // kiểm tra ngày sinh tương lai
        if (newProfile.getBirthDate().isAfter(LocalDate.now())) {
            return null;
        }
        // kiểm tra email trùng
        for (User u : allUsers) {
            if (!u.equals(existingUser) && u.getEmail().equals(newProfile.getEmail())) {
                return null;
            }
        }
        // cập nhật
        existingUser.setEmail(newProfile.getEmail());
        existingUser.setBirthDate(newProfile.getBirthDate());
        existingUser.setName(newProfile.getName());

        return existingUser;
    }
}