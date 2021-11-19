package it.epicode.esercitazione02;

import java.util.Scanner;

public class LettoreMultimediale {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		LettoreMultimediale l1 = new LettoreMultimediale();
		
		ElementoMultimediale[] l2 = l1.popolaListaElementi();
		
		int a = 0;
		do {
			System.out.println();
			System.out.println("===========================================");
			System.out.println("Quale elemento della lista vuoi riprodurre? \nInserisci un numero da 1 a 5 \nDigitare 0 se vuoi terminare.");
			a = sc.nextInt();
			
			switch(a) {
			case 1:
				if(l2[0] instanceof Audio) {
					((Audio)l2[0]).play();
					} else if (l2[0] instanceof Video) {
						((Video)l2[0]).play();
					} else if (l2[0] instanceof Immagine) {
						((Immagine)l2[0]).show();
					} break;
			case 2:
				if(l2[1] instanceof Audio) {
					((Audio)l2[1]).play();
					} else if (l2[1] instanceof Video) {
						((Video)l2[1]).play();
					} else if (l2[1] instanceof Immagine) {
						((Immagine)l2[1]).show();
					} break;
			case 3:
				if(l2[2] instanceof Audio) {
					((Audio)l2[2]).play();
					} else if (l2[2] instanceof Video) {
						((Video)l2[2]).play();
					} else if (l2[2] instanceof Immagine) {
						((Immagine)l2[2]).show();
					} break;
			case 4:
				if(l2[0] instanceof Audio) {
					((Audio)l2[3]).play();
					} else if (l2[3] instanceof Video) {
						((Video)l2[3]).play();
					} else if (l2[3] instanceof Immagine) {
						((Immagine)l2[3]).show();
					} break;
			case 5:
				if(l2[4] instanceof Audio) {
					((Audio)l2[4]).play();
					} else if (l2[4] instanceof Video) {
						((Video)l2[4]).play();
					} else if (l2[4] instanceof Immagine) {
						((Immagine)l2[4]).show();
					} break;
			case 0:
				System.out.println("Fine riproduzione.");
				return;
			}
		} while(a!=0);
		
	}

	public ElementoMultimediale[] popolaListaElementi() {
		Scanner sc = new Scanner(System.in);
		ElementoMultimediale[] listaElementi = new ElementoMultimediale[5];
		
		for (int i = 0; i < 5; i++) {
			int a = 0;
			
			System.out.println();
			System.out.println("=====================================================");
			System.out.println(
					"Scegliere che tipo di Elemento Multimediale inserire: \n1 = Audio \n2 = Video \n3 = Immagine");
			a = sc.nextInt();
			
			switch (a) {
			case 1:
				listaElementi[i] = inserisciAudio();
				System.out.println("Hai inserito " + (i + 1) + " elementi nella lista elementi multimediali.");
				break;
			case 2:
				listaElementi[i] = inserisciVideo();
				System.out.println("Hai inserito " + (i + 1) + " elementi nella lista elementi multimediali.");
				break;
			case 3:
				listaElementi[i] = inserisciImmagine();
				System.out.println("Hai inserito " + (i + 1) + " elementi nella lista elementi multimediali.");
				break;
			default:
				System.out.println("ERROR! Inserire 1 per audio, 2 per video, 3 per immagine.");
			}
		}
		return listaElementi;
	}

	public ElementoMultimediale inserisciAudio() {
		Scanner sc = new Scanner(System.in);
		String titoloAudio;
		int durataAudio;
		int volumeAudio;

		System.out.println("Inserisci il titolo dell'audio:");
		titoloAudio = sc.nextLine();
		System.out.println("Inserisci la durata dell'audio:");
		durataAudio = sc.nextInt();
		System.out.println("Inserisci il volume dell'audio:");
		volumeAudio = sc.nextInt();

		ElementoMultimediale audio = new Audio(titoloAudio, durataAudio, volumeAudio);
		return audio;
	}

	public ElementoMultimediale inserisciVideo() {
		Scanner sc = new Scanner(System.in);

		String titoloVideo;
		int durataVideo;
		int volumeVideo;
		int luminositaVideo;

		System.out.println("Inserisci il titolo del video:");
		titoloVideo = sc.nextLine();
		System.out.println("Inserisci la durata del video:");
		durataVideo = sc.nextInt();
		System.out.println("Inserisci il volume del video:");
		volumeVideo = sc.nextInt();
		System.out.println("Inserisci la luminosità del video:");
		luminositaVideo = sc.nextInt();

		ElementoMultimediale video = new Video(titoloVideo, durataVideo, volumeVideo, luminositaVideo);
		return video;
	}

	public ElementoMultimediale inserisciImmagine() {
		Scanner sc = new Scanner(System.in);

		String titoloImmagine;
		int luminositaImmagine;

		System.out.println("Inserisci il titolo della immagine:");
		titoloImmagine = sc.nextLine();
		System.out.println("Inserisci la luminosità della immagine:");
		luminositaImmagine = sc.nextInt();

		ElementoMultimediale immagine = new Immagine(titoloImmagine, luminositaImmagine);
		return immagine;
	}

}
