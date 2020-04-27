package com.ehsan.jwtScaffolder.endpoint;


import com.ehsan.jwtScaffolder.domain.User;
import com.ehsan.jwtScaffolder.model.ErrorResponse;
import com.ehsan.jwtScaffolder.model.LoginRequest;
import com.ehsan.jwtScaffolder.model.RegistrationRequest;
import com.ehsan.jwtScaffolder.model.SignInResponse;
import com.ehsan.jwtScaffolder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/auth")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AuthController {
    @Autowired
    UserService userService;

    @PostMapping(value = "/register")
    public ResponseEntity<?> registerUser(@RequestBody RegistrationRequest request){
        Object obj = userService.registerUser(request);
        if( obj instanceof ErrorResponse)
            return ResponseEntity.badRequest().body(obj);
        return ResponseEntity.ok(obj);
    }
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody @Valid LoginRequest request){
        SignInResponse response = userService.checkAndLoginUser(request);
        return ResponseEntity.ok(response);
    }

}
