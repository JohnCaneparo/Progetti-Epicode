package it.johncaneparo.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.johncaneparo.spring.model.Role;
import it.johncaneparo.spring.model.RoleType;
import it.johncaneparo.spring.repository.RoleRepository;

@Service
public class RoleService {
	@Autowired
	RoleRepository roleRepository;
	
	
	public List<Role> myFindAllUsers() {
        return roleRepository.findAll();
    }
    
    public Optional<Role> myFindUserById(long id) {
        return roleRepository.findById(id);
    }
    
    public void myInsertRole(RoleType roletype) {
    	roleRepository.save(new Role(roletype));
    }
}
