package session02.bai3;

import org.mindrot.jbcrypt.BCrypt;

@FunctionalInterface
interface Authenticatable{
    String getPassword();

    default boolean isAuthenticated(String password){
        return !password.isBlank();
    }

    static String encrypt(String rawPassword){
        return BCrypt.hashpw(rawPassword, BCrypt.gensalt(12));
    }
}
