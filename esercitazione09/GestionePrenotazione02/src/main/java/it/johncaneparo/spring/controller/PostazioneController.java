package it.johncaneparo.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.johncaneparo.spring.model.Postazione;
import it.johncaneparo.spring.model.TipoPostazione;
import it.johncaneparo.spring.service.EdificioService;
import it.johncaneparo.spring.service.PostazioneService;

@RestController
@RequestMapping("/postazionecontroller")
public class PostazioneController {
	@Autowired
	private PostazioneService postazioneService;
	
	@Autowired
	private EdificioService edificioService;

	@GetMapping("/postazione-tipo-citta")
	public List<Optional<Postazione>> postazioneTipoCitta(@RequestParam TipoPostazione tipo, String citta) {
		return postazioneService.findPostazioneByTipoCitta(tipo, citta);
		// LINK:
		// http://localhost:8080/postazionecontroller/postazione-tipo-citta?tipo=OPENSPACE&citta=Roma
		// Tipo = PRIVATO OPENSPACE SALA_RIUNIONI
	}

	@GetMapping("/getpostazioneall")
	public List<Postazione> getPostazioneAll() {
		List<Postazione> lp = postazioneService.findAllPostazione();
		return lp;
	}

//	@GetMapping("/getpostazionebycodice/{coidce}")
//	public Postazione getPostazioneByCodice(String codice) {
//		Postazione p = postazioneService.findPostazioneByCodice(codice);
//		return p;
//	}
	
	@GetMapping("/getpostazionebyid/{id}")
	public Optional<Postazione> getPostazioneById(@PathVariable(required = true) long id) {
		Optional<Postazione> p = postazioneService.findPostazioneById(id);
		return p;
	}
	
	@GetMapping("/savepostazione")
	public void savePostazione(@RequestParam String codice, String descrizione, Integer numeroMassimoOccupanti, TipoPostazione tipo, String edificio) {
		postazioneService.insertPostazione(codice, descrizione, numeroMassimoOccupanti, tipo, edificioService.findEdificioByNome(edificio));
	}
	
    @GetMapping(value = "/getallpostazionepagesizesort", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Postazione>> getAllPostazionePageSizeSort(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "2") Integer size, @RequestParam(defaultValue = "id") String sort) {
      List<Postazione> list = postazioneService.findAllPostazionePageSizeSort(page, size, sort);
      return new ResponseEntity<List<Postazione>>(list, new HttpHeaders(), HttpStatus.OK); 
    }
    
    //Sorting
    @GetMapping(value = "/getallpostazionesortbycodice", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Postazione> getAllpostazioneSortByCodice() {
        return postazioneService.findAllPostazioneSorted();
    }
}
