package it.johncaneparo.spring.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import it.johncaneparo.spring.model.Postazione;
import it.johncaneparo.spring.model.Prenotazione;
import it.johncaneparo.spring.model.User;
import it.johncaneparo.spring.repository.PrenotazioneRepository;

@Service
public class PrenotazioneService {
	@Autowired
	PrenotazioneRepository prenotazioneRepository;
	
	public List<Prenotazione> findAllPrenotazione() {
        return prenotazioneRepository.findAll();
    }
    
    public Optional<Prenotazione> getPrenotazioneById(long id) {
        return prenotazioneRepository.findById(id);
    }
    
    public void savePrenotazione(User user, Postazione postazione, LocalDate dataPrenotata) {
    	prenotazioneRepository.save(new Prenotazione(user, postazione, dataPrenotata));
    }
    
    public boolean diffGiorni(LocalDate dataPrenotata) {
    	return LocalDate.now().isBefore(dataPrenotata.minusDays(2));
    }
    
    public boolean listaPrenUserData (long id, LocalDate date) {
    	List<Prenotazione> lista = prenotazioneRepository.findPrenotazioniByUserData(id, date);
    	if(lista.isEmpty()) {
    		return true;
    	} else return false;
    }
    
    public List<Prenotazione> findAllPrenotazionePageSizeSort(Integer page, Integer size, String sort) {
        Pageable paging = PageRequest.of(page, size, Sort.by(sort));
        Page<Prenotazione> pagedResult = prenotazioneRepository.findAll(paging);
        if (pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Prenotazione>();
        }
    }
    
    // Ordinamento
    public List<Prenotazione> findAllPrenotazioneSorted() {
        return prenotazioneRepository.findByOrderByIdAsc();
    }
}
