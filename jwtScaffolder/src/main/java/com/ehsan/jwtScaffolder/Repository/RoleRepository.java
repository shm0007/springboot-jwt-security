package com.ehsan.jwtScaffolder.Repository;

import com.ehsan.jwtScaffolder.domain.Role;
import com.ehsan.jwtScaffolder.model.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(RoleEnum name);
}
