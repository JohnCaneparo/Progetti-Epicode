package it.epicode.esercizio1;

public class Rettangolo {
	private double altezza;
	private double larghezza;
	
	public double getAltezza() {
		return altezza;
	}
	public void setAltezza(double altezza) {
		this.altezza = altezza;
	}
	public double getLarghezza() {
		return larghezza;
	}
	public void setLarghezza(double larghezza) {
		this.larghezza = larghezza;
	}
	
	public static void stampaRettangolo(Rettangolo ret1) {
		double periR = perimetroRettangolo(ret1.getAltezza(), ret1.getLarghezza());
		System.out.println("Il perimetro del rettangolo �: " + periR);
		
		double areaR = areaRettangolo(ret1.getAltezza(), ret1.getLarghezza());
		System.out.println("L'area del rettangolo �: " + areaR);
	}
	
	public static void stampaDueRettangoli(Rettangolo ret1, Rettangolo ret2) {
		double periR1 = perimetroRettangolo(ret1.getAltezza(), ret1.getLarghezza());
		System.out.println("Il perimetro del primo rettangolo �: " + periR1);
		
		double areaR1 = areaRettangolo(ret1.getAltezza(), ret1.getLarghezza());
		System.out.println("L'area del primo rettangolo �: " + areaR1);
		
		double periR2 = perimetroRettangolo(ret2.getAltezza(), ret2.getLarghezza());
		System.out.println("Il perimetro del secondo rettangolo �: " + periR2);
		
		double areaR2 = areaRettangolo(ret2.getAltezza(), ret2.getLarghezza());
		System.out.println("L'area del secondo rettangolo �: " + areaR2);
		
		double sommaPerimetri = periR1 + periR2;
		double sommaAree = areaR1 + areaR2;
		System.out.println("La somma dei perimetri dei due rettangoli �: " + sommaPerimetri);
		System.out.println("La somma delle aree dei due rettangoli �: " + sommaAree);

	}

	public static double perimetroRettangolo(double altezza, double larghezza) {
		double perimetro = (altezza + larghezza) * 2;
		return perimetro;
	}
	
	public static double areaRettangolo(double altezza, double larghezza) {
		double area = altezza * larghezza;
		return area;
	}
}
