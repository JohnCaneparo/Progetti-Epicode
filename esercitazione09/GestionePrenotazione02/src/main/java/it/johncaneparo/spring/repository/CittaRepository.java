package it.johncaneparo.spring.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import it.johncaneparo.spring.model.Citta;

@Component
public interface CittaRepository extends JpaRepository<Citta, Long> {
	
//	public Page<MyUser> findAll(Pageable pageable);
	
	@Query("SELECT c FROM Citta c WHERE c.nome =:nome")
	public Citta findCittaByNome(String nome);
	
	public Page<Citta> findAll(Pageable pageable);
	
	public List<Citta> findByOrderByNomeAsc();
}
