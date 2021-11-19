package it.johncaneparo.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import it.johncaneparo.spring.model.Role;

@Component
public interface RoleRepository extends JpaRepository<Role, Long> {
		
}
