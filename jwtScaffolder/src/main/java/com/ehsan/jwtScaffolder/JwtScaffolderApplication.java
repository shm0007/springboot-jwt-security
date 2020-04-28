package com.ehsan.jwtScaffolder;

import com.ehsan.jwtScaffolder.Repository.RoleRepository;
import com.ehsan.jwtScaffolder.config.FileStorageProperties;
import com.ehsan.jwtScaffolder.domain.Role;
import com.ehsan.jwtScaffolder.model.RoleEnum;
import com.ehsan.jwtScaffolder.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableConfigurationProperties({
		FileStorageProperties.class
})
public class JwtScaffolderApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtScaffolderApplication.class, args);

	}
	@Autowired
	RoleRepository roleRepository;
	@PostConstruct
	public void addRoles(){
		Role reguler =new Role().builder().name(RoleEnum.ROLE_REGULER).build();
		Role user =new Role().builder().name(RoleEnum.ROLE_USER).build();
		Role admin =new Role().builder().name(RoleEnum.ROLE_ADMIN).build();
		Role owner =new Role().builder().name(RoleEnum.ROLE_OWNER).build();
		roleRepository.save( reguler );
		roleRepository.save( user );
		roleRepository.save( admin );
		roleRepository.save( owner );
	}
}
