package com.ehsan.jwtScaffolder.service;

import com.ehsan.jwtScaffolder.domain.User;
import com.ehsan.jwtScaffolder.model.UsersResponse;

import java.util.List;

public interface UserService {
    UsersResponse findUsers();
}
