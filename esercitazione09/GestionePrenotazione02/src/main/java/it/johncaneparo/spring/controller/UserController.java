package it.johncaneparo.spring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.johncaneparo.spring.model.User;
import it.johncaneparo.spring.service.UserService;

@RestController
@RequestMapping("/usercontroller")
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/getuserall")
	public List<User> getUserAll() {
		List<User> lu = userService.findAllUsers();
		return lu;
	}
	
	@GetMapping("/getuserbyusername/{username}")
	public User getUserByUsername(@PathVariable(required = true) String username) {
		User u = userService.findUserByUsername(username);
		return u;
	}
	
	@GetMapping("/saveuser")
	public void saveUser(@RequestParam String username, String nome, String email, String password, Boolean active) {
		userService.insertUser(username, nome, email, password, active);
	}
	
	// Paginazione
    @GetMapping(value = "/mygetalluserspage", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<User>> myGetAllUsersPage(Pageable pageable) {
        Page<User> findAll = userService.myFindAllUsersPageable(pageable);
        if (findAll.hasContent()) {
            return new ResponseEntity<>(findAll, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    //paginazione con pagina e size dati da parametri della chiamata get
    @GetMapping(value = "/mygetalluserspagesize", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Object> myGetAllUsersPageSize(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "3") int size) {
        Page<User> users = userService.myFindAllUsersPageSize(page, size);
        Map<String, Object> myResponse = new HashMap<>();
        myResponse.put("users", users);
        return myResponse;
    }
    
    //PAGING AND SORTING CON PAGE, SIZE E SORTING PASSATI COME PARAMETRO ALLA CHIAMATA GET
    @GetMapping(value = "/mygetalluserspagesizesort", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> myGetAllUserPageSizeSort(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "2") Integer size, @RequestParam(defaultValue = "id") String sort) {
      List<User> list = userService.findAllUsersPageSizeSort(page, size, sort);
      return new ResponseEntity<List<User>>(list, new HttpHeaders(), HttpStatus.OK); 
    }
    
    //Sorting
    @GetMapping(value = "/mygetalluserssortbyname", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> myGetAllusersSortByNome() {
        return userService.findAllUsersSorted();
    }
}
