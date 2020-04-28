package com.ehsan.jwtScaffolder.Repository;

import com.ehsan.jwtScaffolder.domain.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestautantRepository extends JpaRepository<Restaurant, Integer> {

}
