package org.ezcab.ezcabauthservice.services;

import org.ezcab.ezcabauthservice.dto.PassengerDto;
import org.ezcab.ezcabauthservice.dto.PassengerSignupRequestDto;
import org.ezcab.ezcabauthservice.models.Passenger;
import org.ezcab.ezcabauthservice.repositories.PassengerRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final PassengerRepository passengerRepository;

    public AuthService(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    public PassengerDto signupPassenger(PassengerSignupRequestDto passengerSignupRequestDto) {
        Passenger passenger = Passenger.builder()
                .name(passengerSignupRequestDto.getName())
                .email(passengerSignupRequestDto.getEmail())
                .password(passengerSignupRequestDto.getPassword())   //TODO: Encrypt the password
                .phoneNumber(passengerSignupRequestDto.getPhoneNumber())
                .build();

        passengerRepository.save(passenger);
        return passengerSignupRequestDto;
    }
}
