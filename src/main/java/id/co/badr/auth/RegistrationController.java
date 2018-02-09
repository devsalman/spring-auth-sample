package id.co.badr.auth;

import java.sql.Timestamp;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import id.co.badr.auth.dao.User;
import id.co.badr.auth.dao.UserRepository;
import id.co.badr.auth.dto.RegistrationRequest;

@RestController
public class RegistrationController
{
    @Autowired private UserRepository userRepo;
    @Autowired private RegistrationRequestValidator requestValidator;

    @InitBinder
    protected void initBinder(WebDataBinder binder)
    {
        binder.setValidator(requestValidator);
    }

    @ResponseBody
    @RequestMapping(value = "auth/register", method = RequestMethod.POST)
    public ResponseEntity<?> register(@Valid @RequestBody RegistrationRequest request)
    {
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        userRepo.save(user);
        

        return ResponseEntity.ok(true);
    }
}