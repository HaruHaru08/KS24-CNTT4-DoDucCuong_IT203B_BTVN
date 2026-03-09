package session02.bai6;

import session02.bai6.User;

@FunctionalInterface
interface UserProcessor {
    String process(User u);
}
