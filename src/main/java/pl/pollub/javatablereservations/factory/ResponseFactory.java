package pl.pollub.javatablereservations.factory;

import org.springframework.http.ResponseEntity;

public class ResponseFactory {

    public static<T> ResponseEntity<T> ok(T obj) {
        return ResponseEntity.ok(obj);
    }

    public static<T> ResponseEntity<T> loginFailed() {
        throw new IllegalStateException("Login failed");
    }

    public class LoginException extends Exception {}

}
