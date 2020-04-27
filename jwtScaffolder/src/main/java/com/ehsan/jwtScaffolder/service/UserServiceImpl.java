package com.ehsan.jwtScaffolder.service;

import com.ehsan.jwtScaffolder.Repository.RoleRepository;
import com.ehsan.jwtScaffolder.Repository.UserRepository;
import com.ehsan.jwtScaffolder.domain.Role;
import com.ehsan.jwtScaffolder.domain.User;
import com.ehsan.jwtScaffolder.model.*;
import com.ehsan.jwtScaffolder.security.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements  UserService{
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    AuthenticationManager authenticationManager;

    public UsersResponse findUsers(){

        return UsersResponse.builder().users(userRepository.findAll()).build();
    }

    public Object registerUser(RegistrationRequest req){
        User user = User.builder().email(req.getEmail())
                .name(req.getName())
                .password(passwordEncoder.encode(req.getPassword()))
                .build();


        if(userRepository.existsByEmail(user.getEmail()))
            return ErrorResponse.builder().message("Email Already Exists!").build();

        List<String> strRoles = req.getRole();
        List<Role> roles = new ArrayList<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(RoleEnum.ROLE_REGULER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
			strRoles.forEach(role -> {
				switch (role) {
				case "admin":
					Role adminRole = roleRepository.findByName(RoleEnum.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(adminRole);

					break;
                case "owner":
                    Role modRole = roleRepository.findByName(RoleEnum.ROLE_OWNER)
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                    roles.add(modRole);
                    break;
				default:
					Role userRole = roleRepository.findByName(RoleEnum.ROLE_REGULER)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(userRole);
				}
			});
		}

        user.setRoles(roles);
        userRepository.save(user);
        return user;//BasicResponse.builder().message("SUCCESS").build();
    }

    @Override
    public SignInResponse checkAndLoginUser(LoginRequest req) {


        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(req.getName(), req.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);


        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

       SignInResponse response =  new SignInResponse(jwt,
                userDetails.getUsername(),roles);
        return response;
    }


}
