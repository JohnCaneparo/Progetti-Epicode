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

import it.johncaneparo.spring.model.Citta;
import it.johncaneparo.spring.service.CittaService;

@RestController
@RequestMapping("/cittacontroller")
public class CittaController {
	@Autowired
	private CittaService cittaService;
	
	@GetMapping("/getcittaall")
	public List<Citta> getCittaAll(){
		List<Citta> lc = cittaService.findAllCitta();
		return lc;
	}
	
	@GetMapping("/getcittabynome/{nome}")
	public Citta getCittaByNome(@PathVariable(required = true) String nome){
		Citta c = cittaService.findCittaByNome(nome);
		return c;
	}
	
	@GetMapping("/salvacitta")
	public void salvaCitta(@RequestParam String nome) {
		cittaService.insertCitta(nome);
	}
	
	 @GetMapping(value = "/getallcittapagesizesort", produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<List<Citta>> getAllCittaPageSizeSort(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "2") Integer size, @RequestParam(defaultValue = "id") String sort) {
	      List<Citta> list = cittaService.findAllCittaPageSizeSort(page, size, sort);
	      return new ResponseEntity<List<Citta>>(list, new HttpHeaders(), HttpStatus.OK); 
	    }
	    
	    //Sorting
	    @GetMapping(value = "/getallcittasortbynome", produces = MediaType.APPLICATION_JSON_VALUE)
	    public List<Citta> getAllCittaSortByNome() {
	        return cittaService.findAllCittaSorted();
	    }
	
}
