package id.co.badr.auth;

import id.co.badr.auth.model.User;
import id.co.badr.auth.model.UserRepository;
import id.co.badr.auth.request.RegisterRequest;
import id.co.badr.auth.response.RegisterResponse;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController
{
    @Autowired
    private UserRepository userRepo;

    @ResponseBody
    @RequestMapping(value = "auth/register", method = RequestMethod.POST)
    public RegisterResponse register(@RequestBody RegisterRequest request)
    {
        User user = userRepo.findByEmail(request.getEmail());
        if(user != null) {
            return null;
        }

        user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        userRepo.save(user);
        
        return null;
    }
}