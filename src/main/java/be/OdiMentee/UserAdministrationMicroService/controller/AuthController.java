package be.OdiMentee.UserAdministrationMicroService.controller;

import be.OdiMentee.UserAdministrationMicroService.config.JwtTokenUtil;
import be.OdiMentee.UserAdministrationMicroService.domain.*;
import be.OdiMentee.UserAdministrationMicroService.service.JwtUserDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@CrossOrigin(origins = {"http://localhost:4200","/http://localhost:8080"}, maxAge = 3600)
@RestController
@Slf4j
@RequestMapping("/users")

public class AuthController {


    private final AuthenticationManager authenticationManager;

    private final JwtTokenUtil jwtTokenUtil;

    private final JwtUserDetailsService userDetailsService;

    public AuthController(AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil, JwtUserDetailsService userDetailsService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userDetailsService = userDetailsService;
    }

    @RequestMapping(value="/test", method = RequestMethod.GET)
    public String getTest(){
        return "testing";
    }


    @RequestMapping(value =  "/generate-token", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token,userDetails));
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ResponseEntity<?> saveUser(@RequestBody UserDTO user) throws Exception {
        System.out.println("user = " + user.getMentee()+" "+user.getMentor());

        User tebewaren  = new User(0,user.getUsername(), user.getPassword());

        var response = userDetailsService.save(tebewaren);

        if(response != null){
            final UserDetails userDetails = userDetailsService.loadUserByUsername(tebewaren.getUsername());

            ProfielDTO profiel = new ProfielDTO(user.getVoornaam(),user.getAchternaam(),user.getGeblokkeerd(),user.getMentee(),user.getMentor(),user.getOpleidingfase(),user.getStudierichting(),response.getUserId());

            RestTemplate restTemplate = new RestTemplate();
            var headers = new HttpHeaders(){{
                String authHeader = "Bearer " + jwtTokenUtil.generateToken(userDetails);
                set( "Authorization",authHeader );
            }
            };
            headers.setContentType(MediaType.APPLICATION_JSON);

            String Uri
                    = "http://localhost:8080/profielen/CreateStudent";

            HttpEntity<ProfielDTO> requestEntity =
                    new HttpEntity<>(profiel, headers);
            ResponseEntity<String> responseProfiel =
                    restTemplate.exchange(Uri, HttpMethod.POST, requestEntity,
                            String.class);

        }

        return ResponseEntity.ok(response);




    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

}
