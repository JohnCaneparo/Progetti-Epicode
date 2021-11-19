package it.johncaneparo.spring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import it.johncaneparo.spring.model.Postazione;
import it.johncaneparo.spring.model.TipoPostazione;

@Component
public interface PostazioneRepository extends JpaRepository<Postazione, Long> {
		
	@Query("SELECT p FROM Postazione p WHERE p.tipo =:tipo AND p.edificio.citta.nome = :citta")
    List<Optional<Postazione>> findPostazioneByTipoCitta(TipoPostazione tipo, String citta);
	
//	@Query("SELECT p FROM Postazione p WHERE p.codice =:codice")
//	public Postazione findPostazioneByCodice(String codice);
	
	public Page<Postazione> findAll(Pageable pageable);
	
	public List<Postazione> findByOrderByCodiceAsc();
}
