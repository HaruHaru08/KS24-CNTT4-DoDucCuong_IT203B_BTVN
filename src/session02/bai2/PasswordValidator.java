package session02.bai2;

@FunctionalInterface
interface PasswordValidator{
    boolean isValid(String password);
}
