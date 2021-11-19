package it.johncaneparo.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.johncaneparo.spring.service.RoleService;

@RestController
@RequestMapping("/rolecontroller")
public class RoleController {
	@Autowired
	private RoleService roleService;
}
