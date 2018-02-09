package id.co.badr.auth.dto;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

public class RegistrationRequest
{
    @NotBlank @Getter @Setter private String name;
    @NotBlank @Getter @Setter private String email;
    @NotBlank @Getter @Setter private String password;
}