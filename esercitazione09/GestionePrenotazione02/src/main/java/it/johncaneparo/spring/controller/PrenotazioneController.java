package it.johncaneparo.spring.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.johncaneparo.spring.model.Prenotazione;
import it.johncaneparo.spring.model.User;
import it.johncaneparo.spring.service.PostazioneService;
import it.johncaneparo.spring.service.PrenotazioneService;
import it.johncaneparo.spring.service.UserService;

@RestController
@RequestMapping("/prenotazionecontroller")
public class PrenotazioneController {
	@Autowired
	private PrenotazioneService prenotazioneService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PostazioneService postazioneService;
	
	@GetMapping("/creaprenotazione")
	public String creaPrenotazione(@RequestParam long userId, long postazioneId, @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dataPrenotata) {
		
		if(prenotazioneService.diffGiorni(dataPrenotata) && prenotazioneService.listaPrenUserData(userId, dataPrenotata)) {
			prenotazioneService.savePrenotazione(userService.myFindUserById(userId), postazioneService.myFindPostazioneById(postazioneId), dataPrenotata);
			return "<h2><i>Prenotazione inserita correttamente!</i></h2><br><br><br><a href=\"http://localhost:8081/\"><button>Nuova Prenotazione</button></a>";
		} else {
			System.out.println("ERRORE: scegliere una nuova data");
			return "<h2>ERRORE DATA NON DISPONIBILE</h2><br><br><a href=\"http://localhost:8081/\"><i>Scegliere una nuova data</i></a>";
		}
	}
	
	@GetMapping("/getprenotazioneall")
	public List<Prenotazione> getPrenotazioneAll() {
		List<Prenotazione> lp = prenotazioneService.findAllPrenotazione();
		return lp;
	}
	
	@GetMapping("/getprenotazionebyid/{id}")
	public Optional<Prenotazione> getPrenotazioneById(@PathVariable(required = true) long id) {
		Optional<Prenotazione> p = prenotazioneService.getPrenotazioneById(id);
		return p;
	}
	
//	@GetMapping(path = "/prenotazione/{id}")
//    public ResponseEntity<Prenotazione> findById(@PathVariable(required = true) Long id) {
//        Optional<Prenotazione> find = prenotazioneService.getPrenotazioneById(id);
//        if (find.isPresent()) {
//            return new ResponseEntity<>(find.get(), HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
//        }
//
//    }
	
    @GetMapping(value = "/getallprenotazionepagesizesort", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Prenotazione>> getAllPrenotazionePageSizeSort(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "2") Integer size, @RequestParam(defaultValue = "id") String sort) {
      List<Prenotazione> list = prenotazioneService.findAllPrenotazionePageSizeSort(page, size, sort);
      return new ResponseEntity<List<Prenotazione>>(list, new HttpHeaders(), HttpStatus.OK); 
    }
    
    //Sorting
    @GetMapping(value = "/getallprenotazionesortbyid", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Prenotazione> getAllPrenotazioneSortByNome() {
        return prenotazioneService.findAllPrenotazioneSorted();
    }
}
