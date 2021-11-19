package it.epicode.esercizio1;

import java.util.Scanner;

public class RettangoloMain {

	public static void main(String[] args) {
		Rettangolo ret1 = new Rettangolo();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Inserire altezza del rettangolo:");	
		ret1.setAltezza(sc.nextDouble());
		System.out.println("Inserire larghezza del rettangolo: ");
		ret1.setLarghezza(sc.nextDouble());
		
		ret1.stampaRettangolo(ret1);
	
		Rettangolo ret2 = new Rettangolo();
		System.out.println("Inserire altezza del secondo rettangolo:");	
		ret2.setAltezza(sc.nextDouble());
		System.out.println("Inserire larghezza del secondo rettangolo: ");
		ret2.setLarghezza(sc.nextDouble());
		
		ret1.stampaDueRettangoli(ret1, ret2);
	}
	
}
