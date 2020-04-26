package com.ehsan.jwtScaffolder.endpoint;


import com.ehsan.jwtScaffolder.domain.User;
import com.ehsan.jwtScaffolder.model.ErrorResponse;
import com.ehsan.jwtScaffolder.model.RegistrationRequest;
import com.ehsan.jwtScaffolder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/auth")
public class AuthController {
    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody RegistrationRequest user){
        Object obj = userService.registerUser(user);
        if( obj instanceof ErrorResponse)
            return ResponseEntity.badRequest().body(obj);
        return ResponseEntity.ok(obj);
    }
}
