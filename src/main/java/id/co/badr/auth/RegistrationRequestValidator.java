package id.co.badr.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import id.co.badr.auth.dao.User;
import id.co.badr.auth.dao.UserRepository;
import id.co.badr.auth.dto.RegistrationRequest;

@Component
public class RegistrationRequestValidator implements Validator
{
    @Autowired
    private UserRepository userRepo;

    @Override
    public boolean supports(Class<?> clazz)
    {
        return RegistrationRequest.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors)
    {
        RegistrationRequest request = (RegistrationRequest) target;
        String email = request.getEmail();
        User user = userRepo.findByEmail(email);

        if(user != null) {
            errors.rejectValue("email", "email.already_registered", "Email already registered");
        }
    }
}