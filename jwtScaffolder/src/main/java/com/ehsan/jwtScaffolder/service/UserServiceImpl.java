package com.ehsan.jwtScaffolder.service;

import com.ehsan.jwtScaffolder.Repository.UserRepository;
import com.ehsan.jwtScaffolder.domain.User;
import com.ehsan.jwtScaffolder.model.UsersResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements  UserService{
    @Autowired
    UserRepository userRepository;
    public UsersResponse findUsers(){

        return UsersResponse.builder().users(userRepository.findAll()).build();
    }


}
