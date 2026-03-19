package session02.bai5;

public class SuperAdmin implements AdminActions,UserActions {
    @Override
    public void logActivity(String activity) {
        AdminActions.super.logActivity(activity);
    }
}
