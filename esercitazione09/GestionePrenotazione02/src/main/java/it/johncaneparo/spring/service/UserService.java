package it.johncaneparo.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import it.johncaneparo.spring.model.User;
import it.johncaneparo.spring.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public List<User> findAllUsers() {
		return userRepository.findAll();
	}

	public User myFindUserById(long id) {
		return userRepository.getById(id);
	}

	public void insertUser(String usurname, String nome, String email, String password, Boolean active) {
		userRepository.save(new User(usurname, nome, email, password, active));
	}

	public User findUserByUsername(String username) {
		return userRepository.findUserByUsername(username);
	}
	
	// Paginazione
    public Page<User> myFindAllUsersPageable(Pageable pageable) {
        return userRepository.findAll(pageable);
    }
    
    //paginazione con pagina e size dati da parametri della chiamata get
    public Page<User> myFindAllUsersPageSize(Integer page, Integer size) {
        Pageable paging = PageRequest.of(page, size);
        Page<User> pagedResult = userRepository.findAll(paging);
        if(pagedResult.hasContent()) {
      return pagedResult;
      } else {
          return null;
      }
    }
    
    //PAGING AND SORTING CON PAGE, SIZE E SORTING PASSATI COME PARAMETRO ALLA CHIAMATA GET
    public List<User> findAllUsersPageSizeSort(Integer page, Integer size, String sort) {
        Pageable paging = PageRequest.of(page, size, Sort.by(sort));
        Page<User> pagedResult = userRepository.findAll(paging);
        if (pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<User>();
        }
    }
    
    // Ordinamento
    public List<User> findAllUsersSorted() {
        return userRepository.findByOrderByNomeAsc();
    }
}


