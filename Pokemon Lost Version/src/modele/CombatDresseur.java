package modele;

public class CombatDresseur extends Combat {
	Dresseur adversaire;
	CombatDresseur(Dresseur h, Dresseur e) {
		heros = h;
		adversaire = e;
		this.declencherCombat();
	}
	public void declencherCombat(){
		boolean victoire = false;
		boolean defaite = false;	
		int choix;
		System.out.println(adversaire.getNom()+" veux se battre !");
		System.out.println(adversaire.getNom()+" envoie "+adversaire.getPokemon1().getNom());
		System.out.println("En avant "+heros.getPokemon1().getNom()+" !");
		while(victoire == false || defaite == false){
			//DEBUGPV
			System.out.println(heros.getPokemon1().getNom()+" : "+heros.getPokemon1().getPV()+" PV");
			System.out.println(adversaire.getPokemon1().getNom()+" ennemi : "+adversaire.getPokemon1().getPV()+" PV");
			//DEBUGPV
			choix = choixCombat();
			 if(choix == 0){
			    	if (this.calculerVitesse(heros.getPokemon1(), adversaire.getPokemon1())){
			    		System.out.println(heros.getPokemon1().getNom()+" ne veux pas attaquer!");
			    		System.out.println(adversaire.getPokemon1().getNom()+" envoie "+adversaire.getPokemon1().getAttaque1().getNom());
			    		attaque(adversaire.getPokemon1(), heros.getPokemon1());
			    	}
			    	else{
			    		System.out.println(adversaire.getPokemon1().getNom()+" envoie "+adversaire.getPokemon1().getAttaque1().getNom());
			    		attaque(adversaire.getPokemon1(), heros.getPokemon1());
			    		System.out.println(heros.getPokemon1().getNom()+" ne veux pas attaquer!");
			    	}
			 }
			if(choix == 1){
			   	defaite = verifierDefaite(heros.getPokemon1());
			  	if (this.calculerVitesse(heros.getPokemon1(), adversaire.getPokemon1())){
			   		System.out.println(heros.getPokemon1().getNom()+" envoie "+heros.getPokemon1().getAttaque1().getNom());
			   		attaque(heros.getPokemon1(), adversaire.getPokemon1());
			   		victoire = verifierDefaite(adversaire.getPokemon1());
			   		if(victoire){
			    		break;
			    	}
			   		System.out.println(adversaire.getPokemon1().getNom()+" envoie "+adversaire.getPokemon1().getAttaque1().getNom());
			   		attaque(adversaire.getPokemon1(), heros.getPokemon1());
			   	}
			   	else{
			   		System.out.println(adversaire.getPokemon1().getNom()+" envoie "+adversaire.getPokemon1().getAttaque1().getNom());
			   		attaque(adversaire.getPokemon1(), heros.getPokemon1());
			   		defaite = verifierDefaite(adversaire.getPokemon1());
			   		if(defaite){
			    		break;
			    	}
			   		System.out.println(heros.getPokemon1().getNom()+" envoie "+heros.getPokemon1().getAttaque1().getNom());
			   		attaque(heros.getPokemon1(), adversaire.getPokemon1());
			   	}
			 if(choix == 4){
					System.out.println("On ne pas fuire d'un combat de dresseur!");
			   	}
			}
			}
						 
					 	
			    	/*System.out.println(adversaire.getPokemon1().getNom()+" envoie "+adversaire.getPokemon1().getAttaque1().getNom()+" !");
					System.out.println(this.attaque()); */
			    
		}
	public boolean verifierDefaite(Pokemon p){
		if(p.getPV() == 0)
			return true;
		else
			return false;
	}
}