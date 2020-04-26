package com.ehsan.jwtScaffolder.endpoint;

import com.ehsan.jwtScaffolder.domain.User;
import com.ehsan.jwtScaffolder.model.UsersResponse;
import com.ehsan.jwtScaffolder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/backdoor")
public class BackDoorController {
    @Autowired
    UserService userService;

    @GetMapping("/users")
    public ResponseEntity<UsersResponse> getAllUsers(){
        UsersResponse users = userService.findUsers();
        return ResponseEntity.ok(users);
    }

}
