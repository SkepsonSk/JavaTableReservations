package pl.pollub.javatablereservations.controller;

import com.mysql.fabric.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pollub.javatablereservations.dto.LoginDto;
import pl.pollub.javatablereservations.dto.LoginResponseDto;
import pl.pollub.javatablereservations.factory.ResponseFactory;
import pl.pollub.javatablereservations.service.AuthService;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "/")
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping(value = "login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginDto loginDto) {
        Optional<LoginResponseDto> loginResponseDto = this.authService.login(loginDto);

        if (loginResponseDto.isPresent()) {
            ResponseFactory.ok(loginResponseDto);
        }
        return ResponseFactory.loginFailed();
    }

    @PostMapping(value = "refresh")
    public ResponseEntity<LoginResponseDto> refreshToken(@RequestHeader("Authorization") String sessionId) {
        Optional<LoginResponseDto> loginResponseDto = this.authService.refreshToken(UUID.fromString(sessionId));

        if (loginResponseDto.isPresent()) {
            ResponseFactory.ok(loginResponseDto);
        }
        return ResponseFactory.loginFailed();
    }
}
