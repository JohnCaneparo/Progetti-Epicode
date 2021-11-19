package it.johncaneparo.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import it.johncaneparo.spring.model.Edificio;
import it.johncaneparo.spring.model.Postazione;
import it.johncaneparo.spring.model.TipoPostazione;
import it.johncaneparo.spring.repository.PostazioneRepository;

@Service
public class PostazioneService {
	@Autowired
	PostazioneRepository postazioneRepository;
	
	public List<Postazione> findAllPostazione() {
        return postazioneRepository.findAll();
    }
    
//	 public Postazione findPostazioneByCodice(String codice) {
//	        return postazioneRepository.findPostazioneByCodice(codice);
//	    }
	
    public Optional<Postazione> findPostazioneById(long id) {
        return postazioneRepository.findById(id);
    }
	
    public Postazione myFindPostazioneById(long id) {
        return postazioneRepository.getById(id);
    }
    
    public List<Optional<Postazione>> findPostazioneByTipoCitta(TipoPostazione tipo, String citta){
    	return postazioneRepository.findPostazioneByTipoCitta(tipo, citta);    	
    }
    
    public void insertPostazione(String codice, String descrizione, Integer numeroMassimoOccupanti, TipoPostazione tipo,
			Edificio edificio) {
    	postazioneRepository.save(new Postazione(codice, descrizione,numeroMassimoOccupanti, tipo,
    		edificio));
    }
    
    public List<Postazione> findAllPostazionePageSizeSort(Integer page, Integer size, String sort) {
        Pageable paging = PageRequest.of(page, size, Sort.by(sort));
        Page<Postazione> pagedResult = postazioneRepository.findAll(paging);
        if (pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Postazione>();
        }
    }
    
    // Ordinamento
    public List<Postazione> findAllPostazioneSorted() {
        return postazioneRepository.findByOrderByCodiceAsc();
    }
}
