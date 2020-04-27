package com.ehsan.jwtScaffolder.endpoint;


import com.ehsan.jwtScaffolder.model.ErrorResponse;
import com.ehsan.jwtScaffolder.model.LoginRequest;
import com.ehsan.jwtScaffolder.model.RegistrationRequest;
import com.ehsan.jwtScaffolder.model.SignInResponse;
import com.ehsan.jwtScaffolder.security.AuthEntryPointJwt;
import com.ehsan.jwtScaffolder.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RequestMapping(value = "/api/auth")
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthEntryPointJwt.class);

    @Autowired
    UserService userService;

    @PostMapping(value = "/register")
    public ResponseEntity<?> registerUser(@RequestBody RegistrationRequest request){
        logger.info("Register Request {}",request);
        Object obj = userService.registerUser(request);
        if( obj instanceof ErrorResponse)
            return ResponseEntity.badRequest().body(obj);
        return ResponseEntity.ok(obj);
    }
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody @Valid LoginRequest request){
        logger.info("Login Request {}" , request);
        SignInResponse response = userService.checkAndLoginUser(request);
        logger.info("Login Response {}" , response);

        return ResponseEntity.ok(response);

    }

}
