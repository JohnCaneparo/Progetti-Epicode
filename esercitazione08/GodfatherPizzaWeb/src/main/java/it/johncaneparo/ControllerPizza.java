package it.johncaneparo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControllerPizza {
	private AnnotationConfigApplicationContext myContext = new AnnotationConfigApplicationContext(MenuConfig.class);
	GestioneOrdine go = new GestioneOrdine();
	
	@GetMapping("/menu")
	public ModelAndView menu() {
		
		ModelAndView vistaMenu = new ModelAndView("menu");
		Menu menu = (Menu) myContext.getBean("creaMenu");
		vistaMenu.addObject("menu", menu);
		return vistaMenu;
	}
	
	@GetMapping("/listaordini")
	public ModelAndView listaOrdini() {
		ModelAndView viewOrdini = new ModelAndView("listaordini");
		viewOrdini.addObject("listaordini", GestioneOrdine.listaOrdini);
		return viewOrdini;
	}

	@GetMapping("/order/{id}")
	public ModelAndView myOrder(@PathVariable int id)  {
		Ordine order = go.getOrdineById(id);
		ModelAndView myView = new ModelAndView("order");
		myView.addObject("ordine", order);
		return myView;
	}
}