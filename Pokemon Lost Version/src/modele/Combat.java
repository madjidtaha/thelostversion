package modele;

import java.util.*;

public class Combat implements Type {
	Scanner sc = new Scanner(System.in);
	Dresseur heros;
	boolean pkmnsauvage; //Si vrai, le Pokémon est sauvage.
		//Constructeur d'un combat contre un Pokémon sauvage.
	
	
	
	public Attaque attaqueAleatoire(Pokemon p){
		int aleatoire = (int) (Math.random()*5);
		while(p.getAttaques(aleatoire).getType()==-1){
			aleatoire = (int) (Math.random()*5);
		}
		return p.getAttaques(aleatoire);
	}
	public int choixCombat(){
		System.out.println("(0)Debug test defaite(0) Tapez 1 pour attaquer, 2 pour Pokemon, 3 pour Objets, 4 pour fuir");
		int str = sc.nextInt();
		
		while(str < 0 || str > 4){
			System.out.println("Ce choix n'est pas disponible, tapez 1 pour attaquer");
			str = sc.nextInt();
		}
		
		return str;
	}
	public void attaque(Pokemon attaque, Pokemon defense){
		//Le calcul des degats est complexe, je vais donc le decomposer
		//Le calcul est : ((((NiveauAttaquant*0.4+2)*StatATKAttaquant*PuissancedeLattaqueLancé)/StatDEFDefenceur*50)+2)*CoefficientdEfficatite
		double etape1 = ((attaque.getNiv()*0.4+2)*attaque.getAtk()*attaque.getAttaque1().getPuissance());
		double etape2 = (defense.getDef()*50);
		double etape3 = (etape1/etape2)+2;
		double etape4 = (etape3*calculerCE(attaque.getAttaque1().getType(), defense.getType1(), defense.getType2()));
		int pvPerdu = (int)etape4;
		//System.out.println("ennemi.getNiv() "+sauvage.getNiv()+" ennemi.getAtk() "+sauvage.getAtk()+" ennemi.getAttaque1().getPuissance() "+sauvage.getAttaque1().getPuissance()+" heros.getDef() "+heros.getPokemon1().getDef());
		/*Si le nombre de degat est superieur au nombre de PV restant du Pokémon
		 * je soustrait le nombre de PV restant à lui meme afin de ne pas tomber
		 * sur un nombre negatif
		 */
		if(defense.getPV()-pvPerdu<=0)
			defense.setPV(defense.getPV()-defense.getPV());
		else
			defense.setPV(defense.getPV()-pvPerdu);
	}
	//Cette fonction permet de calculer du coefficient d'efficacité
	public double calculerCE(int TypeAtk, int Type1, int Type2){
		double CE1=1; double CE2=1; double CET=1;
		if(TypeAtk == ELECTRIK){
			//CE1
			if(Type1==VOL)
				CE1=2;
			if(Type1==ELECTRIK)
				CE1=0.5;
			//CE2
			if(Type2==VOL)
				CE2=2;
			if(Type2==ELECTRIK)
				CE2=0.5;
		}
		if(TypeAtk == INSECTE){
			//CE1
			if(Type1==VOL||Type1==POISON)
				CE1=0.5;
			//CE2
			if(Type2==VOL || Type2==POISON)
				CE2=0.5;
		}
		if(TypeAtk == POISON){
			//CE1
			if(Type1==POISON)
				CE1=0.5;
			//CE2
			if(Type2==POISON)
				CE2=0.5;
		}
		if(TypeAtk == VOL){
			//CE1
			if(Type1==INSECTE)
				CE1=2;
			if(Type1==ELECTRIK)
				CE1=0.5;
			//CE2
			if(Type2==INSECTE)
				CE2=2;
			if(Type2==ELECTRIK)
				CE2=0.5;
		}
		
		
		CET=CE1*CE2;	
		return CET;
	}
	public boolean calculerVitesse(Pokemon p1, Pokemon p2){
		if(p1.getVit()>p2.getVit())
			return true;
		else
			return false;
	}
	
}