package be.OdiMentee.UserAdministrationMicroService.controller;

import be.OdiMentee.UserAdministrationMicroService.dao.UserRepository;
import be.OdiMentee.UserAdministrationMicroService.domain.AuthenticateRequest;
import be.OdiMentee.UserAdministrationMicroService.domain.JwtAuthenticationResponse;
import be.OdiMentee.UserAdministrationMicroService.domain.User;
import be.OdiMentee.UserAdministrationMicroService.domain.UserPrincipal;
import be.OdiMentee.UserAdministrationMicroService.service.JWTTokenProviderService;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/Authenticate")
@Slf4j

public class AuthController {


    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTTokenProviderService jwtTokenProvider;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/signin")
    public ResponseEntity authenticateUser(@RequestBody AuthenticateRequest authenticateRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticateRequest.getUserName(), authenticateRequest.getPassword()));
        String token =jwtTokenProvider.generateToken((UserPrincipal)authentication.getPrincipal());
        log.info("Token Created {}",token);
        return ResponseEntity.ok(new JwtAuthenticationResponse(token));
    }


@PostMapping("/signup")
    public ResponseEntity registerUser(String userEmail, String userpassword ){

        if(userRepository.findByEmail(userEmail).isPresent()){

            User newuser = new User(0,userEmail,userpassword,"Admin");

            userRepository.save(newuser);

            return ResponseEntity.ok("User has been registered succesfully");


//            return  ResponseEntity.badRequest()
//                    .body("User email already exists");
        }



        User newuser = new User(0,userEmail,userpassword,"Admin");

        userRepository.save(newuser);

        return ResponseEntity.ok("User has been registered succesfully");

}

}
