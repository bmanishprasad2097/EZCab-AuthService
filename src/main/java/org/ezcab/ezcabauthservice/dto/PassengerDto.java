package org.ezcab.ezcabauthservice.dto;

import lombok.*;
import org.ezcab.ezcabauthservice.models.Passenger;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PassengerDto {

    private String id;

    private String name;

    private String email;

    private String phoneNumber;

    private String password;

    private Date createdAt;

}
