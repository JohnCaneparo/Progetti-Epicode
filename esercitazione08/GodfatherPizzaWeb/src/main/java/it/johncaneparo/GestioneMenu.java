package it.johncaneparo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class GestioneMenu {

	private Menu menu;
	
	AnnotationConfigApplicationContext myContext = new AnnotationConfigApplicationContext(MenuConfig.class);
	MenuConfig menuConfig = myContext.getBean(MenuConfig.class);

	public GestioneMenu() {
		menu = menuConfig.creaMenu();
	}

	public void stampaMenu() {
//		
//		System.out.println();
//		System.out.println("============");
//		System.out.println("|Menu Pizza|");
//		System.out.println("============");
//		menuConfig.creaMenu().stampaPizza();
//		System.out.println();
//		System.out.println("==============");
//		System.out.println("|Menu Topping|");
//		System.out.println("==============");
//		menuConfig.creaMenu().stampaTopping();
//		System.out.println();
//		System.out.println("============");
//		System.out.println("|Menu Drink|");
//		System.out.println("============");
//		menuConfig.creaMenu().stampaDrink();
//		System.out.println();
//		System.out.println("=================");
//		System.out.println("|Lista Franchise|");
//		System.out.println("=================");
//		menuConfig.creaMenu().stampaFranchise();
//		
////		myContext.close();
		
	}
}
