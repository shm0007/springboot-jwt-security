/*
package com.ehsan.jwtScaffolder.service;

import com.ehsan.jwtScaffolder.Repository.UserRepository;
import com.ehsan.jwtScaffolder.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	UserRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByName(username)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

		UserDetails det  =  UserDetailsImpl.build(user);
		return det;
	}

}
*/
