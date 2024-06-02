package org.ezcab.ezcabauthservice.services;

import org.ezcab.ezcabauthservice.dto.PassengerDto;
import org.ezcab.ezcabauthservice.dto.PassengerSignupRequestDto;
import org.ezcab.ezcabauthservice.models.Passenger;
import org.ezcab.ezcabauthservice.repositories.PassengerRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final PassengerRepository passengerRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public AuthService(PassengerRepository passengerRepository , BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.passengerRepository = passengerRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public PassengerDto signupPassenger(PassengerSignupRequestDto passengerSignupRequestDto) {
        Passenger passenger = Passenger.builder()
                .name(passengerSignupRequestDto.getName())
                .email(passengerSignupRequestDto.getEmail())
                .password(bCryptPasswordEncoder.encode(passengerSignupRequestDto.getPassword()))   //TODO: Encrypt the password
                .phoneNumber(passengerSignupRequestDto.getPhoneNumber())
                .build();

        Passenger newPassenger = passengerRepository.save(passenger);
        return PassengerDto.fromPassenger(newPassenger);
    }
}
