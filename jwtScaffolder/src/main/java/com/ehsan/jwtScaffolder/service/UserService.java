package com.ehsan.jwtScaffolder.service;

import com.ehsan.jwtScaffolder.domain.User;
import com.ehsan.jwtScaffolder.model.RegistrationRequest;
import com.ehsan.jwtScaffolder.model.UsersResponse;

public interface UserService {
    UsersResponse findUsers();
    Object registerUser(RegistrationRequest req);
}
