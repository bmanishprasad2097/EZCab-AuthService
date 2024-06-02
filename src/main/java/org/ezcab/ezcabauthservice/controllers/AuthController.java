package org.ezcab.ezcabauthservice.controllers;

import org.ezcab.ezcabauthservice.dto.PassengerDto;
import org.ezcab.ezcabauthservice.dto.PassengerSignupRequestDto;
import org.ezcab.ezcabauthservice.services.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService){
        this.authService = authService;
    }

    @PostMapping("/signup/passengers")
    public ResponseEntity<PassengerDto> signUp(@RequestBody PassengerSignupRequestDto passengerSignupRequestDto){
        PassengerDto response = authService.signupPassenger(passengerSignupRequestDto);
        return new ResponseEntity<>(response , HttpStatus.CREATED);
    }

    @GetMapping("/signup/passengers")
    String response(){
        return "Successfully Booked!!!";
    }
}
