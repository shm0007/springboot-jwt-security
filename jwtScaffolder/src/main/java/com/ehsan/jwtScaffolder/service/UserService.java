package com.ehsan.jwtScaffolder.service;

import com.ehsan.jwtScaffolder.domain.User;
import com.ehsan.jwtScaffolder.model.LoginRequest;
import com.ehsan.jwtScaffolder.model.RegistrationRequest;
import com.ehsan.jwtScaffolder.model.UsersResponse;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {
    UsersResponse findUsers();
    Object registerUser(RegistrationRequest req);
    UserDetails checkAndLoginUser(LoginRequest req);
}
