package pl.pollub.javatablereservations.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pollub.javatablereservations.dto.LoginDto;
import pl.pollub.javatablereservations.dto.LoginResponseDto;
import pl.pollub.javatablereservations.dto.UserInfoDto;
import pl.pollub.javatablereservations.factory.ResponseFactory;
import pl.pollub.javatablereservations.repository.UserRepository;
import pl.pollub.javatablereservations.service.AuthService;
import pl.pollub.javatablereservations.session.Session;
import pl.pollub.javatablereservations.session.SessionUserInfoAdapter;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "/")
public class AuthController {

    private final AuthService authService;
    private final UserRepository userRepository;

    @Autowired
    public AuthController(AuthService authService, UserRepository userRepository) {
        this.authService = authService;
        this.userRepository = userRepository;
    }

    @PostMapping(value = "login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginDto loginDto) {
        Optional<LoginResponseDto> loginResponseDto = this.authService.login(loginDto);
        return loginResponseDto.map(ResponseFactory::ok).orElseGet(ResponseFactory::loginFailed);
    }

    @PostMapping(value = "refresh")
    public ResponseEntity<LoginResponseDto> refreshToken(@RequestHeader("Authorization") String sessionId) {
        Optional<LoginResponseDto> loginResponseDto = this.authService.refreshToken(UUID.fromString(sessionId));

        if (loginResponseDto.isPresent()) {
            ResponseFactory.ok(loginResponseDto);
        }
        return ResponseFactory.loginFailed();
    }

    @GetMapping(value = "userinfo")
    public ResponseEntity<UserInfoDto> getUserInfo(@RequestHeader("Authorization") String sessionId) {
        Session session = this.authService.getSession(UUID.fromString(sessionId)).orElseThrow();
        SessionUserInfoAdapter adapter = new SessionUserInfoAdapter(session, userRepository);
        return ResponseFactory.ok(new UserInfoDto(adapter));
    }
}
