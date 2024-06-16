package com.example.librarymanagement.security.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.librarymanagement.security.model.AuthenticateRequestModel;
import com.example.librarymanagement.security.model.RegisterRequestModel;
import com.example.librarymanagement.security.service.AuthenticationService;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticateController {

    private final AuthenticationService authenticationService;


    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequestModel requestModel){

        return new ResponseEntity<>(authenticationService.register(requestModel), HttpStatus.OK);

    }


    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody AuthenticateRequestModel requestModel){
        try {
            return new ResponseEntity<>(authenticationService.authenticate(requestModel), HttpStatus.OK);
        }catch (Exception e){

            Map<String, Object> map = new HashMap<>();
            map.put("message", "Bad Credentials");
            map.put("status", false);
            return new ResponseEntity<Object>(map, HttpStatus.BAD_REQUEST);


        }
    }



}
