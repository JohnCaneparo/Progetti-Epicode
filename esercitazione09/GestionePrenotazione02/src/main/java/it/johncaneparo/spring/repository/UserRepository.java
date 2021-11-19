package it.johncaneparo.spring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import it.johncaneparo.spring.model.User;

@Component
public interface UserRepository extends JpaRepository<User, Long> {
		
	@Query("SELECT u FROM User u WHERE u.username =:username")
	public User findUserByUsername(String username);
	
	/* Paging */
	public Page<User> findAll(Pageable pageable);
	
	/* Sort */
    // Formula: findBy + OrderBy + NomeColonna + Ordinamento(Asc/Desc)
    public List<User> findByOrderByNomeAsc();
    
    Optional<User> findByUsername(String username);
}
