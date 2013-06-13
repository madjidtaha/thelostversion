package modele;

import java.util.Scanner;

public class TestCombat {
	public static void main(String[] args){
		Heros blue = new Heros();
		Red red = new Red();
		
		boolean combatTest = false;
		while (!combatTest){
			new CombatDresseur(blue, red);
			System.out.println("Continuer? Oui 1, Non 0");
			blue.getPokemon1().soigner();
			if(test() == 0)
				combatTest = true;
			
		}
		
		//CombatDresseur combat1 = new CombatDresseur(blue, red);
		
		
	}
	public static int test(){
		Scanner sc = new Scanner(System.in);
		int str = sc.nextInt();
		while(str < 0 || str > 2){
			System.out.println("Ce choix n'est pas disponible, tapez 1 pour attaquer");
			str = sc.nextInt();
		}
		
		return str;
	}
}
