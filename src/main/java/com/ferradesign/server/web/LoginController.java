package com.ferradesign.server.web;

import com.ferradesign.server.dao.SessionsRepository;
import com.ferradesign.server.dao.UsersRepository;
import com.ferradesign.server.requests.JsonLoginRequest;
import com.ferradesign.server.requests.JsonSessionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    SessionsRepository sessionsRepository;

    @PostMapping("/api/v1/login")
    public ResponseEntity<?> Login(
            @RequestBody JsonLoginRequest loginRequest) {
        Integer role = usersRepository.getUserRole(loginRequest.getLogin(), loginRequest.getPassword());

        if (role != null) {
            JsonSessionRequest response = sessionsRepository.getSessionId(loginRequest.getLogin());
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>("Unauthorized", HttpStatus.UNAUTHORIZED);
    }

    @PostMapping("/api/v1/logout")
    public ResponseEntity<?> Logout(
            @RequestBody JsonLoginRequest loginRequest) {
        Integer role = usersRepository.getUserRole(loginRequest.getLogin(), loginRequest.getPassword());

        if (role != null) {
            sessionsRepository.removeSessionId(loginRequest.getLogin());
            return new ResponseEntity<>("Successfully log out", HttpStatus.OK);
        }
        return new ResponseEntity<>("Unauthorized", HttpStatus.UNAUTHORIZED);
    }

}
