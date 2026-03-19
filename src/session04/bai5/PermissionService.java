package session04.bai5;

public class PermissionService {
    public boolean canPerformAction(User user, String action) {
        String role = user.getRole();
        if (role.equals("ADMIN")) {
            return true;
        }
        if (role.equals("MODERATOR")) {
            return action.equals("LOCK_USER") || action.equals("VIEW_PROFILE");
        }
        if (role.equals("USER")) {
            return action.equals("VIEW_PROFILE");
        }
        return false;
    }
}