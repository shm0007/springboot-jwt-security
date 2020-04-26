package com.ehsan.jwtScaffolder.service;

import com.ehsan.jwtScaffolder.Repository.UserRepository;
import com.ehsan.jwtScaffolder.domain.User;
import com.ehsan.jwtScaffolder.model.ErrorResponse;
import com.ehsan.jwtScaffolder.model.LoginRequest;
import com.ehsan.jwtScaffolder.model.RegistrationRequest;
import com.ehsan.jwtScaffolder.model.UsersResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements  UserService{
    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    public UsersResponse findUsers(){

        return UsersResponse.builder().users(userRepository.findAll()).build();
    }

    public Object registerUser(RegistrationRequest req){
        User user = User.builder().email(req.getEmail())
                .name(req.getName())
                .password(passwordEncoder.encode(req.getPassword()))
                .role(req.getRole().getValue())
                .build();
        if(userRepository.existsByEmail(user.getEmail()))
            return ErrorResponse.builder().message("Email Already Exists!").build();
        userRepository.save(user);
        return user;//BasicResponse.builder().message("SUCCESS").build();
    }

    @Override
    public UserDetails checkAndLoginUser(LoginRequest req) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(req.getName(), req.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetails userDetails = (UserDetailsImpl) authentication.getPrincipal();
        return userDetails;
    }


}
