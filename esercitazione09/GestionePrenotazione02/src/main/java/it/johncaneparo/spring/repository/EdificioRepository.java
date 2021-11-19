package it.johncaneparo.spring.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import it.johncaneparo.spring.model.Edificio;

@Component
public interface EdificioRepository extends JpaRepository<Edificio, Long> {
	
	@Query("SELECT e FROM Edificio e WHERE e.nome =:nome")
	public Edificio findEdificioByNome(String nome);
	
	public Page<Edificio> findAll(Pageable pageable);
	
	public List<Edificio> findByOrderByNomeAsc();
}
