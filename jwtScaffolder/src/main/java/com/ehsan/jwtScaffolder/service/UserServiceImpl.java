package com.ehsan.jwtScaffolder.service;

import com.ehsan.jwtScaffolder.Repository.UserRepository;
import com.ehsan.jwtScaffolder.domain.User;
import com.ehsan.jwtScaffolder.model.ErrorResponse;
import com.ehsan.jwtScaffolder.model.RegistrationRequest;
import com.ehsan.jwtScaffolder.model.UsersResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements  UserService{
    @Autowired
    UserRepository userRepository;
    public UsersResponse findUsers(){

        return UsersResponse.builder().users(userRepository.findAll()).build();
    }

    public Object registerUser(RegistrationRequest req){
        User user = User.builder().email(req.getEmail())
                .name(req.getName())
                .password(req.getPassword())
                .role(req.getRole().getValue())
                .build();
        if(userRepository.existsByEmail(user.getEmail()))
            return ErrorResponse.builder().message("Email Already Exists!").build();
        userRepository.save(user);
        return user;//BasicResponse.builder().message("SUCCESS").build();
    }

}
