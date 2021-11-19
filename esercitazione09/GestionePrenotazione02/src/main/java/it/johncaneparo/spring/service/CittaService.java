package it.johncaneparo.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import it.johncaneparo.spring.model.Citta;
import it.johncaneparo.spring.repository.CittaRepository;

@Service
public class CittaService {
	@Autowired
	CittaRepository cittaRepository;
	
	public List<Citta> findAllCitta() {
        return cittaRepository.findAll();
    }
	
	public Citta findCittaById(long id) {
		return cittaRepository.getById(id);
	}
    
    public Citta findCittaByNome(String nome) {
        return cittaRepository.findCittaByNome(nome);
    }
    
    public void insertCitta(String nome) {
        cittaRepository.save(new Citta(nome));
    }
    
    public List<Citta> findAllCittaPageSizeSort(Integer page, Integer size, String sort) {
        Pageable paging = PageRequest.of(page, size, Sort.by(sort));
        Page<Citta> pagedResult = cittaRepository.findAll(paging);
        if (pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Citta>();
        }
    }
    
    // Ordinamento
    public List<Citta> findAllCittaSorted() {
        return cittaRepository.findByOrderByNomeAsc();
    }

}
