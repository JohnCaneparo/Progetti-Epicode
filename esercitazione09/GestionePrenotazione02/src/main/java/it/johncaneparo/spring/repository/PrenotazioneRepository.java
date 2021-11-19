package it.johncaneparo.spring.repository;


import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import it.johncaneparo.spring.model.Prenotazione;

@Component
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {
		
	@Query("SELECT pre FROM Prenotazione pre WHERE pre.user.id =:id AND pre.dataPrenotata =:dataPrenotata")
	public List<Prenotazione> findPrenotazioniByUserData(long id, LocalDate dataPrenotata);
	
	public Page<Prenotazione> findAll(Pageable pageable);
	
	public List<Prenotazione> findByOrderByIdAsc();
}
