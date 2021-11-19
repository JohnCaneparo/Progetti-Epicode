package it.johncaneparo.spring.controller;

import java.util.List;

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

import it.johncaneparo.spring.model.Edificio;
import it.johncaneparo.spring.model.User;
import it.johncaneparo.spring.service.CittaService;
import it.johncaneparo.spring.service.EdificioService;

@RestController
@RequestMapping("/edificiocontroller")
public class EdificioController {
	@Autowired
	private EdificioService edificioService;
	
	@Autowired
	private CittaService cittaService;
	
	@GetMapping("/getedificioall")
	public List<Edificio> getEdificioAll(){
		List<Edificio> le = edificioService.findAllEdificio();
		return le;
	}
	
	@GetMapping("/getedificiobynome/{nome}")
	public Edificio getEdificioByNome(@PathVariable (required = true) String nome) {
		Edificio e = edificioService.findEdificioByNome(nome);
		return e;
	}
	
	@GetMapping("/saveedificio")
	public void salvaEdificio(String nome, String indirizzo, String citta) {
		edificioService.insertEdificio(nome, indirizzo, cittaService.findCittaByNome(citta));
	}
	
    @GetMapping(value = "/getalledificiopagesizesort", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Edificio>> getAllEdificioPageSizeSort(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "2") Integer size, @RequestParam(defaultValue = "id") String sort) {
      List<Edificio> list = edificioService.findAllEdificioPageSizeSort(page, size, sort);
      return new ResponseEntity<List<Edificio>>(list, new HttpHeaders(), HttpStatus.OK); 
    }
    
    //Sorting
    @GetMapping(value = "/getalledificiosortbyname", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Edificio> getAllEdificioSortByNome() {
        return edificioService.findAllEdificioSorted();
    }
}
