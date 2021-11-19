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

import it.johncaneparo.spring.model.Citta;
import it.johncaneparo.spring.model.Edificio;
import it.johncaneparo.spring.repository.EdificioRepository;

@Service
public class EdificioService {
	@Autowired
	EdificioRepository edificioRepository;
	
	public List<Edificio> findAllEdificio() {
        return edificioRepository.findAll();
    }
    
    public Edificio findEdificioByNome(String nome) {
        return edificioRepository.findEdificioByNome(nome);
    }
    
    public void insertEdificio(String nome,String indirizzo, Citta citta) {
    	edificioRepository.save(new Edificio(nome, indirizzo, citta));
    }
    
    public List<Edificio> findAllEdificioPageSizeSort(Integer page, Integer size, String sort) {
        Pageable paging = PageRequest.of(page, size, Sort.by(sort));
        Page<Edificio> pagedResult = edificioRepository.findAll(paging);
        if (pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Edificio>();
        }
    }
    
    // Ordinamento
    public List<Edificio> findAllEdificioSorted() {
        return edificioRepository.findByOrderByNomeAsc();
    }
}
