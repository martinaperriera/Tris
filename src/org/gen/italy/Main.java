package org.gen.italy;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// dichiarazione matrice string 3x3
		String[][] campo = new String[3][3];

		// dichiarazione variabili
		int r, c, cont, giocatore, nr, nc;
		Scanner sc = new Scanner(System.in);
		boolean vittoria=true;

		// scorro tutte le righe da 0 a 3 e tutte le colonne da 0 a 3
		for (r = 0; r <= 2; r++)
			for (c = 0; c <= 2; c++)
				campo[r][c] = "-"; // questi due for servono a inserire i trattini vuoti dove poi andranno le x

		cont = 0; // conta quante X ci sono nel campo (all'inizio 0)
		giocatore = 1;

		do {
			System.out.println("\n\n\n\n\n\n\n\n\n\n"); // indica una nuova linea a capo \n = vai a capo (con il
														// backslash)
			// stampa matrice
			for (r = 0; r <= 2; r++) { // per ogni riga
				// stampo la riga
				for (c = 0; c <= 2; c++)
					System.out.print(campo[r][c] + " "); // stampo il campo - non ln perché non va a capo - va a capo
															// quando finisce la riga
				// vado a capo
				System.out.println();
			}

			System.out.println("Giocatore:" + giocatore); // in questo modo viene indicata la variabile giocatore
			if (giocatore == 1)
				System.out.println("Dove vuoi metter la x?");
			else
				System.out.println("Dove vuoi mettere lo 0?");

			r = sc.nextInt();
			c = sc.nextInt();
			sc.nextLine();

			if (campo[r][c].equals("X")) // .equals serve a confrontare due stringhe, per vedere se la casella campo r c
											// coincide con il valore x
				System.out.println("Casella già occupata");
			else { // mettiamo la graffa perché è un'altra istruzione
				if (giocatore == 1) {
					campo[r][c] = "X"; // se il giocatore è 1 metto la x
					giocatore = 2; // se prima era 1, diventa 2 e viceversa (in questo modo si possono susseguire
				} else {
					campo[r][c] = "0"; // se il giocatore è 2 si mette lo 0
					giocatore = 1;
				}

				cont = cont + 1; // o cont++; è lo stesso

			}
			System.out.print("Premi invio per continuare...");
			sc.nextLine();

			for (r = 0; r <= 2; r++)
				if ((campo[r][0] == "X" && campo[r][1] == "X" && campo[r][2] == "X") // confronto le varie caselle
						|| (campo[0][c] == "X" && campo[1][c] == "X" && campo[2][c] == "X")
						|| (campo[0][0] == "X" && campo[1][1] == "X" && campo[2][2] == "X")
						|| (campo[0][2] == "X" && campo[1][1] == "X" && campo[2][0] == "X")) {
					System.out.println("giocatore 1 vince");
					vittoria = true;
					break;

				} else if ((campo[r][0] == "0" && campo[r][1] == "0" && campo[r][1] == "0")
						|| (campo[0][c] == "0" && campo[1][c] == "0" && campo[2][c] == "0")
						|| (campo[0][0] == "0" && campo[1][1] == "0" && campo[2][2] == "0")
						|| (campo[0][2] == "0" && campo[1][1] == "0" && campo[2][0] == "0")) {
					System.out.println("giocatore 2 vince");
					vittoria = true;
					break;
				}

		} while (cont < 9 || vittoria==true); // torna indietro se cont<9 (quindi non abbiamo occupato tutte le caselle che
							// sono 9
		if (vittoria==false)
			System.out.println("Pareggio!");

	}
}
