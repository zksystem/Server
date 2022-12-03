package com.ferradesign.server.web;

import com.ferradesign.server.dao.SessionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class ProductsController {

    @Autowired
    SessionsRepository sessionsRepository;

    @GetMapping("/api/v1/products/")
    public ResponseEntity<?> allProducts(
            @RequestHeader("sessionId") String sessionId) {
        if (sessionsRepository.isValidSessionId(sessionId)) {
            String response = "OK";
            return new ResponseEntity<>(response, HttpStatus.OK);
        }

        return new ResponseEntity<>("Unauthorized", HttpStatus.UNAUTHORIZED);
    }

}
